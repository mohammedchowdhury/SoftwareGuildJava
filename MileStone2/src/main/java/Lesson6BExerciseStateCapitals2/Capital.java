/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson6BExerciseStateCapitals2;

/**
 *
 * @author mohammedchowdhury
 */
public class Capital {
    private String name; 
    private int population; 
    private double squareMileage; 

    public Capital(String name, int population, double squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getSquareMileage() {
        return squareMileage;
    }
    
}
