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
public class App {
    public static void main(String[] args) {
        Person joe = new Person("Joe",12,new Address("123 Street", "New York", "11111")); 
        System.out.println(joe.toString());
    }
    
}
