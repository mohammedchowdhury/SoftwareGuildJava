import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {

        String ans1,ans2,ans3,ans4;

        System.out.println("What unit is equivalent to 1,024 Gigabytes?");
        ans1 = getUserInputString("Ans : ");
        System.out.println("Which planet is the only one that rotates clockwise in our Solar System?");
        ans2 = getUserInputString("Ans : ");
        System.out.println("The largest volcano ever discovered in our Solar System is located on which planet?");
        ans3 = getUserInputString("Ans : ");
        System.out.println("What is the most abundant element in the earth's atmosphere?");
        ans4 = getUserInputString("Ans : ");

        System.out.println("Wow, 1,024 Gigabytes is a "+ans3+"!");
        System.out.println("I didn't know that the largest ever volcano was discovered on "+ans1+"!");
        System.out.println("That's amazing that "+ ans2 +" is the most abundant element in the atmosphere...");
        System.out.println(ans4+" is the only planet that rotates clockwise, neat!");


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
