import java.util.Scanner;
public class FizzBuzz {

    public static void main(String[] args) {
        int counter = 0;
        int input  = getUserInputNumber("How many units of fizzing and buzzing do you need in your life?");
        for(int a=0; a<input*3;a++){
            if(a%3==0 && a%5!=0 &&a!=0){
                System.out.println("fizz");
                counter++;
            }
            else if(a%5==0 && a%3!=0){
                System.out.println("buzz");
                counter++;
            }
            else if(a%5==0 && a%3==0 && a!=0){
                System.out.println("fizz buzz ");
                counter++;
            }
            else{
                System.out.println(a);
            }
            if(counter==input){
                System.out.println("TRADITION!!!!!");
                break;
            }
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
//    How many units of fizzing and buzzing do you need in your life? 7
//        0
//        1
//        2
//        fizz
//        4
//        buzz
//        fizz
//        7
//        8
//        fizz
//        buzz
//        11
//        fizz
//        13
//        14
//        fizz buzz
//        TRADITION!!!!!