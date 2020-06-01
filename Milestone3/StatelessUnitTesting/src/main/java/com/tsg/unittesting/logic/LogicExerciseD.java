/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseD {

    /**
     * Given two characters, return true if the first letter parameter comes
     * earlier in the alphabet than the second letter parameter. Don't worry
     * about casing, just turn consider everything in lowercase.
     *
     * Ex: isFirstTheFirst( 'a' , 'b' ) -> true isFirstTheFirst( 'O' , 'X' ) ->
     * true isFirstTheFirst( 'Z' , 'z' ) -> false
     *
     * @param letterOne
     * @param letterTwo
     * @return boolean
     */
    public static boolean isFirstTheFirst(char letterOne, char letterTwo) {
        String l = letterOne + "";
        l = l.toLowerCase();
        letterOne = l.charAt(0);

        String t = letterTwo + "";
        t = t.toLowerCase();
        letterTwo = t.charAt(0);

        if (letterOne < letterTwo) {
            return true;
        }
        return false;
    }
}
