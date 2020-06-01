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
public class StringsExerciseDTest {
    
    public StringsExerciseDTest() {
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
     * Test of simpleReverse method, of class StringsExerciseD.
     */
    @Test
    public void testSimpleReverse() {
        String phrase = "";
        String expResult = "";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testSimpleReverse1() {
        String phrase =  "fun times";
        String expResult = "semit nuf";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
        @Test
    public void testSimpleReverse2() {
        String phrase = "llama llama duck";
        String expResult = "kcud amall amall";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
        @Test
    public void testSimpleReverse3() {
        String phrase = "hannah";
        String expResult = "hannah";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
    
//         * simpleReverse( "fun times" ) ->  "semit nuf"
//     * simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
//     * simpleReverse( "hannah" ) ->  "hannah"
    
}
