import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       Scanner myScanner  = new Scanner(System.in);

        boolean isValid = false;

        do {
            int number =0;
            try {
                System.out.println("Please enter a whole number: ");

                String input = myScanner.nextLine();
                number = Integer.parseInt(input);

                if (number >= 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch(NumberFormatException ex) {
                System.out.println("That was not a whole number!  "+ ex);
            }
            System.out.println(number);
        } while(isValid == false);

    }
}
