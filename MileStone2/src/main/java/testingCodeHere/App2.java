/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingCodeHere;

/**
 *
 * @author mohammedchowdhury
 */
public class App2 {
    public static void main(String[] args) {
        
        System.out.println("Bug as type Animal");
        Animal bug = new Animal(6, 0, false, true);
        bug.eat();
        bug.sleep();
        bug.reproduce();
        
        
        
        //We cannot call any methods from Primate or Human here
        System.out.println("");
        System.out.println("Monkey as type Primate, can walk which Animal class cannot");
        Primate monkey = new Primate(2, 2, true, false);
        monkey.walk();
        monkey.eat();
        monkey.reproduce(); //pulls from the Animal class
        //We can call methods from Primate and Animal here
        System.out.println("");
        System.out.println("Human as type Human, has access to read method");
        
        
        
        Human person = new Human(1, 2);
        person.read();
        person.walk();//from the primate method
        person.eat(); 
        person.reproduce();
        //We can call methods from Human, Primate, and Animal here
        System.out.println("");
        System.out.println("The Human class has a read method that is exclusive to it.");
        System.out.println("Human test subject 2 as type Animal, so it cannot read");
        Animal person2 = new Human();
        person2.eat();
        person2.reproduce();
        person.sleep();
        //person2.read();
        //We cannot call methods from Human here that are not in other
        //methods. We can call eat because it is overridden in Human
        //and it exists in Primate and Animal, but it will give the result
        //of the method listed in Human.
        //We cannot call read, because it is unique to the Human class
        //and not in Animal
        System.out.println("");
        System.out.println("Human 3 as type Primate, it cannot read");
        Primate person3 = new Human();
        person3.walk();
        person3.eat();
        person3.sleep();
        //person3.read();// will not run because we can only access the Primate functions
        //We cannot call on methods from Human here, only those available to Primate.
        ((Human) person3).read();
        //Here, we cast the human from Primate to Human, so it now can access the 
        //read method which is exclusive to Humans
        //If we create something of a higher type, we can downcast it to get
        //access to the methods in the subclasses.
        
        String delimiter = "~"; 
        
        
        
        
    }
}
