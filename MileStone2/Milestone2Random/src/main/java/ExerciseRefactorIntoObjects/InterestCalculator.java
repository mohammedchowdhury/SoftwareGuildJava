/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseRefactorIntoObjects;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class InterestCalculator {
    

    public static void RunMe(){
        int trigger = getUserInputNumber("Choose interest compound periods: \n(1) quarterly \n(2) monthly \n(3) daily \nInput : ");
        if(trigger>3 || trigger<1){
            System.out.println("Invalid Input");
            return;
        }
        double investAmount = getUserInputNumber("How much do you want to invest? ");
        int years = getUserInputNumber("How many years are investing? ");
        double interestRate = getUserInputNumber("What is the annual interest rate % growth? ");
        System.out.println("Calculating...");

        double rate=0;
        int totalInyear =0;
        double totalMoney = investAmount;

        if(trigger==1){
            rate = (interestRate)/4;
            totalInyear = 4;
        }
        else if(trigger==2){
            rate = interestRate/12;
            totalInyear = 12;
        }else if(trigger==3){
            rate = interestRate/365;
            totalInyear = 365;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for(int y = 1; y<years; y++) {
            System.out.println("Year " + y);

            double beganAmount = totalMoney;

            for (int a = 1; a <= totalInyear; a++) {
                totalMoney = totalMoney * (1 + (rate / 100));
            }
            System.out.println("Began with "+formatter.format(beganAmount));
            System.out.println("Earned "+(formatter.format((totalMoney-beganAmount))));
            System.out.println("Ended with "+formatter.format(totalMoney));
        }
    }
    public static int getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Integer.parseInt(input); //then converting it your self to a format we want
                if (number >= 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
}
