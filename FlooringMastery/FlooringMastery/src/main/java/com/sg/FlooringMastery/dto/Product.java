package com.sg.FlooringMastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Product {
    private String productType; 
    private BigDecimal costPerSquareFoot; 
    private BigDecimal laborCostPerSquareFoot; 
    
    public Product(String productType,String costPerSquareFoot, String laborCostPerSquareFoot){
        this.productType = productType; 
        this.costPerSquareFoot = new BigDecimal(costPerSquareFoot); 
        this.laborCostPerSquareFoot = new BigDecimal(laborCostPerSquareFoot);
    }

    public String getProductType() {
        return productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    @Override
    public String toString() {
        return productType+","+costPerSquareFoot+","+laborCostPerSquareFoot;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.productType);
        hash = 89 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 89 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFoot, other.costPerSquareFoot)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSquareFoot, other.laborCostPerSquareFoot)) {
            return false;
        }
        return true;
    }
    
    
}