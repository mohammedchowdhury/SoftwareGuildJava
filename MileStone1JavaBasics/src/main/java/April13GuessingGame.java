
import java.util.Scanner;
/**
 *
 * @author mohammedchowdhury
 */
public class April13GuessingGame {
    public static void main(String[] args) {
       Scanner keyboard = new Scanner(System.in);        
       int random = (int)(Math.random() * 99 + 1); // math is part of the Java.lang Thus you dont have to import     
       System.out.println(random);      
       int counter = 0;
       boolean guessedIt = false;       
       while(guessedIt == false){           
           System.out.println("Please guess the number between inclusive 1-99");
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
//Create a Guessing game
//-produce a random number 0<number<100
//-let user guess the number
//-for each guess....
//- respond with
//    too low
//    too hign
//    correct