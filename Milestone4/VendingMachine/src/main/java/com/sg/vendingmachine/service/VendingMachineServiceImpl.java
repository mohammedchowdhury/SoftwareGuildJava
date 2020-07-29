package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mohammedchowdhury
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    public Item getItem(String itemName, BigDecimal price) throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        Item item = dao.getItem(itemName);
        if (item == null) {
            throw new NoItemInventoryException(itemName + " : No such Item found in vending machine");
        }
        if (item.getInventory() == 0 || item == null) {
            throw new NoItemInventoryException(itemName + " : No such Item found in vending machine");
        }

        int x = price.compareTo(item.getPrice());

        if (x == -1) {
            throw new InsufficientFundsException("Insufficient Funds " + price.toString());
        }

        item.setInventory(item.getInventory() - 1);

        writeToAudit(item.getItemName() + " Purchase Successful");

        dao.updateItem(item);
        return item;
    }

    public List<Item> getItems() throws VendingMachinePersistenceException {
        List<Item> items = dao.getItems();
        List<Item> itemList = items.stream()
                .filter(x -> x.getInventory() != 0)
                .collect(Collectors.toList());

        return itemList;
    }

    public Item removeItem(String itemName) throws VendingMachinePersistenceException, NoItemInventoryException {
        Item item = dao.getItem(itemName);
        if (item == null) {
            throw new NoItemInventoryException(itemName + " : No such Item found in vending machine");
        }
        Item removedItem = dao.removeItem(item);
        if (removedItem != null) {
            writeToAudit(itemName + " Successfully Removed");
        }
        return removedItem;
    }

    public Item addItem(Item item) throws VendingMachinePersistenceException, ItemDataValidationException{
        //validate the item is valid 
        validateDate(item);
        return dao.addItem(item);
    }

    private void writeToAudit(String message) throws VendingMachinePersistenceException {
        auditDao.writeAuditEntry(message);
    }

    private void validateDate(Item item) throws ItemDataValidationException{
        if (item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getPriceString() == null
                || item.getPriceString().trim().length() == 0
                || item.getInventory() == 0
                || item.getInventoryString().trim().length() == 0
                || item.getInventoryString() == null) {
            throw new ItemDataValidationException(
                    "ERROR: All fields [Item Name, Cast, Quantity] are required.");
        }
    }

}