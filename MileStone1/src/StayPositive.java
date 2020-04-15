import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        int number = getUserInputNumber("What number should I count down from? :");
        int counter = 1;
        System.out.println("Here goes!");
        while(number>-1){
            System.out.print(number+" ");
            if(counter%10==0){
                System.out.println();
            }
            number--;
            counter++;
        }
        System.out.println("Blast off!");
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
                else {
                    System.out.println("Enter a positive number!!!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }

        } while (isValid == false);
        return number;
    }
}

//    Create a new console Java Program named StayPositive.
//        Write a while loop that starts with an integer counts down from it,
//        prints out each number until it reaches zero, and then stops. (
//        Stop at zero so you don't have negative numbers!)
//        What You Should See (Example)
//        Here's an example of what the output might look like:
//
//        Counting down...
//
//        10
//        9
//        8
//        7
//        6
//        5
//        4
//        3
//        2
//        1
//        0
//
//        Blast off!
//Ask the user for the starting value.
//        Set up the output to display 10 values per line and then start a
//        new line. (It's fine if there are fewer than 10 numbers on the last line.)
//        BONUS: Add a step that verifies that the input value is a positive integer and
//        responds appropriately if it is not.