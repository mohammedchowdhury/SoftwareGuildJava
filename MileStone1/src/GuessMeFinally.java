import java.util.Random;
import java.util.Scanner;
public class GuessMeFinally {
    public static void main(String[] args) {
        System.out.println(">I've chosen a number between -100 and 100. Bet you can't guess it!");
        Random rand = new Random();
        int randNum = rand.nextInt(101);
        if(rand.nextBoolean()){ //if true flips the number to negative
            randNum = randNum*-1;
        }
        System.out.println(randNum);
        getUserInputNumber("Your guess: ",randNum);
    }

    public static int getUserInputNumber(String message,int randNum) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        int counter = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Integer.parseInt(input); //then converting it your self to a format we want
                if(number==randNum){
                    if(counter==0) {
                        System.out.println("Wow, nice guess! That was it!");
                        return 0;
                    }
                    else {
                        System.out.println("Finally! It's about time you got it!");
                    }
                }else if(number<randNum){
                    System.out.println("Ha, nice try - too low! Try again!");
                }
                else if(number>randNum){
                    System.out.println("Too bad, way too high. Try again!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }
            System.out.println(number);
            counter++;
        } while (isValid == false);
        return number;
    }
}

//I've chosen a number between -100 and 100. Betcha can't guess it!
//        Your guess: 44
//
//        Ha, nice try - too low! Try again!
//        Your guess: 99
//
//        Too bad, way too high. Try again!
//        Your guess: 74
//
//        Ha, nice try - too low! Try again!
//        Your guess: 82
//
//        Finally! It's about time you got it!
