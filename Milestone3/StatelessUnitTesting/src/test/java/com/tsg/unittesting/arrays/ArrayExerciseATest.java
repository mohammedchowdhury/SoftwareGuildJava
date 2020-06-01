/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohammedchowdhury
 */
public class ArrayExerciseATest {

    public ArrayExerciseATest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of maxOfArray method, of class ArrayExerciseA.
     */
    @Test
    public void testMaxOfArray() {
        //arrange
        int[] numbers = null;
        int expResult = 0;
        //act
        int result = ArrayExerciseA.maxOfArray(numbers);
        //assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMaxOfArray1() {
        //arrange
        int[] numbers = {1};
        int expResult = 1;
        //act
        int result = ArrayExerciseA.maxOfArray(numbers);
        //assert
        assertEquals(expResult, result);
    }
    



    @Test
    public void testMaxOfArray2() {
        //arrange
        int[] numbers =  {3,4,5}; 
        int expResult = 5;
        //act
        int result = ArrayExerciseA.maxOfArray(numbers);
        //assert
        assertEquals(expResult, result);
    }

    ////     * maxOfArray(   ) ->  -3
    @Test
    public void testMaxOfArray3() {
        //arrange
        int[] numbers = {-9000, -700, -50, -3};
        int expResult = -3;
        //act
        int result = ArrayExerciseA.maxOfArray(numbers);
        //assert
        assertEquals(expResult, result);
    }

}
