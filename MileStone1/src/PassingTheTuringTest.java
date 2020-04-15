import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        String name, favColor, favFruit;
        int favNum;
        System.out.println("Hello there!");
        System.out.println("What's your name?");
        name = getUserInputString("Name : ");
        System.out.println( "Hi, "+name+"!  I'm Alice.");
        System.out.println("What's your favorite color? ");
        favColor = getUserInputString("favorite color :");
        System.out.println("Huh,"+ favColor+"? Mine's Electric Lime.");
        System.out.println("I really like limes. They're my favorite fruit, too.");
        System.out.println("What's YOUR favorite fruit, "+name+"?");
        favFruit = getUserInputString("favorite fruit : ");
        System.out.println( "Really? "+favFruit+"? That's wild!");
        System.out.println("Speaking of favorites, what's your favorite number?");
        favNum = getUserInputNumber("favorite number : ");

        System.out.println(favNum +" is a cool number. Mine's -7");
        System.out.println("Did you know "+ favNum+ " * -7 is "+ (-7*favNum)+"? That's a cool number too!");
        System.out.println("Well, thanks for talking to me, "+name+"!");
    }
//        Ask the user for their name.
//        Display that name and tell them yours (or your AI's name!).
//        Ask them for their favorite color.
//        Display the color they enter in a conversational way.
//        Do the same thing with favorite food and number, and then say goodbye!
//        Make sure you use the right variable with the right user input!
//        What You Should See (Example)
//        Hello there!
//        What's your name? Zaphod
//
//        Hi, Zaphod!  I'm Alice.
//        What's your favorite color? Blue
//
//        Huh, Blue? Mine's Electric Lime.
//
//        I really like limes. They're my favorite fruit, too.
//        What's YOUR favorite fruit, Zaphod? Pawpaws
//
//        Really? Pawpaws? That's wild!
//        Speaking of favorites, what's your favorite number? 42
//
//        42 is a cool number. Mine's -7.
//        Did you know 42 * -7 is -294? That's a cool number too!
//
//        Well, thanks for talking to me, Zaphod!

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
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }

        } while (isValid == false);
        return ans;
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