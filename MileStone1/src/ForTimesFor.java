import java.util.Scanner;

public class ForTimesFor {

        public static void main (String[]args){
            int userInput = getUserInputNumber("Which times table shall I recite? : ");
            int correct = 0;

            for (int a = 1; a <= 5; a++) {
                System.out.print(a + " * " + userInput + " is : ");
                int ans =  getUserInputNumber("");
                if(ans==(a*userInput)){
                    System.out.println("Correct!");
                    correct++;
                }
                else{
                    System.out.println("Sorry no, the answer is: "+ a*userInput);
                }
            }
            System.out.println("You got "+correct+" correct.");
            double fifty = 15*.5, ninety = 15*.9;
            if(correct>ninety){
                System.out.println("Congratulations you got over 90% correct!!");
            }else if(correct<fifty){
                System.out.println("You should study more!!!");
            }

        }
        public static int getUserInputNumber (String message){
            Scanner myScanner = new Scanner(System.in);
            boolean isValid = false;
            int number = 0;
            do {
                try {
                    System.out.print(message);
                    String input = myScanner.nextLine();// getting a user String
                    number = Integer.parseInt(input); //then converting it your self to a format we want
                    if (number > 0) { //validating the number is greater than 0
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
