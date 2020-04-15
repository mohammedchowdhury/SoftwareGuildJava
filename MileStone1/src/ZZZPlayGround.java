import java.util.Random;

public class ZZZPlayGround {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int a=0; a<20; a++){
            System.out.println(rand.nextInt(5));
        }
    }
}
