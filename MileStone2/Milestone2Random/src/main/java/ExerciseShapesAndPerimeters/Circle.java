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
public class Circle extends Shape{
    private double area, perimeter;
    
    public Circle(String color, double r){
        super(color); 
        area = r*r*Math.PI; 
        perimeter = r*2*Math.PI; 
        
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }
    
    
}
