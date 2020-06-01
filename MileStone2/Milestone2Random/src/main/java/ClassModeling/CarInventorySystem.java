package ClassModeling;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammedchowdhury
 */
public class CarInventorySystem {
    int numOfCarsOnLot, numCarSold;
    double profit, moneyOnBank; 
    ArrayList<String> carsOnLot ; 

    public CarInventorySystem() {
        carsOnLot = new ArrayList<String>(); 
    }
    
    

    public int getNumOfCarsOnLot() {
        return numOfCarsOnLot;
    }

    public void setNumOfCarsOnLot(int numOfCarsOnLot) {
        this.numOfCarsOnLot = numOfCarsOnLot;
    }

    public int getNumCarSold() {
        return numCarSold;
    }

    public void setNumCarSold(int numCarSold) {
        this.numCarSold = numCarSold;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getMoneyOnBank() {
        return moneyOnBank;
    }

    public void setMoneyOnBank(double moneyOnBank) {
        this.moneyOnBank = moneyOnBank;
    }

    public ArrayList<String> getCarsOnLot() {
        return carsOnLot;
    }

    public void setCarsOnLot(ArrayList<String> carsOnLot) {
        this.carsOnLot = carsOnLot;
    }
    
}
