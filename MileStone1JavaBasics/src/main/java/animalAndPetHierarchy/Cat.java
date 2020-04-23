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
public class Cat extends Animal implements Pet{
    private String name; 

    Cat(String name) {
        super(4); 
        this.name = name; 
    }
    
    Cat(){
       super(4); 
    }
    
    public String getName(){
        return this.name; 
    }
    public void setName(String name){
        this.name = name; 
    }   
   
    public void play(){
        System.out.println(this.name+" : cat is playing");
    }
    
    @Override
    public void eat(){
        System.out.println("Cat eat called");
    }
}
