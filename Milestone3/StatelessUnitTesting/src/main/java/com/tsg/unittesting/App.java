/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) {
        Student alex1 = new Student("Alex",1);
        Student alex2 = new Student("Alex",1);
        HashSet < Student > students = new HashSet < Student > ();
        students.add(alex1);
        students.add(alex2);
        System.out.println("HashSet size = " + students.size());
        System.out.println("HashSet contains Alex = " + students.contains(new Student("Alex",1)));
    }

}

class Student{
    String name; 
    int age; 
    
    
    public Student(String name, int age){
        this.name = name; 
        this.age = age; 
               
    }
    
    
}
