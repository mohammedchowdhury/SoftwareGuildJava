import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        int guessNum = 20;
        int guess = 0;
        System.out.println("I've chosen a number. Betcha can't guess it!");
        guess = getUserInputNumber("Your guess : ");

        if(guess==guessNum){
            System.out.println("Wow, nice guess! That was it!");
        }else if(guess>guessNum){
            System.out.println("Too bad, way too high. I chose "+guessNum+".");
        }else if(guess<guessNum){
            System.out.println("Ha, nice try - too low! I chose "+guessNum+".");
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
                if (number >= 0) { //validating the number is greater than 0
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
//    Create a new class file named GuessMe.
//        Write a program that that has an integer of your choice stored in a variable.
//        The program asks the user to pick a number.
//        Regardless of the choice, the program should print out what the user entered as part of the response.
//        If their choice is equal to the number print out: "Wow, nice guess! That was it!"
//        If their choice is less to the number print out: "Ha, nice try - too low! I chose #."
//        If their choice is greater to the number print out: "Too bad, way too high. I chose #."
//        You're on your own for the code. The example below shows a sample output, but you can change the wording if you wish.
//
//        What You Should See (Example)
//        I've chosen a number. Betcha can't guess it!
//        Your guess: 44
//
//        44? Ha, nice try - too low! I chose 11.