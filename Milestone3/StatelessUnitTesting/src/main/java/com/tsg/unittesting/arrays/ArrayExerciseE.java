/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseE {
    
    /**
     * Given an array of words turn it into a single camelCased phrase.
     * Lower case the first word, capitalize the first letter (but only the first) of the rest.
     *
     * camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
     * camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
     * camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
     * @param words
     * @return String camelCased phrase
     */

    public static String camelCaseIt(String[] words){
        String ans = "";        
        if(words==null){
            return ans; 
        }
        
        for(int i=0;i<words.length;i++){
            String temp = words[i]; 
            if(i==0){
                ans = temp.toLowerCase(); 
                continue; 
            }
            temp = temp.toLowerCase(); 
            for(int j = 0; j<temp.length();j++){
                
                String t = temp.charAt(j)+""; 
                
                if(j==0){
                 ans = ans+t.toUpperCase(); 
                }else{
                    ans=ans+t; 
                }       
            }                   
        }     
        return ans; 
        
    }
    
}
