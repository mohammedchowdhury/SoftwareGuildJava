/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.arrays;
/**
 *
 * @author ahill
 */
public class ArrayExerciseD {
    /**
     * Given an array of doubles, return the biggest number of the lot, as if
     * the decimal had gone missing!
     *
     *
     * pointFree( [1.1, .22] ) -> 22 pointFree( [ .039 , 20 , .005005 ] ) ->
     * 5005 pointFree( [ -9.9 , -700 , -.5 ] ) -> -5
     *
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers) {
        int ans = Integer.MIN_VALUE; 
        if(numbers==null || numbers.length==0){
            return 0; 
        }      
        for(int i=0;i<numbers.length;i++){
            int tempX = turnToInt(numbers[i]); // .1 , .4 ,.6 
            if(ans<tempX){
                ans = tempX; 
            }       
        }     
        return ans;    
    }
    private static int turnToInt(double x) {
        int xx = (int) (x); 
        if(xx-x==0){
            return xx; 
        }
        String ans = "";
        String xSt = x + "";  // .1002  1002
        System.out.println(xSt);
        for (int i = 0; i < xSt.length(); i++) {
            if (xSt.charAt(i) != '.') {
                ans = ans + xSt.charAt(i);
            }
        }
        return Integer.parseInt(ans);
    }
}