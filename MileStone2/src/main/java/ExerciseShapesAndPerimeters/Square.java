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
public class Square extends Shape{
    
    private double area, perimeter; 

    public Square(String color, double l) {
        super(color); 
        area = l*l;
        perimeter = 4*l; 
        
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }
    
    
    
      
}
