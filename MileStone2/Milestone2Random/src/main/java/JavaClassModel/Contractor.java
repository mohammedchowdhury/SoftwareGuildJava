/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClassModel;

/**
 *
 * @author mohammedchowdhury
 */
public class Contractor extends Person{
    boolean permanent; 
    double hourlyRate; 

    public Contractor(String name, int age, Address address, boolean permanent, double hourlyRate) {
        super(name, age, address);
        this.permanent = permanent; 
        this.hourlyRate = hourlyRate; 
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    
    
    
    
}
