/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseShapesAndPerimeters;

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    public static void main(String[] args) {
        
        Square sq = new Square("red", 10); 
        System.out.println(sq.getArea());
          System.out.println(sq.getPerimeter());
        
    }
    
}
