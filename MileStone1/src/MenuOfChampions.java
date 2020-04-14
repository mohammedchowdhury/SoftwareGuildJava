import java.text.NumberFormat;

public class MenuOfChampions {
    public static void main(String[] args) {
        String food1, food2, food3;
        double food1P,food2P,food3P;

        food1 = "Slice of Big Rico Pizza";
        food2 = "Invisible Strawberry Pie";
        food3 = "Denver Omelet";

        food1P = 500;
        food2P = 2;
        food3P = 1.5;

        NumberFormat formatter = NumberFormat.getCurrencyInstance();


        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\n");
        System.out.println("             WELCOME TO RESTAURANT NIGHT VALE!");
        System.out.println("             Today's Menu Is...\n");
        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.\n");
        System.out.println("             "+formatter.format(food1P)+" *** "+food1);
        System.out.println("             "+formatter.format(food2P)+" ***** "+food2);
        System.out.println("             "+formatter.format(food3P)+" ***** "+food3);


    }
}
//    Type your code into a new Java class named MenuOfChampions.
//        Write a program that displays a menu for a restaurant.
//        The menu should include at least three different foods, each with their own price.
//        Each value (food name and price) should be stored in its own variable, using the appropriate type.
//        Display the restaurant name and menu, followed by a list of dishes and their prices, similar to the output shown below.
//        Feel free to use some (ASCII art)[https://asciiart.website//index.php?art=art%20and%20design/borders] to decorate your menu!
//        Sample output follows. Your output can look different as long as it meets the criteria listed above.
//
//        What You Should See (Example)
//        .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.
//
//        WELCOME TO RESTAURANT NIGHT VALE!
//        Today's Menu Is...
//
//        .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.
//
//        $ 500.00 *** Slice of Big Rico Pizza
//        $ 2.00 ***** Invisible Strawberry Pie
//        $ 1.50 ***** Denver Omelet