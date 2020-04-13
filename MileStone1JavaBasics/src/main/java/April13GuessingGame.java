
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedchowdhury
 */
public class April13GuessingGame {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in); 
        
       int random = (int)(Math.random() * 100 + 1);
        System.out.println(random);
       int counter = 0;
       boolean guessedIt = false; 
       
       while(guessedIt == false){
           
           System.out.println("Please guess the number between 1-100");
           int x = keyboard.nextInt();
           
           
           if(x==random){
               guessedIt = true; 
               System.out.println("\nIt took you "+ ++counter +" number of guess.");
               break ;
           }
           else{
               
               
               if(x>random){
                   System.out.println("try a smaller number");
               }else{
                    System.out.println("try a bigger number");
               }
           
               counter++; 
            }
           
       }
        
  
        
    }
    
    
}
