/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseSimpleCalculator;

import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    
    public static void main(String[] args) {
        

//        System.out.println(x);

    boolean keepPlaying = true; 
    
    do{
                int x = getUserInputNumber("Select: \n(1) Addition \n(2) Subtraction \n(3) Multiplication \n(4) Division \n Selection : ");
                int num1,num2;
                num1 = getUserInputNumber2("Enter a number: "); 
                num2 = getUserInputNumber2("Enter a number: "); 
                double ans = 0; 
                
                if(x==1){
                     ans = SimpleCalculator.addition(num1, num2); 
                     System.out.println(num1+" + "+num2);
                }
                else if(x==2){
                     ans = SimpleCalculator.subtraction(num1, num2); 
                          System.out.println(num1+" - "+num2);
                }  else if(x==3){
                     ans = SimpleCalculator.multiplication(num1, num2);
                          System.out.println(num1+" * "+num2);
                }  else if(x==4){
                     ans = SimpleCalculator.division(num1, num2); 
                          System.out.println(num1+" / "+num2);
                }
                System.out.println("The solution is "+ans);
        
        
        keepPlaying = getUserInputBoolean("Do you want to calculate something?"); 
    }while(keepPlaying); 
        
        System.out.println("Thank you!!");
       
        
    }
    
    public static int getUserInputNumber(String message) { //used to get input for numbers 1-3
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Integer.parseInt(input); //then converting it your self to a format we want
                if (number > 0 && number < 5) { //validating the number is greater than 0
                    isValid = true;
                    break;
                } else {
                    System.out.println("Out of range");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
        public static int getUserInputNumber2(String message) { //used to get input for numbers 1-3
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
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
    
    
    public static boolean getUserInputBoolean(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        boolean ans = false;
        do {
            try {
                System.out.println(message + " (Please enter Yes or No) :");
                String input = myScanner.nextLine();
                input = input.toUpperCase();
                if (input.isBlank() == false && input.isEmpty() == false && (input.equals("YES") || input.equals("NO"))) {
                    if (input.equals("YES")) {
                        ans = true;
                    } else {
                        ans = false;
                    }
                    isValid = true;
                    break;
                }
            } catch (Exception ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
        return ans;
    }
    
}
