import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
//        Ask the user how many miles they can run, the number of hot dogs they can eat,
//                and the number of languages they know. Immediately after each question,
//        brag that you can do more by multiplying their number by 2 and adding 1.

        int miles,hotdog,numLanguage;

        System.out.println("How many miles can you run? ");
        miles = getUserInputNumber(" Miles :");
        System.out.println("I can run "+((miles*2)+1)+" miles!!!");

        System.out.println("How many Hotdogs can you eat? ");
        hotdog = getUserInputNumber(" Hotdog :");
        System.out.println("I can eat "+((hotdog*2)+1)+" hotdogs!!!");

        System.out.println("How many languages can you speak? ");
        numLanguage = getUserInputNumber(" Languages :");
        System.out.println("I can speak "+((numLanguage*2)+1)+" languages!!!");

    }

    public static int getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message+" ");
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
