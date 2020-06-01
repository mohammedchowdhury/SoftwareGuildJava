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
  abstract class Shape {
    String color; 
    double area,perimeter; 
    
    public Shape(String color){
        this.color = color;
    }
    
    public double getPerimeter(){
       return 0; 
    }
    
    public double getArea(){
        return 0;  
    }

}
