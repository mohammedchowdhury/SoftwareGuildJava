/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lesson6lamdasandstreams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        Person p1 = new Person("Joe", 12);
        Person p2 = new Person("BOB", 5);
        Person p3 = new Person("SAm", 20);
        Person p4 = new Person("ham", 23);
        Person p5 = new Person("mom", 44);

        Person p6 = new Person("Joe1", 13);
        Person p7 = new Person("BOB1", 10);
        Person p8 = new Person("SAm1", 22);
        Person p9 = new Person("ham1", 27);
        Person p10 = new Person("mom1", 94);
        
        System.out.println(p1.getAge());

//        List<Person> person = new ArrayList<Person>();
//        person.add(p1);
//        person.add(p2);
//        person.add(p3);
//        person.add(p4);
//        person.add(p5);
//
//        person.add(p6);
//        person.add(p7);
//        person.add(p8);
//        person.add(p9);
//        person.add(p10);
//
//     Person minByAge = person
//      .stream()
//      .min(Comparator.comparing(Person::getAge))
//      .orElseThrow(NoSuchElementException::new);
//     
//        System.out.println(minByAge.toString());

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
//
//         LocalDate ld = LocalDate.parse("02/07/2010", formatter);
//         
//         
//         
//         LocalDate ld2 = LocalDate.parse("02/07/2013", formatter);
    }
}
