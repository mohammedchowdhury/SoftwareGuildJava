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

public class RockPaperScissors {
    
    public static void RunMe() {
        System.out.println("Lets play Rock Paper Scissors");
        boolean keepPlaying = true;
        do {
            int draw = 0, lose = 0, win = 0;

            int numGame = getUserInputNumber2("How many times do you want to play? : ");
            for (int a = 0; a < numGame; a++) {
                int x = getUserInputNumber("Please Choose: 1 = Rock, 2 = Paper, 3 = Scissors :");
                int y = getComputerInput();
                System.out.println(y);
                if (x == 1) {
                    if (y == 1) {
                        draw++;
                        System.out.println("Draw : Rock and Rock");
                        continue;
                    } else if (y == 2) {
                        lose++;
                        System.out.println("Lose : Paper beats Rock");
                        continue;
                    } else if (y == 3) {
                        win++;
                        System.out.println("Win : Rock beats Scissors");
                        continue;
                    }
                } else if (x == 2) {
                    if (y == 1) {
                        win++;
                        System.out.println("Win : Paper beats Rock");
                        continue;
                    } else if (y == 2) {
                        draw++;
                        System.out.println("Draw : Paper and Paper");
                        continue;
                    } else if (y == 3) {
                        lose++;
                        System.out.println("Lose : Scissors beats Paper");
                        continue;
                    }

                } else if (x == 3) {
                    if (y == 1) {
                        lose++;
                        System.out.println("Lose : Rock beats Scissors");
                        continue;
                    } else if (y == 2) {
                        win++;
                        System.out.println("Win : Scissors beats Paper");
                        continue;
                    } else if (y == 3) {
                        draw++;
                        System.out.println("Draw : Scissors and Scissors");
                        continue;
                    }
                }
            }
            printSolution(win, lose, draw);
            keepPlaying = getUserInputBoolean("Do you want to play again?");
        } while (keepPlaying);

        System.out.println("Thanks for playing!");
    }

    public static void printSolution(int win, int lose, int draw) {
        System.out.println("Win :" + win);
        System.out.println("Lose :" + lose);
        System.out.println("Draw :" + draw);
        System.out.println("\n");

    }

    public static int getComputerInput() {
        Random rand = new Random();
        int input = rand.nextInt(3) + 1;
        return input;
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
                if (number > 0 && number < 4) { //validating the number is greater than 0
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
                if (number > 0 && number < 11) { //validating the number is greater than 0
                    isValid = true;
                    break;
                } else {
                    System.out.println("Out of range");
                    System.exit(0);
                }
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