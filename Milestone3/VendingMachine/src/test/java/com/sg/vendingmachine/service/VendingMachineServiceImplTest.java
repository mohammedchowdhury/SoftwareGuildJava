package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineServiceImplTest {

    VendingMachineService service;

    public VendingMachineServiceImplTest() {
        VendingMachineDao dao = new VendingMachineDaoImplStubClass(); //fake dao
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();   // fake auditDao 
        service = new VendingMachineServiceImpl(dao, auditDao);
    }

    @Test
    public void testGetItem() throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        Item oneItem = new Item("Chips", "1.50", "29");
        Item returnedItem = service.getItem("Chips", new BigDecimal("2"));
        assertTrue(oneItem.equals(returnedItem));
    }

    @Test
    public void testGetItemExceptionInsufficientFundsException() throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        try {
            Item returnedItem = service.getItem("Chips", new BigDecimal("1"));
            fail("Insufficent funds");
        } catch (InsufficientFundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetItemExceptionNoItemInventoryException() throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException {
        try {
            Item returnedItem = service.getItem("Joe", new BigDecimal("3"));
            fail("Insufficent funds");
        } catch (NoItemInventoryException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetItems() throws VendingMachinePersistenceException {
        List<Item> items = service.getItems();
        Item oneItem = new Item("Chips", "1.50", "30");
        assertEquals(1, items.size());
        assertTrue(items.get(0).equals(oneItem));
    }

    @Test
    public void testRemoveItemsNoItemInventoryException() throws VendingMachinePersistenceException, NoItemInventoryException {
        try {
            Item returnedItem = service.removeItem("Apple");
            fail("Expected no items in inventory");
        } catch (NoItemInventoryException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testRemoveItemsNoItem() throws VendingMachinePersistenceException, NoItemInventoryException {
        Item oneItem = new Item("Chips", "1.50", "30");
        Item returnedItem = service.removeItem("Chips");

        assertTrue(oneItem.equals(returnedItem));
    }

    @Test
    public void testAddItemItemDataValidationException() throws VendingMachinePersistenceException, ItemDataValidationException {
        Item oneItem = new Item("", "1.50", "20");
        try {
            Item returnedItem = service.addItem(oneItem);
            fail("Expected DataValidation Exception");
        } catch (ItemDataValidationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddItem() throws VendingMachinePersistenceException, ItemDataValidationException {
        Item oneItem = new Item("Chips", "1.50", "20");
        Item it2 = new Item("Chips", "1.50", "50");
        Item returnedItem = service.addItem(oneItem);
        assertTrue(it2.equals(returnedItem));
    }

    @Test
    public void testAddItemNewItem() throws VendingMachinePersistenceException, ItemDataValidationException {
        Item oneItem = new Item("Chicken", "1.50", "20");
        Item returnedItem = service.addItem(oneItem);
        assertTrue(returnedItem == null);
    }
}
