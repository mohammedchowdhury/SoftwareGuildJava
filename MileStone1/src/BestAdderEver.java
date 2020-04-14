import java.util.Scanner;

public class BestAdderEver {
    public static void main(String[] args) {
        int num1,num2,num3;
        num1 = getUserInputNumber("Enter a number :");
        num2 = getUserInputNumber("Enter a number :");
        num3 = getUserInputNumber("Enter a number :");
        int sum = num1+num2+num3;
        System.out.println(num1+" + "+num2+" + "+num3+" = "+sum);


    }



    public static int getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.println(message);
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
//    Type your code into a Visual Studio project named BestAdderEver.
//        Write a program that stores three different numbers in different variables.
//        Add those variables together and store that in a new variable.
//        Display the result as a single math statement, like 1 + 2 + 3 = 6.
//        After completing all of these exercises, take time to record what you
//        learned and other thoughts in your engineer's notebook for future reference.