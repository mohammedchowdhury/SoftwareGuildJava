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
public class HealingPotion extends Potion{
        /*fields*/
    /*ctor*/
    public HealingPotion(double cost, double weight) {
        super(cost, weight);
    }

    /*behaviors*/
    @Override
    public void drink() {
        System.out.println("The hero healed 10 HP.");
    }
    
}
