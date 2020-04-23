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
public class Fish extends Animal implements Pet{
    private String name; 
    Fish(){
        super(0);
    }
    
    public String getName(){
        return this.name; 
    }
    public void setName(String name){
        this.name = name; 
    }
    
    @Override
    public void play(){
        System.out.println("Fish class play called");
    }
    
    @Override
    public void walk(){
        System.out.println("Fish walk class called. Fish cant walk");
    }
    
    @Override
    public void eat(){
        System.out.println("Eat called in fish class");
        
    }
 
}
