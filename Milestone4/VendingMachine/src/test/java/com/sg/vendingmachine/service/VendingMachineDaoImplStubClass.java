/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineDaoImplStubClass implements VendingMachineDao {

    private Item oneItem;

    public VendingMachineDaoImplStubClass() {
        oneItem = new Item("Chips", "1.50", "30");
    }

    public Item getItem(String name) {  
        if(name.equals(oneItem.getItemName())){
            return this.oneItem; 
        }
        return null; 
    }

    public List<Item> getItems() throws VendingMachinePersistenceException {
        List<Item> items = new ArrayList<Item>();
        items.add(this.oneItem);
        return items;
    }

    public Item updateItem(Item item) throws VendingMachinePersistenceException { // works       
        if (this.oneItem.getItemName().equals(item.getItemName())) {
            return item;
        }
        return null;
    }

    public Item addItem(Item item) throws VendingMachinePersistenceException {
        if (this.oneItem.getItemName().equals( item.getItemName())){       
            int inventory = oneItem.getInventory();
            inventory = inventory + item.getInventory();
            item.setInventory(inventory);
            return item;
        }
        return null;
    }

    public Item removeItem(Item item) throws VendingMachinePersistenceException {
        if (this.oneItem.equals(item)) {
            return item;
        }
        return null;
    }

}
