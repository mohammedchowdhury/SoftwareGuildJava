import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {

        int age, maxHeart, heartRate50, heartRate85;

        age = getUserInputNumber("What is your age? ");
        maxHeart = 220 - age;
        heartRate50 = (int) Math.ceil(maxHeart * .5);
        heartRate85 = (int) Math.ceil(maxHeart * .85);
        System.out.println("The maximum heart rate should be " + maxHeart + " beats per minute");
        System.out.println("The target HR Zone is " + heartRate50 + " - " + heartRate85 + " beats per minute.");

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