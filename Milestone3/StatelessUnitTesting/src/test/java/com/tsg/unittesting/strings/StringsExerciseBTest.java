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
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohammedchowdhury
 */
public class StringsExerciseBTest {
    
    public StringsExerciseBTest() {
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
     * Test of tripleIt method, of class StringsExerciseB.
     */
    @Test
    public void testTripleIt() {
      
        String theString = "";
        String expResult = "";
        String result = StringsExerciseB.tripleIt(theString);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTripleIt1() {
      
        String theString = "Llama";
        String expResult = "llamaLLAMAllama";
        String result = StringsExerciseB.tripleIt(theString);
        assertEquals(expResult, result);
    }
        @Test
    public void testTripleIt2() {
      
        String theString = "ha";
        String expResult = "haHAha";
        String result = StringsExerciseB.tripleIt(theString);
        assertEquals(expResult, result);
    }
        @Test
    public void testTripleIt3() {
      
        String theString = "Beetlejuice";
        String expResult = "beetlejuiceBEETLEJUICEbeetlejuice";
        String result = StringsExerciseB.tripleIt(theString);
        assertEquals(expResult, result);
    }
//         * tripleIt( "Llama" ) ->  "llamaLLAMAllama"
//     * tripleIt( "ha" ) ->  "haHAha"
//     * tripleIt( "Beetlejuice" ) ->  "beetlejuiceBEETLEJUICEbeetlejuice"
    
}
