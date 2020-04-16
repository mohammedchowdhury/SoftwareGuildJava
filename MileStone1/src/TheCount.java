import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {

        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        int start=0,stop=10,countBy;

        start = getUserInputNumber("Start at : ");
        while(start>=(stop  = getUserInputNumber("Stop at : "))){
            System.out.println("Please enter a number that's bigger then the starting number");
        }
        while(stop<=(countBy  = getUserInputNumber("Count by : "))) {
            System.out.println("Please enter a number that's smaller then the Stop number");
        }
        int x = 1;
        for(int a=start; a<=stop;a = a+countBy){
            System.out.print(a+" ");
            if(x%3==0){
                System.out.print("- Ah ah ah!\n");
            }
            x++;
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


