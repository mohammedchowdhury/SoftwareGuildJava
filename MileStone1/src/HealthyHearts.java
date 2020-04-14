import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {

        int age, maxHeart, heartRate50, heartRate85;

        System.out.println("What is your age?");
        age = getUserInputNumber("Age : ");
        maxHeart = 220 - age;
        heartRate50 = (int) (maxHeart*.50);
        heartRate85 = (int) (maxHeart*.85);
        System.out.println("The maximum heart rate should be "+maxHeart);

        System.out.println("The target heart rate zone is "+heartRate50 +" - "+heartRate85+" of the maximum.");


    }

//    Make a calculator app that asks the user for their age and then
//    uses this value to calculate and display the healthy heart rate range they should use for exercising.
//
//        The maximum heart rate should be 220 - their age.
//        The target heart rate zone is 50 - 85% of the maximum.

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