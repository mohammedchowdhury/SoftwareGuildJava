import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// notes fixme
// todo
// format option+command +L

public class ZZZPlayGround {
    public static void main(String[] args) {
        Random rand = new Random();

       for(int a=0;a<100;a++){

           System.out.println(rand.nextInt(3)+1);

       }


    }


    /**
     *  this is a doc
     * @param x
     * @param y
     */
    public static void add(int x,int y){
        System.out.println(x+y);

    }
}


