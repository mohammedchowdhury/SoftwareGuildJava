package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author mohammedchowdhury
 */
public interface VendingMachineService {
    //used by buyer
   /**
    * return the i
    * @return item if the user has the right amout of money
    */ 
   public Item getItem(String itemName, BigDecimal price)throws VendingMachinePersistenceException,NoItemInventoryException, InsufficientFundsException;
   /**
    * 
    * @return list of items avaliable for sale
    */
   public List<Item> getItems() throws VendingMachinePersistenceException; 
   
   /**
    * 
    * @return Item if the inventory/ price was updated
    */
//   public Item updateItem() throws VendingMachinePersistenceException;
   
   //used by seller
   /**
    * 
    * @return Removed item
    */
   public Item removeItem(String itemName)throws VendingMachinePersistenceException,NoItemInventoryException;
   /**
    * 
    * @return allows you to add a new item to machine / update the quantity 
    */
   public Item addItem(Item item)throws VendingMachinePersistenceException,ItemDataValidationException;
}