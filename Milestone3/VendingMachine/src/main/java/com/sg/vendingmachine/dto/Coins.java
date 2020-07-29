package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
/**
 *
 * @author mohammedchowdhury
 */
public enum Coins {
    QUARTER(".25"),
    DIME(".10"),
    NICKLE(".05"),
    PENNY(".01");

    private BigDecimal value;
    private BigDecimal numOfCoin;
    private int numOfCoinInt;

    Coins(String x) {
        value = new BigDecimal(x);
    }

    public void setnumOfCoin(BigDecimal n) {
        numOfCoin = n;
        this.numOfCoinInt = Integer.parseInt(n.toString());
    }

    public BigDecimal getnumOfCoin() {
        return this.numOfCoin;
    }

    public int getnumOfCoinInt() {
        return numOfCoinInt;
    }

    public BigDecimal getValue() {
        return this.value;
    }

}