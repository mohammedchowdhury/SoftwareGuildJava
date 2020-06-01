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
public class ArrayExerciseDTest {

    public ArrayExerciseDTest() {
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
     * Test of pointFree method, of class ArrayExerciseD.
     */
    @Test
    public void testPointFree() {

        //arrange
        double[] numbers = null;
        int expResult = 0;

        //act
        int result = ArrayExerciseD.pointFree(numbers);

        //assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test1() {
//             * pointFree( [1.1, .22]  ) ->  22
//     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
//     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
        //arange
        double[] numbers = {1.12,60,.22};
        //{1.1, .22};
        int expResult = 112;

        //act
        int result = ArrayExerciseD.pointFree(numbers);
        //assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test2() {
        //arrange
        double[] numbers = {.039, 20, .005005};
        int expResult = 5005;
        //act
        int result = ArrayExerciseD.pointFree(numbers);
        //assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void test3() {
        //arrange
        double[] numbers = {-9.9, -700, -.5};
        int expResult = -5;
        //act
        int result = ArrayExerciseD.pointFree(numbers);
        //assert
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

}
