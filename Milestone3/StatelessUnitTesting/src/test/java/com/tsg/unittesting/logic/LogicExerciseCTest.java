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

//import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;


/**
 *
 * @author mohammedchowdhury
 */
public class LogicExerciseCTest {
    
    public LogicExerciseCTest() {
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
     * Test of goWalky method, of class LogicExerciseC.
     */

        @Test
    public void testGoWalky0() {
        boolean isDark = false;
        boolean haveFlashlight = false;
        boolean isRaining = false;
        boolean haveUmbrella = false;
        int degreesFarenheit = 0;
        boolean expResult = false;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);
    }

    @Test
    public void testGoWalky1() {
        boolean isDark = true;
        boolean haveFlashlight = false;
        boolean isRaining = true;
        boolean haveUmbrella = true;
        int degreesFarenheit = 75;
        boolean expResult = false;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);
    }

    @Test
    public void testGoWalky2() {
        boolean isDark = false;
        boolean haveFlashlight = true;
        boolean isRaining = false;
        boolean haveUmbrella = false;
        int degreesFarenheit = 50;
        boolean expResult = true;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);
    }

    @Test
    public void testGoWalky3() {
        boolean isDark = false;
        boolean haveFlashlight = false;
        boolean isRaining = false;
        boolean haveUmbrella = false;
        int degreesFarenheit = 30;
        boolean expResult = false;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);
    }
    
}
