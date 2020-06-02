/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseEnums;

import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class DaysOfWeek {

    public static void main(String[] args) {

        Days userInput = getDays(getInput());
        System.out.println("Today is " + userInput);
        int days = getDaysAwayFromFriday(userInput);
        if (days != 0 || days != 1) {
            System.out.println("You are " + getDaysAwayFromFriday(userInput) + " day away from Friday");
        } else {
            System.out.println("You are " + getDaysAwayFromFriday(userInput) + " days away from Friday");
        }
    }

    public static int getDaysAwayFromFriday(Days day) {
        int days;

        switch (day) {
            case MONDAY:
                return 4;
            case TUESDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static int getInput() { // gets the of the week in a int 
        int sel = 1;
        boolean keepGoing = true;
        Scanner keyboard = new Scanner(System.in);

        do {
            try {
                System.out.println("Please enter a number for selection between 1-7");
                selection();

                int temp = Integer.parseInt(keyboard.nextLine());

                if (temp > 0 && temp < 8) {
                    sel = temp;
                    keepGoing = false;
                }

            } catch (Exception e) {
                System.out.println("Invalid input");

            }
        } while (keepGoing);
        return sel;
    }

    public static void selection() {
        System.out.println("1 : Monday");
        System.out.println("2 : Tuesday");
        System.out.println("3 : Wednesday");
        System.out.println("4 : Thursday");
        System.out.println("5 : Friday");
        System.out.println("6 : Saturday");
        System.out.println("7 : Sunday");
    }

    public static Days getDays(int day) {
        Days enumDay;
        switch (day) {
            case 1:
                enumDay = Days.MONDAY;
                return enumDay;
            case 2:
                enumDay = Days.TUESDAY;
                return enumDay;
            case 3:
                enumDay = Days.WEDNESDAY;
                return enumDay;
            case 4:
                enumDay = Days.THURSDAY;
                return enumDay;
            case 5:
                enumDay = Days.FRIDAY;
                return enumDay;
            case 6:
                enumDay = Days.SATURDAY;
                return enumDay;
            case 7:
                enumDay = Days.SUNDAY;
                return enumDay;
            default:
                throw new UnsupportedOperationException();
        }
    }

}
