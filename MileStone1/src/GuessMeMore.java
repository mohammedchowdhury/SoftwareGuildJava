import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {
        System.out.println(">I've chosen a number between -100 and 100. Bet you can't guess it!");
        Random rand = new Random();
        int randNum = rand.nextInt(101);
        if(rand.nextBoolean()){ //if true flips the number to negative
            randNum = randNum*-1;
        }
        System.out.println(randNum);
        int userInput = 0;
        userInput = getUserInputNumber("Your guess:");

        if(userInput==randNum){
            System.out.println("Wow, nice guess! That was it!");
            return;
        }
        if(userInput<randNum){
            System.out.println("Ha, nice try - too low!  Try again!");
        }
        if(userInput>randNum){
            System.out.println("Ha, nice try - too high!  Try again!");
        }
        userInput = getUserInputNumber("Your guess:");
        if(userInput==randNum){
            System.out.println("Wow, nice guess! That was it!");
            return;
        }
        if(userInput<randNum){
            System.out.println("Ha, nice try - too low! I chose "+randNum+"." );
        }
        if(userInput>randNum){
            System.out.println("Ha, nice try - too high! I chose "+randNum+".");
        }
    }
    public static int getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Integer.parseInt(input); //then converting it your self to a format we want
                if (number >= -100) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
}
