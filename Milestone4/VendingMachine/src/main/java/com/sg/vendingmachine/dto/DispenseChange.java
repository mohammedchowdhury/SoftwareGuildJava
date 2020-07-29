/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author mohammedchowdhury
 */
public class DispenseChange {
    

    
    public static Coins[] dispenseChange(BigDecimal money) {

        Coins [] arr = new Coins[4];
        
        
      
        BigDecimal x = money;
        BigDecimal[] ans = x.divideAndRemainder(Coins.QUARTER.getValue());
        Coins.QUARTER.setnumOfCoin(ans[0]);   //Holds the number of Quarter   
        arr[0] = Coins.QUARTER;

        x = ans[1];
        ans = x.divideAndRemainder(Coins.DIME.getValue());
        Coins.DIME.setnumOfCoin(ans[0]);
        arr[1] = Coins.DIME;

        x = ans[1];
        ans = x.divideAndRemainder(Coins.NICKLE.getValue());
        Coins.NICKLE.setnumOfCoin(ans[0]);
        arr[2] = Coins.NICKLE;

        x = ans[1];
        ans = x.divideAndRemainder(Coins.PENNY.getValue());
        Coins.PENNY.setnumOfCoin(ans[0]);
        arr[3] = Coins.PENNY;
        
        return arr; 

    }
    
}
