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
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author mohammedchowdhury
 */
public class StateCapitalsApp {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Capital> iAmTheMap = new TreeMap<String, Capital>();

        Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));

        while (sc.hasNextLine()) {
            String[] statesAndCapitals = sc.nextLine().split("::");
            iAmTheMap.put(statesAndCapitals[0], new Capital(statesAndCapitals[1], Integer.parseInt(statesAndCapitals[2]), Double.parseDouble(statesAndCapitals[3])));
        }

        System.out.println(iAmTheMap.size() + " STATE/CAPITAL PAIRS LOADED.");
        System.out.println("==============================");
        Set<String> set = iAmTheMap.keySet();

        for (String state : set) {
            System.out.println(state + " - " + iAmTheMap.get(state).getName() + " | Pop: " + iAmTheMap.get(state).getPopulation() + " | Area: " + iAmTheMap.get(state).getSquareMileage() + " sq mi");
        }

        UserIO input = new UserIOImpl();
        int population = input.readInt("\nPlease enter the lower limit for capital city population: ", 0, Integer.MAX_VALUE);

        System.out.println("\nLISTING CAPITALS WITH POPULATIONS GREATER THAN " + population + " :");

        for (String state : set) {
            if (iAmTheMap.get(state).getPopulation() > population) {
                System.out.println(state + " - " + iAmTheMap.get(state).getName() + " | Pop: " + iAmTheMap.get(state).getPopulation() + " | Area: " + iAmTheMap.get(state).getSquareMileage() + " sq mi");
            }
        }

        double area = input.readDouble("\n\nPlease enter the upper limit for capital city sq mileage: ");
        System.out.println("\nLISTING CAPITALS WITH AREAS LESS THAN " + area + " :\n");

        for (String state : set) {
            if (iAmTheMap.get(state).getSquareMileage()< area) {
                System.out.println(state + " - " + iAmTheMap.get(state).getName() + " | Pop: " + iAmTheMap.get(state).getPopulation() + " | Area: " + iAmTheMap.get(state).getSquareMileage() + " sq mi");
            }
        }

    }

}
