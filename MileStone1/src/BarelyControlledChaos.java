import java.util.Random;
public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = getColor(); // call color method here
        String animal = getAnimal(); // call animal method again here
        String colorAgain = getColor(); // call color method again here

        int weight = getNumber(5,200); // call number method,
//        // with a range between 5 - 200

        int distance = getNumber(10,20); // call number method,
//        // with a range between 10 - 20

         int number = getNumber(10000,20000); // call number method,
//        // with a range between 10000 - 20000

         int time = getNumber(2,6); // call number method,
//        // with a range between 2 - 6
//
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    // ??? Method 1 ???
    //Write a method that returns a randomly chosen color (have it choose from at LEAST five different colors!)
    public static String getColor(){
        String [] color = {"Red","White","Black","Orange","Green"};
        Random rand = new Random();
        return color[rand.nextInt(5)];
    }

    // ??? Method 2 ???
    //Write a method that returns a randomly chosen animal (have it choose from at LEAST five different animals!)
    public static String getAnimal(){
        String [] color = {"Cow","Horse","Chicken","Rat","Mouse"};
        Random rand = new Random();
        return color[rand.nextInt(5)];
    }

    // ??? Method 3 ???
    //Write another method that returns a random integer chosen from a range (min / max) that can be either of the two numbers or anything between.
    public static int getNumber(int min,int max){
        Random rand = new Random();
        int num = rand.nextInt(max-min+1);
        num = num+min;
        //System.out.println(num);
        return num;
    }


}