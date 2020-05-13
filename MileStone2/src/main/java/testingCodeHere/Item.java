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
public class Item {

    /*fields - protected as this will be the superclass*/
    protected double cost;
    protected double weight;

    /*ctor*/
    public Item() {

    }

    public Item(double cost, double weight) {
        this.cost = cost;
        this.weight = weight;
    }

    /*getter/setters*/
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}