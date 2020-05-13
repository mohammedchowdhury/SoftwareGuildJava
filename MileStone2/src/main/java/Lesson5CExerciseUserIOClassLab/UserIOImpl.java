/*
 *@author : Mohammed Chowdhury 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammedchowdhury
 */
package Lesson5CExerciseUserIOClassLab;
import java.util.Scanner;
public class UserIOImpl implements UserIO {

    /**
     * print Print a given String to the console. The String value displayed
     * should be passed in as a parameter.
     *
     * @param String message
     * @return void
     */
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * readString Display a given message String to prompt the user to enter in
     * a String, then read in the user response as a String and return that
     * value. The prompt message should be passed in as a parameter and the
     * String value read in should be the return value of the method.
     *
     * @param String prompt
     * @return String
     */
    public String readString(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        String ans = "";
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();// getting a user String

                if (input.isBlank() == false && input.isEmpty() == false) {
                    ans = input;
                    isValid = true;
                    break;
                }
            } catch (NullPointerException ex) {
                System.out.println("That was not a String!" + ex);
            }
        } while (isValid == false);
        return ans;
    }

    /**
     * readInt Display a given message String to prompt the user to enter in an
     * integer, then read in the user response and return that integer value.
     * The prompt message value should be passed in as a parameter and the value
     * that is read in should be the return of the method.
     *
     * @param String prompt
     * @return int
     */
    public int readInt(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();
                number = Integer.parseInt(input);
                int validate = Math.abs(number);
                if (validate % 2 == 0 || validate % 2 == 1) {
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

    /**
     * Display a prompt to the user to enter a integer between a specified min
     * and max range, and read in a integer. If the user's number does not fall
     * within the range, keep prompting the user for new input until it does.
     * The prompt message, min and max values should be passed in as parameters.
     * The value read in from the console should be the return of the method.
     *
     * @param String prompt, int min, int mam
     * @return int
     */
    public int readInt(String prompt, int min, int max) {  
        if(min>max){
        int temp = max; 
        max = min; 
        min = temp; 
        } 
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();
                number = Integer.parseInt(input); 
                if (number >= min && number <= max) { 
                    isValid = true;
                    break;
                } else {
                    System.err.println("Out of range : " + number + " Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
        return number;
    }

    /**
     * readDouble Display a given message String to prompt the user to enter in
     * a double, then read in the user response and return that double value.
     * The prompt message value should be passed in as a parameter and the value
     * that is read in should be the return of the method.
     *
     * @param prompt
     * @return double
     */
    public double readDouble(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        double number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();
                number = Double.parseDouble(input);
                isValid = true;
                break;
            } catch (NumberFormatException ex) {
                System.out.println("That was not a double number!  " + ex);
            }
        } while (isValid == false);
        return number;
    }

    /**
     * Display a prompt to the user to enter a double between a specified min
     * and max range, and read in a double. If the user's number does not fall
     * within the range, keep prompting the user for new input until it does.
     * The prompt message, min and max values should be passed in as parameters.
     * The value read in from the console should be the return of the method.
     *
     * @param String prompt, double min, double max
     * @return double
     */
    public double readDouble(String prompt, double min, double max) {
        if(min>max){
            double temp = max;
            max = min; 
            min = temp; 
        }  
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        double number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();// getting a user String
                number = Double.parseDouble(input); //then converting it your self to a format we want
                if (number >= min && number <= max) { //validating the number is greater than 0
                    isValid = true;
                    break;
                } else {
                    System.out.println("Out of range input: " + number + " please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a Double!  " + ex);
                // ex.printStackTrace();
            }
        } while (isValid == false);
        return number;
    }

    /**
     * readFloat Display a given message String to prompt the user to enter in a
     * float, then read in the user response and return that float value. The
     * prompt message value should be passed in as a parameter and the value
     * that is read in should be the return of the method.
     *
     * @param prompt
     * @return float
     */
    public float readFloat(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        float number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();
                number = Float.parseFloat(input);
                isValid = true;
                break;
            } catch (NumberFormatException ex) {
                System.out.println("That was not a  Float!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }

    /**
     * Display a prompt to the user to enter a float between a specified min and
     * max range, and read in a float. If the user's number does not fall within
     * the range, keep prompting the user for new input until it does. The
     * prompt message, min and max values should be passed in as parameters. The
     * value read in from the console should be the return of the method.
     *
     * @param String prompt, float min, float max
     * @return float
     */
    public float readFloat(String prompt, float min, float max){
        if(min>max){
            float temp = min; 
            min = max; 
            max = temp; 
        }     
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        float number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();// getting a user String
                number = Float.parseFloat(input); //then converting it your self to a format we want
                if (number >= min && number <= max) { //validating the number is greater than 0
                    isValid = true;
                    break;
                } else {
                    System.out.println("Out of range input: " + number + " please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException ex) {
                System.out.println("That is not a  Float!  " + ex);
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }

    /**
     * Display a given message String to prompt the user to enter in a long,
     * then read in the user response and return that long value. The prompt
     * message value should be passed in as a parameter and the value that is
     * read in should be the return of the method.
     *
     * @param prompt
     * @return long
     */
    public long readLong(String prompt) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        long number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();
                number = Long.parseLong(input);
                isValid = true;
                break;
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
        return number;
    }

    /**
     * Display a prompt to the user to enter a long between a specified min and
     * max range, and read in a long. If the user's number does not fall within
     * the range, keep prompting the user for new input until it does. The
     * prompt message, min and max values should be passed in as parameters. The
     * value read in from the console should be the return of the method.
     *
     * @param String prompt, long min, long mam
     * @return long
     */
    public long readLong(String prompt, long min, long max) {
        if(min>max){
            long temp = max; 
            max = min; 
            min = temp; 
        }
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        long number = 0;
        do {
            try {
                System.out.print(prompt);
                String input = myScanner.nextLine();// getting a user String
                number = Long.parseLong(input); //then converting it your self to a format we want
                if (number >= min && number<=max) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }else{
                     System.out.println("Out of range input: " + number + " please enter a number between " + min + " and " + max);       
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
            }
        } while (isValid == false);
        return number;
    }

}