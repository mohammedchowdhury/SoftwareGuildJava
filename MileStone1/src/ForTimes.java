import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args) {
        int userInput = getUserInputNumber("Which times table shall I recite? : ");


        for(int a=1; a<=15;a++){
            System.out.println(a+" * "+userInput+" is : "+a*userInput);
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
                if (number > 0) { //validating the number is greater than 0
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
