/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson5CExerciseUserIOClassLab;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) {
        UserIO input = new UserIOImpl(); 
        
        for(int a=0; a<4;a++){
            
        System.out.println(input.readFloat("Enter a number :"));
        
        }

    }

}
