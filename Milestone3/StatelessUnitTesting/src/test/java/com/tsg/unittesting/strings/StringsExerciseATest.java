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
public class StringsExerciseATest {
    
    public StringsExerciseATest() {
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
     * Test of yell method, of class StringsExerciseA.
     */
    @Test
    public void testYell() {
        String word = "";
        String expResult = "";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testYell1() {
        String word = "Hello there.";
        String expResult = "HELLO THERE.";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testYell2() {
        String word = "shhhhhhhhhhhh";
        String expResult = "SHHHHHHHHHHHH";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testYell3() {
        String word = "AAaAAAaAAAaaAAHHHH";
        String expResult = "AAAAAAAAAAAAAAHHHH";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
    }
    
//         * yell( "Hello there." ) ->  "HELLO THERE."
//     * yell( "shhhhhhhhhhhh" ) ->  SHHHHHHHHHHHH
//     * yell( "AAaAAAaAAAaaAAHHHH" ) ->  "AAAAAAAAAAAAAAHHHH"
    
}
