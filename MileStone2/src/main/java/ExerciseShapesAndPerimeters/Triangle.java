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
public class Triangle extends Shape{  
    private double area, perimeter;
    
    public Triangle(String color, double base, double height){
        super(color);
        area = (base*height)/2; 
        perimeter = base*3; 
        
        
        
                
        
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
