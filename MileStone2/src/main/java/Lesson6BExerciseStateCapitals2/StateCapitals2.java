/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson6BExerciseStateCapitals2;

import Lesson5CExerciseUserIOClassLab.UserIO;
import Lesson5CExerciseUserIOClassLab.UserIOImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author mohammedchowdhury
 */
public class StateCapitals2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));

        Map<String, String> iAmTheMap = new HashMap<String, String>();

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] statesAndCapitals = currentLine.split("::");
            iAmTheMap.put(statesAndCapitals[0], statesAndCapitals[1]);
        }

        System.out.println(iAmTheMap.size() + " STATES & CAPITALS ARE LOADED.");
        System.out.println("=======");
        System.out.println("HERE ARE THE STATES :");

        Set<String> states = iAmTheMap.keySet(); // contains all the states 
        System.out.println(states);

        Object[] arrStates = states.toArray(); // has states in array 

        Set<String> gameState = new TreeSet<String>(); // randomly picked states are in this set

        UserIO input = new UserIOImpl();
        System.out.println("READY TO TEST YOUR KNOWLEDGE?");
        int numGuess = input.readInt("How many states do you want to guess? :", 1, 50);

        Random rand = new Random();
        while (gameState.size() != numGuess) {
            gameState.add(arrStates[rand.nextInt(50)].toString());
        }

        arrStates = null;
        states = null;
        int correct = 0; 

        for (String st : gameState) {

            String temp = input.readString("WHAT IS THE CAPITAL OF " + st + "?:");
            
            if(iAmTheMap.containsValue(temp)){
                System.out.println("Correct!!");
                correct++; 
            }
            else{
                correct--; 
                System.out.println("Wrong !!");
                System.out.println("Correct answer is "+iAmTheMap.get(st));
            }
        }
        if(correct<0){
            correct = 0; 
        }
        System.out.println("\n\nScore :"+correct);
        System. gc(); // calls the garbage collector
        System.exit(0);

    }

}
