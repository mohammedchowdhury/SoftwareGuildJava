package com.sg.FlooringMastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Tax {

    private String state;
    private BigDecimal taxRate;

//    public Tax(String state, String stateName, String taxRate) {
//        this.state = state;
//        this.stateName = stateName;
//        this.taxRate = new BigDecimal(taxRate);
//    }
    public Tax(String state, String taxRate) {
        this.state = state;
        this.taxRate = new BigDecimal(taxRate);
    }

    public String getState() {
        return state;
    }

//    public String getStateName() {
//        return stateName;
//    }
    public BigDecimal getTaxRate() {
        return taxRate;
    }

//    @Override
//    public String toString() {
//        return state + "," + stateName + "," + taxRate;
//    }

    public String toStringView() {
        return "State: "+state + ", Tax Rate :" + taxRate;
    }

    @Override
    public String toString() {
        return state + "," + "," + taxRate;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 97 * hash + Objects.hashCode(this.state);
//        //hash = 97 * hash + Objects.hashCode(this.stateName);
//        hash = 97 * hash + Objects.hashCode(this.taxRate);
//        return hash;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Tax other = (Tax) obj;
//        if (!Objects.equals(this.state, other.state)) {
//            return false;
//        }
//        if (!Objects.equals(this.stateName, other.stateName)) {
//            return false;
//        }
//        if (!Objects.equals(this.taxRate, other.taxRate)) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.state);
        hash = 53 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }
}
