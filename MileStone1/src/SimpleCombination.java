import java.lang.reflect.Array;
import java.util.Arrays;
public class SimpleCombination {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49}; // 12 numbers
        int[] secondHalf = {51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100}; // also 12!
        int[] wholeNumbers = new int[24];

        int firstIndex = 0,secondIndex = 0;
        for(int a=0;a<24;a++){
            if(firstHalf[firstIndex]<secondHalf[secondIndex]){
                wholeNumbers[a] = firstHalf[firstIndex];
                firstIndex++;
            }
            else if(firstHalf[firstIndex]>secondHalf[secondIndex]){
                wholeNumbers[a] = secondHalf[secondIndex];
                secondIndex++;
            }
            if(firstIndex==12 || secondIndex==12){
                break;
            }
        }
        if(secondIndex<12){
            int x = secondIndex+firstIndex;
            for(int a=x; a<24;a++){
                wholeNumbers[a] = secondHalf[secondIndex];
                secondIndex++;
            }
        }else{
            int x = secondIndex+firstIndex;
            for(int a=x; a<24;a++){
                wholeNumbers[a] = firstHalf[firstIndex];
                firstIndex++;
            }
       }
        // Printing code should go here
        System.out.println("All together now!:");
        for(int a=0;a<wholeNumbers.length;a++){
            System.out.print(wholeNumbers[a]+" ");
        }
    }
}