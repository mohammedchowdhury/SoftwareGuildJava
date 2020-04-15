import javax.xml.transform.Source;
import java.security.Security;
import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
            int ans=0,score=0;

        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code		2) Assembly Language");
        System.out.println("3) C#				4) Machine Code");
        ans = getUserInputNumber("YOUR ANSWER: ");
        if(ans==4){
            score++;
        }


        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper		2) Alan Turing");
        System.out.println("3) Charles Babbage	4) Larry Page");
        ans = getUserInputNumber("YOUR ANSWER: ");
        if(ans==2){
            score++;
        }


        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity			  2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise 4) The Millennium Falcon");
        ans = getUserInputNumber("YOUR ANSWER: ");
        if(ans==3){
            score++;
        }

        if(score>0){
            System.out.println("Nice job - you got "+ score +" correct!");
        }
        else{
            System.out.println("Better luck next time!");
        }




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
