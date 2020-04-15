import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        System.out.println(">Ready, Set, Flip....!!");
        Random rand = new Random();
        boolean ans = rand.nextBoolean();
        if(ans==true){
            System.out.println("You got TAILS!");
        }
        else{
            System.out.println("You got HEADS!");
        }
    }
}
