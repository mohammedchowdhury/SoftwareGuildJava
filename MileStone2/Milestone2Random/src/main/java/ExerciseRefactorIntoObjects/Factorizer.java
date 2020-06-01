/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseRefactorIntoObjects;

/**
 *
 * @author mohammedchowdhury
 */
import java.util.Scanner;
public class Factorizer {
    

    public static void RunMe(){
        int number = getUserInputNumber("What number would you like to factor? ");
        System.out.println("The factors of "+number+" are:");
        printFactors(number);
    }
    
     

    public static void printFactors(int x){
        int sum = 0;
        int numFactor = 0;
        for(int a=1; a<=x; a++){
            if(x%a==0){
                System.out.print(a+" ");
                sum = sum+a;
                numFactor++;
            }
        }
        System.out.println("");
        System.out.println(x+" has "+numFactor+" factors.");
        if(sum-x==x){
            System.out.println(x+" is a perfect number.");
        }else{
            System.out.println(x+" is not a perfect number.");
        }

        if(isPrime(x)){
            System.out.println(x+" is a prime number.");
        }else{
            System.out.println(x+" is not a prime number.");
        }
    }

    public static boolean isPrime(int x){
        if(x<0){
            x = x*-1;
        }
        if(x==2){
            return true;
        }
        if(x%2==0 || x==0 || x==1){
            return false;
        }
        for(int a=3 ; a<Math.sqrt(x);a++){
            if(x%a==0){
                return false;
            }
        }
        return true;
    }
    public static int getUserInputNumber(String message){
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();
                number = Integer.parseInt(input); //then converting it your self to a format we want
                    isValid = true;
                    break;
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
}
