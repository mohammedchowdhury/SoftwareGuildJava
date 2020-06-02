/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lesson3enum;

import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class IntMath {

    public static void main(String[] args) {    
           keepRunning();
    }
    
    public static void keepRunning(){
        boolean keeoGoing = true; 
        
        Scanner keyboard = new Scanner(System.in); 
        do{
            System.out.println(calculate(getOperator(getOperator()), getOperand(),getOperand())); 
            
            System.out.println("Perform another operation? Input 1: (YES) 2 (NO)");
            
            try{
            int input= Integer.parseInt(keyboard.nextLine()); 
            if(input==2){
                keeoGoing  =false; 
            }
            }catch(Exception e){
                System.out.println("Invalid Input");
                keeoGoing = false; 
            }
            
            
            
            
        }while(keeoGoing); 
        
    }
        
    
    
    
    
    
     public static int getOperand() { // gets the of the week in a int 
        int sel = 1;
        boolean keepGoing = true;
        Scanner keyboard = new Scanner(System.in);

        do {
            try {
                System.out.println("Please enter a operand");
               
                int temp = Integer.parseInt(keyboard.nextLine());

               
                    sel = temp;
                    keepGoing = false;
              
                System.out.println(" ");

            } catch (Exception e) {
                System.out.println("Invalid input");

            }
        } while (keepGoing);
        return sel;
    }

    
    
    public static int getOperator() { // gets the of the week in a int 
        int sel = 1;
        boolean keepGoing = true;
        Scanner keyboard = new Scanner(System.in);

        do {
            try {
                System.out.println("Please enter a number for selection between 1-4");
                selection();

                int temp = Integer.parseInt(keyboard.nextLine());

                if (temp > 0 && temp < 5) {
                    sel = temp;
                    keepGoing = false;
                }
                System.out.println(" ");

            } catch (Exception e) {
                System.out.println("Invalid input");

            }
        } while (keepGoing);
        return sel;
    }

    public static void selection() {
        System.out.println("1 : PLUS");//    PLUS, MINUS, MULTIPLY, DIVIDE
        System.out.println("2 : MINUS");
        System.out.println("3 : MULTIPLY");
        System.out.println("4 : DIVIDE");
    }
    
        public static MathOperator getOperator(int op) {
        MathOperator operator;
        switch (op) {
            case 1:
                operator = MathOperator.PLUS;
                return operator;
            case 2:
                operator = MathOperator.MINUS;
                return operator;
            case 3:
                operator = MathOperator.MULTIPLY;
                return operator;
            case 4:
                operator = MathOperator.DIVIDE;
                return operator;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static int calculate(MathOperator operator, int operand1, int operand2) {
        
        try{
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
        }catch(Exception e){
            System.out.println("Invalid operation");
            
        }
        return 0; 
    }
}
