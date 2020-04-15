import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        String name;
        int birthDate;

        name = getUserInputString("Hey, let's play a game! What's your name? ");
        birthDate = getUserInputNumber("Ok, "+name+", when were you born?" );
        System.out.println("Well "+ name+"...");
        if(birthDate<2005){
            System.out.println("Did you know that Pixar's 'Up' came out over a decade ago?");
        }
        if(birthDate<1995){
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        if(birthDate<1985){
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        if(birthDate<1975){
            System.out.println("Original Jurassic Park release is closer to the first lunar landing than it is to today.");
        }
        if(birthDate<1965){
            System.out.println("MASH TV series has been around for almost half a century!");
        }


//        1980
//        Did you know that Pixar's 'Up' came out over a decade ago?
//        And that the first Harry Potter came out over 15 years ago
//        Also, Space Jam came out not last decade, but the one before THAT.

//        If they were born before 2005, print out that Pixar's 'Up' came out over a decade ago.
//        If they were born before 1995, print out that the first Harry Potter came out over 15 years ago.
//        If they were born before 1985, print out Space Jam came out not last decade, but the one before THAT.
//        If they were born before 1975, print out that the original Jurassic Park release is closer to the first lunar landing than it


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
//    Write a program that displays a different message based on the year someone was born to make them feel old.
//
//        If they were born before 2005, print out that Pixar's 'Up' came out over a decade ago.
//        If they were born before 1995, print out that the first Harry Potter came out over 15 years ago.
//        If they were born before 1985, print out Space Jam came out not last decade, but the one before THAT.
//        If they were born before 1975, print out that the original Jurassic Park release is closer to the first lunar landing than it is to today.
//        If they were born before 1965, print out that the MASH TV series has been around for almost half a century!
//        Note: A person who is born in 1980 should display three messages, one for being born before 2005, one for 1995, and finally for 1985.
//
//        The code and exact phrasing are completely up to you. Here is an example of what the output might look like.
//
//        What You Should See (Example)
//        Hey, let's play a game! What's your name? Kristen
//
//        Ok, Kristen, when were you born? 1980
//
//        Well Kristen...
//        Did you know that Pixar's 'Up' came out over a decade ago?
//        And that the first Harry Potter came out over 15 years ago!
//        Also, Space Jam came out not last decade, but the one before THAT.