/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public class ExerciseStateCapitals1 {

    public static void main(String[] args) {
        Map<String, String> statesAndCapital = new HashMap<String, String>();

        statesAndCapital.put("Alabama", "Montgomery");

        statesAndCapital.put("Alaska", "Juneau");
        statesAndCapital.put("Arizona", "Phoenix");
        statesAndCapital.put("Arkansas", "Little Rock");
        statesAndCapital.put("California", "Sacramento");
        statesAndCapital.put("Colorado", "Denver");
        statesAndCapital.put("Connecticut", "Hartford");
        statesAndCapital.put("Delaware", "Dover");
        statesAndCapital.put("Florida", "Tallahassee");
        statesAndCapital.put("Georgia", "Atlanta");
        statesAndCapital.put("Hawaii", "Honolulu");
        statesAndCapital.put("Idaho", "Boise");
        statesAndCapital.put("Illinois", "Springfield");
        statesAndCapital.put("Indiana", "Indianapolis");
        statesAndCapital.put("Iowa", "Des Moines");
        statesAndCapital.put("Kansas", "Topeka");
        statesAndCapital.put("Kentucky", "Frankfort");
        statesAndCapital.put("Louisiana", "Baton Rouge");
        statesAndCapital.put("Maine", "Augusta");
        statesAndCapital.put("Maryland", "Annapolis");
        statesAndCapital.put("Massachusetts", "Boston");
        statesAndCapital.put("Michigan", "Lansing");
        statesAndCapital.put("Minnesota", "St. Paul");
        statesAndCapital.put("Mississippi", "Jackson");
        statesAndCapital.put("Missouri", "Jefferson City");
        statesAndCapital.put("Montana", "Helena");
        statesAndCapital.put("Nebraska", "Lincoln");
        statesAndCapital.put("Nevada", "Carson City");
        statesAndCapital.put("New Hampshire", "Concord");
        statesAndCapital.put("New Jersey", "Trenton");
        statesAndCapital.put("New Mexico", "Santa Fe");
        statesAndCapital.put("New York", "Albany");
        statesAndCapital.put("North Dakota", "Bismarck");
        statesAndCapital.put("Ohio", "Columbus");
        statesAndCapital.put("Oklahoma", "Oklahoma City");
        statesAndCapital.put("Oregon", "Salem");
        statesAndCapital.put("Pennsylvania", "Harrisburg");
        statesAndCapital.put("Rhode Island", "Providence");
        statesAndCapital.put("South Carolina", "Columbia");
        statesAndCapital.put("South Dakota", "Pierre");
        statesAndCapital.put("Tennessee", "Nashville");
        statesAndCapital.put("Texas", "Austin");
        statesAndCapital.put("Utah", "Salt Lake City");
        statesAndCapital.put("Vermont", "Montpelier");
        statesAndCapital.put("Virginia", "Richmond");
        statesAndCapital.put("Washington", "Olympia");
        statesAndCapital.put("West Virginia", "Charleston");
        statesAndCapital.put("Wisconsin", "Madison");
        statesAndCapital.put("Wyoming", "Cheyenne");

        System.out.println("STATES:\n"
                + "=======");
        for (String states : statesAndCapital.keySet()) {
            System.out.println(states);
        }

        System.out.println("\n\n");

        System.out.println("CAPITALS:\n"
                + "=========");
        for (String cap : statesAndCapital.values()) {
            System.out.println(cap);
        }
        
        System.out.println("\n\n");

        System.out.println("STATE/CAPITAL PAIRS:\n"
                + "====================");
        for (String states : statesAndCapital.keySet()) {
            System.out.println(states+" - "+statesAndCapital.get(states));
        }


    }
}
