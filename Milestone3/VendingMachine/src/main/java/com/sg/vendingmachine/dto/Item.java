package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Item {

    private String itemName;
    private BigDecimal price;
    private int inventory;

    public Item(String itemName, String price, String inventory) {
        this.itemName = itemName;
        this.price = new BigDecimal(price);
        this.inventory = Integer.parseInt(inventory);
    }

    public Item(String itemName, String price, int inventory) {
        this.itemName = itemName;
        this.price = new BigDecimal(price);
        this.inventory = inventory;
    }

    public Item(String itemName, BigDecimal price, int inventory) {
        this.itemName = itemName;
        this.price = price;
        this.inventory = inventory;
    }

    public String getItemName() {
        return this.itemName;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getInventory() {
        return inventory;
    }

    public String getPriceString() {
        return price.toString();
    }

    public String getInventoryString() {
        return Integer.toString(inventory);
    }

    
    //setters
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public void setInventory(String inventory) {
        this.inventory = Integer.parseInt(inventory);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.itemName);
        hash = 41 * hash + Objects.hashCode(this.price);
        hash = 41 * hash + this.inventory;
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
        final Item other = (Item) obj;
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", price=" + price + ", inventory=" + inventory + '}';
    }

}
