public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        int counter = 34;
        while(counter>0){
            if(counter%2==0){
                System.out.println("It loves me NOT!");
            }
            else {
                System.out.println("It LOVES me!");
            }
            counter--;
        }
        System.out.println("I knew it! It LOVES ME!");
    }
}
