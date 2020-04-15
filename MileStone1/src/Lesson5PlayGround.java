import java.util.Random;
import java.util.Scanner;
public class Lesson5PlayGround {
    public static void main(String[] args) {

        Random rng = new Random();

// maximum is 13.2
// minimum is -7.5
        double desiredOutput = rng.nextDouble() * (13.2 - -7.5) + -7.5;
        System.out.println(desiredOutput);

//       Random rand = new Random();
//       int randNum = rand.nextInt(10)+1;
//       Scanner keybaord =  new Scanner(System.in);
//        while(true){
//            System.out.println("Guess a random number between 1 and 20 inclusive");
//            int x = keybaord.nextInt();
//            if(x==randNum){
//                break;
//            }
//            if(x>randNum){
//                System.out.println("Guess Smaller!!");
//                continue;
//            }
//            System.out.println("Guess Bigger");
//        }
//        System.out.println("You Guesses the number right!!!");
//

    }
}