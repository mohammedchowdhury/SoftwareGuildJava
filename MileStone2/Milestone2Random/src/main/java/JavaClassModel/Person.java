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
public class Person {
    private String name; 
    private int age; 
    private Address address; 
    
    public Person(String name, int age, Address address){
        this.name = name; 
        this.age = age; 
        this.address = address;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Name : "+name+" Age : "+age+" Address : "+address.toString();        
    }  
}
