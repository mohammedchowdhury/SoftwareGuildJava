/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.strings;

/**
 *
 * @author ahill
 */
public class StringsExerciseC {

    /**
     * Take a word, and remove all its vowels and returns it.
     *
     * Ex: removeTheVowels( "truncate" ) -> "trnct" 
     * removeTheVowels( "squashed") -> "sqshd" 
     * removeTheVowels( "compressed" ) -> "cmprssd"
     *
     * @param word
     * @return String
     */
    public static String removeTheVowels(String word) {
        word = word.replaceAll("a", "");
        word = word.replaceAll("A", "");
        word = word.replaceAll("e", "");
        word = word.replaceAll("E", "");
        word = word.replaceAll("i", "");
        word = word.replaceAll("I", "");
        word = word.replaceAll("o", "");
        word = word.replaceAll("O", "");
        word = word.replaceAll("u", "");
        word = word.replaceAll("U", "");

        return word;
    }

}
