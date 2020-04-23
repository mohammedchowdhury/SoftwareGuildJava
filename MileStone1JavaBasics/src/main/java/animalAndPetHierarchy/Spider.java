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
public class Spider extends Animal{  
    Spider() {
        super(8);
    }
    
    @Override
    public void eat(){
        System.out.println("Spider eat called");
    }  
}
