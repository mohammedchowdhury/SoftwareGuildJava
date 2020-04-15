import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
    int num = getUserInputNumber("What month's birthstone do you want to know? : ");
    String month = "", stone ="";

    if(num==1){
        month  = "January";
        stone = "Garnet";
    }else if(num==2){
        month  = "February";
        stone = "Amethyst";
    }else if(num==3){
        month  = "March";
        stone = "Aquamarine";
    }else if(num==4){
        month  = "April";
        stone = "Diamond";
    }else if(num==5){
        month  = "May";
        stone = "Emerald";
    }else if(num==6){
        month  = "June";
        stone = "Pearl";
    }else if(num==7){
        month  = "July";
        stone = "Ruby";
    }else if(num==8){
        month  = "August";
        stone = "Peridot";
    }else if(num==9){
        month  = "September";
        stone = "Sapphire";
    }else if(num==10){
        month  = "October";
        stone = "Opal";
    }else if(num==11){
        month  = "November";
        stone = "Topaz";

    }else if(num==12){
        month  = "December";
        stone = "Turquoise";
    }
        System.out.println(month+"'s birthstone is "+stone+".");
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
                if (number >= 1 && number<13) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
                else{
                    System.out.println("I think you must be confused, "+number+" doesn't match a month.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }

        } while (isValid == false);
        return number;
    }
}
