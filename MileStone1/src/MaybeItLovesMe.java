import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        Random rand = new Random();
        int range = 90 - 13;
        int randomNum = rand.nextInt(range);
        randomNum = randomNum + 13;
        int x = 1;
        System.out.println(randomNum);

        while (randomNum > 0) {
            if (x % 2 == 1) {
                System.out.println("It LOVES me!");
            } else {
                System.out.println("It loves me NOT!");
            }
            x++;
            randomNum--;
        }
        if (x % 2 == 0) {
            System.out.println("Oh, wow! It really LOVES me!");
        } else {
            System.out.println("Awwww, bummer.");
        }
    }
}
//    Create a new program named MaybeItLovesMe based on the
//        previous daisy-prediction program. The new version should
//        include a RANDOM number of petals for the daisy (range is usually
//        from 13 - 89 petals). If the last petal ends on "It loves me NOT" print "Awwww, bummer."
//        otherwise print "Oh, wow! It really LOVES me!"