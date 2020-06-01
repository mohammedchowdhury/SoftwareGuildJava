/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

/**
 *
 * @author mohammedchowdhury
 */
public class LogicExerciseDTest {
    
    public LogicExerciseDTest() {
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
     * Test of isFirstTheFirst method, of class LogicExerciseD.
     */
    @Test
    public void testIsFirstTheFirst() {
        char letterOne = ' ';
        char letterTwo = ' ';
        boolean expResult = false;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testIsFirstTheFirst1() {
        char letterOne = 'a';
        char letterTwo = 'b';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    
            @Test
    public void testIsFirstTheFirst2() {
        char letterOne = 'O';
        char letterTwo = 'X';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    
                @Test
    public void testIsFirstTheFirst3() {
        char letterOne = 'Z';
        char letterTwo = 'z';
        boolean expResult = false;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
    }
    
//         * isFirstTheFirst( 'a' , 'b'  ) ->  true
//     * isFirstTheFirst( 'O' , 'X'  ) ->  true
//     * isFirstTheFirst( 'Z' , 'z'   ) -> false
    
}
