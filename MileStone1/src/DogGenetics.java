import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
//        What is your dog's name? Sir Fluffy McFlufferkins Esquire
//        Well then, I have this highly reliable report on Sir Fluffy McFlufferkins Esquire's prestigious background right here.
//
//        Sir Fluffy McFlufferkins Esquire is:
//
//        61% St. Bernard
//        2% Chihuahua
//        29% Dramatic RedNosed Asian Pug
//        1% Common Cur
//        7% King Doberman
//
//        Wow, that's QUITE the dog!
        String name = getUserInputString("What is your dog's name? :");
        System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.\n");
        System.out.println(name+" is:\n");

        int max = 100;
        int temp = getRandomInput(max);
        System.out.println(temp+"% St. Bernard");
        max = max-temp;

        temp = getRandomInput(max);
        System.out.println(temp+"% Chihuahua");
        max = max-temp;

        temp = getRandomInput(max);
        System.out.println(temp+"% Dramatic RedNosed Asian Pug");
        max = max-temp;

        temp = getRandomInput(max);
        System.out.println(temp+"% Common Cur");
        max = max-temp;

       // temp = getRandomInput(max);
        System.out.println(max+"% King Doberman");
        //max = max-temp;

    }
    public static int getRandomInput(int max){
        Random rand = new Random();
        return rand.nextInt(max)+1;
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
}
