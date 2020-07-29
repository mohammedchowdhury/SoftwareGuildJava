package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineDaoImplTest {

    VendingMachineDao dao;

    public VendingMachineDaoImplTest() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testVendingMachine.txt";
        new FileWriter(testFile);
        dao = new VendingMachineDaoImpl(testFile);
    }

    /**
     * testing addItem / getItem Adding one item checkig the size / retreving
     * the same item again
     *
     * @throws VendingMachinePersistenceException
     */
    @Test
    public void testAddOneItem() throws VendingMachinePersistenceException {
        Item item1 = new Item("Chips", "1.50", "20");
        dao.addItem(item1);
        assertEquals(item1, dao.getItem(item1.getItemName()));
        assertEquals(1, dao.getItems().size());
    }

    /**
     * testing addItem / getItem adding two items and checking the size.
     * Retreving items and checking size
     *
     * @throws VendingMachinePersistenceException
     */
    @Test
    public void testAddTwoItemSame() throws VendingMachinePersistenceException { //adding the same item two times 
        Item item1 = new Item("Chips", "1.50", "20");
        Item item2 = new Item("Chips", "1.50", "20");

        dao.addItem(item1);
        dao.addItem(item2);

        assertEquals(item2, dao.getItem(item1.getItemName()));
        assertEquals(1, dao.getItems().size());
    }

    @Test
    public void testRemoveItem() throws VendingMachinePersistenceException { //adding the same item two times 
        Item item1 = new Item("Chips", "1.50", "20");
        Item item2 = new Item("Apple", "1.50", "20");

        dao.addItem(item1);
        dao.addItem(item2);

        assertEquals(item1, dao.getItem(item1.getItemName()));
        assertEquals(2, dao.getItems().size());

        assertEquals(item1, dao.removeItem(item1));
        assertEquals(1, dao.getItems().size());
        assertEquals(null, dao.getItem(item1.getItemName()));

        assertEquals(item2, dao.removeItem(item2));
        assertEquals(0, dao.getItems().size());
        assertEquals(null, dao.getItem(item1.getItemName()));
    }

    /**
     * testign update with remove/get/add
     * @throws VendingMachinePersistenceException 
     */
    @Test
    public void testUpdateItem() throws VendingMachinePersistenceException { //adding the same item two times 
        Item item1 = new Item("Chips", "1.50", "20");
        Item item2 = new Item("Apple", "1.50", "20");

        dao.addItem(item1);
        dao.addItem(item2);

        assertEquals(item1, dao.getItem(item1.getItemName()));
        assertEquals(2, dao.getItems().size());

        item1.setInventory(10);
        item1.setPrice("2");

        assertEquals(item1, dao.updateItem(item1));
        assertEquals(2, dao.getItems().size());
        assertEquals(item1, dao.getItem(item1.getItemName()));

        item2.setInventory(100);
        item2.setPrice("3");

        assertEquals(item2, dao.updateItem(item2));
        assertEquals(2, dao.getItems().size());

        assertEquals(item1, dao.removeItem(item1));
        assertEquals(1, dao.getItems().size());
        assertEquals(null, dao.getItem(item1.getItemName()));

        assertEquals(item2, dao.removeItem(item2));
        assertEquals(0, dao.getItems().size());
        assertEquals(null, dao.getItem(item1.getItemName()));

        assertEquals(0, dao.getItems().size());
    }
}
