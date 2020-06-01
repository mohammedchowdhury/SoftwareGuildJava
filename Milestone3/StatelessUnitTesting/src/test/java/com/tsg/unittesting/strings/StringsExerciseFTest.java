/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.strings;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mohammedchowdhury
 */
public class StringsExerciseFTest {

    public StringsExerciseFTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of longestWord method, of class StringsExerciseF.
     */
    @Test
    public void testLongestWord() {
        String aPhrase = "";
        String expResult = "";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);

    }

//       * longestWord( "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple" ) ->  "perspiration"
//     * longestWord( "All well-established principles should be periodically challenged" ) ->  "well-established"
//     * longestWord( "Never argue with the data" ) ->  "Never"
    @Test
    public void testLongestWord1() {
        String aPhrase = "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple";
        String expResult = "perspiration";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);

    }

    @Test
    public void testLongestWord2() {
        String aPhrase = "All well-established principles should be periodically challenged";
        String expResult = "well-established";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);

    }

    @Test
    public void testLongestWord3() {
        String aPhrase = "Never argue with the data";
        String expResult = "Never";
        String result = StringsExerciseF.longestWord(aPhrase);
        assertEquals(expResult, result);
    }

}
