public class StillPositive {
    public static void main(String[] args) {
        System.out.println("Gotta stay positive ...!");
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        for(int a=0 ; a<numbers.length;a++){
            if(numbers[a]>=0){
                System.out.print(numbers[a]+" ");
            }

        }


    }
}
