import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        System.out.println("Let's play MAD LIBS!");

        String noun1,adj1,noun2,adj2,pluralNoun1,pluralNoun2,pluralNoun3,verb1,verb1Past;
        int num1;
        noun1 = getUserInputString("I need a noun: ");
        adj1 = getUserInputString("Now an adjective: ");
        noun2 = getUserInputString("Another noun: ");

        num1 = getUserInputNumber("And a number: ");
        adj2 = getUserInputString("Another adjective: ");
        pluralNoun1 = getUserInputString(" A plural noun: ");
        pluralNoun2 = getUserInputString(" Another one: ");
        pluralNoun3 = getUserInputString("One more: ");
        verb1 = getUserInputString(" A verb (infinitive form): ");
        verb1Past = getUserInputString("Same verb (past participle): ");


        System.out.println(noun1+": the "+ adj1 +" frontier. These are the voyages of the starship "+noun2+".");
        System.out.println("Its "+num1+"-year mission: to explore strange "+adj2+" "+pluralNoun1+", to seek out "+adj2+" balls and red "+pluralNoun3+",");
        System.out.println("to boldly "+verb1+" where no one has "+verb1Past+" before.");


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

    public static String getUserInputString(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        String ans = "";
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String

                if (input.isBlank() == false && input.isEmpty() == false) {
                    ans = input;
                    isValid = true;
                    break;
                }
            } catch (NullPointerException ex) {
                System.out.println("That was not a String!  " + ex);
            }

        } while (isValid == false);
        return ans;
    }
}

