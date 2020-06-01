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
public class Potion extends Item {

    /*ctor*/
    public Potion(double cost, double weight) {
        super(cost, weight); //calls the superclass's ctor
    }

    /*behaviors*/
    public void drink() {
        System.out.println("The hero sipped the potion.");
    }
}