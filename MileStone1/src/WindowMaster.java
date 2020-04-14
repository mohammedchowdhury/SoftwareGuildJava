import java.util.Scanner;

public class WindowMaster {
//    It must prompt the user for the height of the window (in feet).
//    It must prompt the user for the width of the window (in feet).
//    It must calculate and display the area of the window.
//    It must calculate and display the perimeter of the window.
//    Based on the area and perimeter, it must calculate the total cost of the window.
//    The glass for the windows cost $3.50 per square foot.
//    The trim for the windows cost $2.25 per linear foot.

    public static void main(String[] args) {
        float height,width,area, perimeter;
        double cost;
        height = getUserInput("Enter Height");
        width = getUserInput("Enter Width");
        area = height*width;
        perimeter = 2*(height*width);
        cost =  ((3.50f * area) + (2.25f * perimeter));

        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + area);
        System.out.println("Window perimeter = " + perimeter);
        System.out.println("Total Cost =  " + cost);

    }

    public static float getUserInput(String message){
        Scanner myScanner  = new Scanner(System.in);
        boolean isValid = false;
        float number=0;
        do {
            try {
                System.out.println(message);
                String input = myScanner.nextLine();// getting a user String
                number = Float.parseFloat(input); //then converting it your self to a format we want
                if (number >= 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch(NumberFormatException ex) {
                System.out.println("That was not a whole number!  "+ ex);
               // ex.printStackTrace();
            }
            System.out.println(number);
        } while(isValid == false);
        return number;
    }
}
