import java.util.Scanner;

//exercise:  (SumOfDigits)
//        1. prompt user to enter a positive integer
//        2. store input as int
//        3. declare/initialize var to 0.
//        4. Start loop (as long as data entered is greater than zero)
//        var = var + (user input % 10)
//        user input = user input / 10
//        5. end loop
//        6. print user input
//        7. print sum

public class SumPositiveInts {
    public static void main(String[] args) {
        long number  = getUserInputNumber("Please enter a positive number : ");
        System.out.println("User Input: "+number);
        int sum = SumOfDigits(number);
        System.out.println("Sum of digits is : "+sum);
    }

    public static int SumOfDigits(long number){
        int sum = 0;
        while (number>0) {
            sum = (int) (sum + number % 10);
            number = number / 10;
        }
        return sum;
    }

    public static long getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        long number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Long.parseLong(input); //then converting it your self to a format we want
                if (number > 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
}
