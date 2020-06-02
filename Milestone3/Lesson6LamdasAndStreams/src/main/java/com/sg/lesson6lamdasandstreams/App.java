/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lesson6lamdasandstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) {

        Person p1 = new Person("Joe", 12);
        Person p2 = new Person("BOB", 5);
        Person p3 = new Person("SAm", 20);
        Person p4 = new Person("ham", 23);
        Person p5 = new Person("mom", 44);
        
        List<Person> person = new  ArrayList<Person>(); 
        person.add(p1); person.add(p2); person.add(p3); person.add(p4); person.add(p5);
        
        System.out.println(person.size());
        
        List<Person> overEighteen = person.stream()
                            .filter((p) -> p.getAge() >= 18)
                            .collect(Collectors.toList());
        

        for (Person person1 : overEighteen) {
            System.out.println(person1.toString());
            
        }
                
              
        

    }

}
