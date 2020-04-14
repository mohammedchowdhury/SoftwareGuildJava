import java.util.Scanner;

public class AllAboutMe {

    public static void main(String[] args) {
        String name, favoriteFood, placeLive;
        int numPets;
        boolean whistle;

        System.out.println("What is you name?");
        name = getUserInputString("Enter your name : ");

        System.out.println("What is you favorite food?");
        favoriteFood = getUserInputString("Enter your favorite food : ");

        System.out.println("How many pets do you have?");
        numPets = getUserInputNumber("Enter a number : ");

        System.out.println("Where do you live?");
        placeLive = getUserInputString("Enter where do you live : ");

        System.out.println("Did you ever learn to whistle?");
        whistle = getUserInputBoolean("Enter your ans:");

        System.out.println("My name is "+name);
        System.out.println("My favorite food is "+favoriteFood);
        System.out.println("I have "+numPets+" pets.");
        System.out.println("I live in a "+ placeLive+", and I love it here.");
        System.out.println("It is "+whistle+" I know how to whistle.");
    }

//    Choose an appropriate name and type for each variable.
//        your name
//        your favorite food
//        how many pets you have
//        whether you live in a dorm, an apartment, a house, or something else
//        whether or not you learned to whistle
//        Include each piece of data in a sentence on its own line using your variables.
//        Include a period at the end of each sentence and ensure that each sentence includes appropriate spaces between the words.
//        Here is an example of what the output might look like. You are welcome to change the phrasing as well as use your own values, as long as the output meets the criteria listed above.
//
//        What You Should See (Example)
//        My name is Ada Lovelace.
//        My favorite food is hot buttered gnocchi.
//        I have 5 pets.
//        I live in a pineapple under the sea, and I love it here.
//        It is true I know how to whistle.

    public static boolean getUserInputBoolean(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        boolean ans = false;
        do {
            try {
                System.out.println(message+ " (Please enter T or F) :" );
                String input = myScanner.nextLine();
                input = input.toUpperCase();
                if (input.isBlank()==false && input.isEmpty()==false && (input.equals("T") || input.equals("F"))) {
                    if(input.equals("T")){
                        ans = true;
                    }
                    else{
                        ans = false;
                    }
                    isValid = true;
                    break;
                }
            } catch (Exception ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
        return ans;
    }

   public static String getUserInputString(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        String ans = "";
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String


                if (input.isBlank()==false && input.isEmpty()==false) {
                    ans = input;
                    isValid = true;
                    break;
                }
            } catch (NullPointerException ex) {
                System.out.println("That was not a String!  " + ex);
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