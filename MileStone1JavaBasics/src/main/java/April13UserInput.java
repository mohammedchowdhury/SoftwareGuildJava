
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
public class April13UserInput {
    public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);     
        System.out.println("What is your age?");
        int age = keyboard.nextInt(); 
        if(age>100){
            System.out.println("Stop using the computer old man!!!");
            return; 
        }       
        System.out.println(age);
        int years = age; 
        int months  = age*12;
        int days = age*365;
        int hours = days*24; 
        long minutes = hours*60; 
        long seconds = minutes*60; 
        long milliseconds = seconds *1000; 
        System.out.println("You age in: \n Years:"+years+"\n Months :"+months+"\n Days :"+days+"\n Hours :"+hours+"\n Minutes :"+minutes+"\n Seconds : "+seconds+"\n Milliseconds : "+milliseconds ); 
    }
    
}
