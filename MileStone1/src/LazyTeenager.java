import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        int warningCounter = 1;
        double chance = 0;
        Random rand = new Random();




        while(warningCounter<8){
            System.out.println("Clean your room!! (x"+warningCounter+")");

            chance = chance +.10;
            if(chance>rand.nextDouble()){
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
                break;
            }


            warningCounter++;
        }
        if(warningCounter==8){
            System.out.println("That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
        }
    }
}
