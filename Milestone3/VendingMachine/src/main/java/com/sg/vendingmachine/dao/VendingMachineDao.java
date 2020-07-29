package com.sg.vendingmachine.dao;
import com.sg.vendingmachine.dto.Item;
import java.util.List;
/**
 *
 * @author mohammedchowdhury
 */
public interface VendingMachineDao {
    
    
    /**
     * return list of Items
     * @return 
     */
    public List<Item> getItems() throws VendingMachinePersistenceException;
     
    //used by buyers to get items from machine
    /**
     * returns the item if it exists, or returns null 
     * @param name
     * @return Item or null
     */
    public Item getItem(String name) throws VendingMachinePersistenceException; // return the item or null
    
    /**
     * updates the item in the machine
     * 
     * @param item
     * @return Item
     */
    public Item updateItem(Item item)throws VendingMachinePersistenceException; // updates the item

    //internal for reloading and removing items from vening machine
    /**
     * removes the item from the vending machine. Only to be used by workers. 
     * @param item
     * @return Item{removed item}
     */
    public Item removeItem(Item item) throws VendingMachinePersistenceException;  
    
   /**
    * adds an item to Vending machine. 
    * If the item already exists, it updates the number of item in the inventory
    * if the items dosent exists it will add the item to the list
    * @param item
    * @return Item{added  item with updated inventory}
    */
    public Item addItem(Item item) throws VendingMachinePersistenceException;   
}