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
public class StringsExerciseETest {
    
    public StringsExerciseETest() {
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
     * Test of containsTheOther method, of class StringsExerciseE.
     */
    @Test
    public void testContainsTheOther() {
        String one = "";
        String two = "";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
        @Test
    public void testContainsTheOther1() {
        String one = "one";
        String two = "tone";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
        @Test
    public void testContainsTheOther2() {
        String one = "same";
        String two = "same";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
//         * containsTheOther( "one", "tone" ) ->  true
//     * containsTheOther( "same", "same" ) ->  false
//     * containsTheOther( "fancypants", "pants" ) ->  true
//     * containsTheOther( "llama", "duck" ) ->  false
        @Test
    public void testContainsTheOther3() {
        String one = "fancypants";
        String two = "pants";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
        @Test
    public void testContainsTheOther4() {
        String one = "llama";
        String two = "duck";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
    
}
