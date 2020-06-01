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
public class StringsExerciseCTest {
    
    public StringsExerciseCTest() {
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
     * Test of removeTheVowels method, of class StringsExerciseC.
     */
    @Test
    public void testRemoveTheVowels() {
        String word = "";
        String expResult = "";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);  
    }
        @Test
    public void testRemoveTheVowels1() {
        String word = "truncate";
        String expResult = "trnct";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);  
    }
        @Test
    public void testRemoveTheVowels2() {
        String word = "squashed";
        String expResult = "sqshd";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);  
    }
        @Test
    public void testRemoveTheVowels3() {
        String word = "compressed";
        String expResult = "cmprssd";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);  
    }
    
//         * Ex: removeTheVowels( "truncate" ) -> "trnct" 
//     * removeTheVowels( "squashed") -> "sqshd" 
//     * removeTheVowels( "compressed" ) -> "cmprssd"
    
}
