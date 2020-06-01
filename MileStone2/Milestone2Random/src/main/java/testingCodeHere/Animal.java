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
public class Animal implements DailyActivities {
//has fields and methods
    int numberOfLegs;
    int numberOfHands;
    boolean hasFur;
    boolean hasWings;
    public Animal(int numberOfLegs, int numberOfHands, boolean hasFur, boolean hasWings) {
        this.numberOfLegs = numberOfLegs;
        this.numberOfHands = numberOfHands;
        this.hasFur = hasFur;
        this.hasWings = hasWings;
    }
    @Override
    public void eat() {
        System.out.println("I am hungry!");
    }
    @Override
    public void sleep() {
        System.out.println("I am sleeping, do not disturb me.");
    }
    @Override
    public void reproduce() {
        System.out.println("Baby making time! Baby factory is open.");
    }
}



class Primate extends Animal {
    public Primate(int numberOfLegs, int numberOfHands, boolean hasFur, boolean hasWings) {
        super(numberOfLegs, numberOfHands, hasFur, hasWings);
    }
    public void walk() {
        System.out.println("I am walking on my feet");
    }
    @Override
    public void eat() {
        System.out.println("Eating with hands");
    }
}



class Human extends Primate {
    int numberOfLegs;
    int numberOfHands;
    boolean hasFur = false;
    boolean hasWings = false;
    public Human() {
        super(2, 2, false, false);
    }
    public Human(int numberOfLegs, int numberOfHands) {
        super(numberOfLegs, numberOfHands, false, false);
    }
    public void read() {
        System.out.println("Reading is fun-for-mental.");
    }
    @Override
    public void eat() {
        System.out.println("Eating with forks!");
    }
}
