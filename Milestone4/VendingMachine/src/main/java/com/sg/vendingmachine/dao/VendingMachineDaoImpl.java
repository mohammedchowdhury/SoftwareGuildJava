package com.sg.vendingmachine.dao;
/**
 *
 * @author mohammedchowdhury
 */
import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDaoImpl implements VendingMachineDao {
    private Map<String, Item> items = new HashMap<String, Item>();

    public String VENDINGMACHINE_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineDaoImpl() {
        this.VENDINGMACHINE_FILE = "VendingMachine.txt";
    }

    public VendingMachineDaoImpl(String fileName) {
        this.VENDINGMACHINE_FILE = fileName;
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException { // works
        loadItems();
        return items.get(name);
    }
    
    public List<Item> getItems() throws VendingMachinePersistenceException{
         loadItems();
        return new ArrayList(items.values());
    }

    public Item updateItem(Item item) throws VendingMachinePersistenceException { // works 
        loadItems();
        if (items.get(item.getItemName()) != null) {     
            this.items.put(item.getItemName(), item);
            writeVendingMachine();
            return item;
        }
        return null;
    }

    @Override
    public Item addItem(Item item) throws VendingMachinePersistenceException { //works 
        loadItems();
        if (items.containsKey(item.getItemName())) {
            int inventory = items.get(item.getItemName()).getInventory();
            inventory = inventory + item.getInventory();
            item.setInventory(inventory);
        }
        Item returnItem = this.items.put(item.getItemName(), item);
        writeVendingMachine();
        return returnItem;
    }

    @Override
    public Item removeItem(Item item) throws VendingMachinePersistenceException { // works
        loadItems();
        Item removedItem = items.remove(item.getItemName());
        writeVendingMachine();
        return removedItem;

    }

    private void writeVendingMachine() throws VendingMachinePersistenceException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save Item data.", e);
        }
        String dvdAsText;
        List<Item> itemList = new ArrayList(items.values());
        for (Item currentItem : itemList) {
            dvdAsText = marshallItem(currentItem);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }

    private String marshallItem(Item item) {
        String itemString = item.getItemName() + DELIMITER;
        itemString = itemString + item.getPriceString() + DELIMITER;
        itemString = itemString + item.getInventoryString();
        return itemString;
    }

    private Item unmarshallItem(String ItemAsText) { // takes in one line
        String[] itemArr = ItemAsText.split(DELIMITER);
        return new Item(itemArr[0], itemArr[1], itemArr[2]);
    }

    private void loadItems() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VENDINGMACHINE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("-_- Could not load items data into memory.", e);
        }
        String currentLine;
        Item currentItem;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            items.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }
}
