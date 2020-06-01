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

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {
    
    public static void RunMe(){
        int dice1, dice2, startingBet,totalRoll=0, maxMoney=0,maxMoneyRoll=0;
        startingBet = getUserInputNumber("How many dollars do you have? : ");

        while(startingBet>0){
            dice1 = rollDice();
            dice2 = rollDice();

            if(dice1+dice2==7){
                startingBet = startingBet+4;

            }else{
                startingBet--;
            }

           if(startingBet>maxMoney){
               maxMoney = startingBet;
               maxMoneyRoll = totalRoll;
           }

            totalRoll++;
        }
        System.out.println("You are broke after "+totalRoll+" rolls.");
        System.out.println("You should have quit after "+maxMoneyRoll+" rolls when you had $"+maxMoney+".");
    }
    public static int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6)+1; // 0-5 +1 (1-6 inclusive)
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
                if (number > 0) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
}
//Each round, the program rolls a virtual pair of dice for the user.
//If the sum of the two dice is equal to 7, the player wins $4; otherwise, the player loses $1.



//    How many dollars do you have? 100
//    You are broke after 543 rolls.
//    You should have quit after 47 rolls when you had $113.