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
public class LogicExerciseETest {

    public LogicExerciseETest() {
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
     * Test of whatColor method, of class LogicExerciseE.
     */
    @Test
    public void testWhatColor() {
        int waveLengthNM = 0;
        int frequencyTHZ = 0;
        double photonicEnergyEV = 0.0;
        String expResult = "Unknown";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);

    }

    @Test
    public void testWhatColor1() {
        int waveLengthNM = 575;
        int frequencyTHZ = 510;
        double photonicEnergyEV = 2.15;
        String expResult = "Yellow";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }

    @Test
    public void testWhatColor2() {
        int waveLengthNM = 449;
        int frequencyTHZ = 670;
        double photonicEnergyEV = 3.00;
        String expResult = "Violet";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testWhatColor3() {
        int waveLengthNM = 621;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 16.5;
        String expResult = "Unknown";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWhatColor4(){
        int waveLengthNM = 590;
        int frequencyTHZ = 508;
        double photonicEnergyEV = 2.05;
        String expResult = "Orange";
        String result = LogicExerciseE.whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        assertEquals(expResult, result);
    }
    


//     * whatColor( 575, 510, 2.15 ) ->  "Yellow"
//     * whatColor( 449, 670, 3.00 ) ->  "Violet"
//     * whatColor( 621, 475, 16.5 ) ->  "Unknown"
//     * whatColor( 590, 508, 2.05 ) ->  "Orange"
//     * whatColor( 570, 526, 2.17 ) ->  "Yellow-Green"
}
