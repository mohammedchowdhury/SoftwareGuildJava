/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseInterestCalculatorBigDecimal;

/**
 *
 * @author mohammedchowdhury
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class InterestCalculator {

    public static void RunMe() {
        int trigger = getUserInputYearAndRate("Choose interest compound periods: \n(1) quarterly \n(2) monthly \n(3) daily \nInput : ");

        if (trigger > 3 || trigger < 1) {
            System.out.println("Invalid Input");
            return;
        }

        BigDecimal investAmount = getUserInputMoney("How much do you want to invest? ");

        int years = getUserInputYearAndRate("How many years are investing? ");
        double interestRate = getUserInputYearAndRate("What is the annual interest rate % growth? ");

        System.out.println("Calculating...");

        double rate = 0;
        int totalInyear = 0;
        BigDecimal totalMoney = investAmount;

        if (trigger == 1) {
            rate = (interestRate) / 4;
            totalInyear = 4;
        } else if (trigger == 2) {
            rate = interestRate / 12;
            totalInyear = 12;
        } else if (trigger == 3) {
            rate = interestRate / 365;
            totalInyear = 365;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        for (int y = 1; y < years; y++) {
            System.out.println("Year " + y);

            BigDecimal beganAmount = totalMoney;

            for (int a = 1; a <= totalInyear; a++) {
                
                
                BigDecimal bdRate = new BigDecimal(rate+"");
                
                 bdRate = bdRate.divide(new BigDecimal("100"));
                 
                 bdRate = bdRate.add(new BigDecimal("1")); 
                
  
                 totalMoney = totalMoney.multiply(bdRate);
                
                
//                totalMoney = totalMoney * (1 + (rate / 100));
            }
            
            BigDecimal showMoney = totalMoney.subtract(beganAmount); 
            showMoney = showMoney.setScale(2, RoundingMode.HALF_UP); 
            
            System.out.println("Began with " + formatter.format(beganAmount));
            System.out.println("Earned $" + showMoney.toString());
            System.out.println("Ended with " + formatter.format(totalMoney));
        }
    }

    public static int getUserInputYearAndRate(String message) {
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

    public static BigDecimal getUserInputMoney(String message) {
        Scanner myScanner = new Scanner(System.in);
        BigDecimal decimal = null; 
        boolean isValid = false;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String

                decimal = new BigDecimal(input);

                if (decimal.compareTo(new BigDecimal("0")) > 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                } else {
                    System.out.println("Negative input");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
       return decimal;
    }
}
