/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalAndPetHierarchy;

/**
 *
 * @author mohammedchowdhury
 */
public class Animal {
    private int legs; 
    
    Animal(int numLegs){
        this.legs = numLegs; 
    }
    
    public void walk(){
        System.out.println("Animal walk called");
    }
    
    
    public void eat(){
        System.out.println("Animal eat called");
    }


        
    
}
