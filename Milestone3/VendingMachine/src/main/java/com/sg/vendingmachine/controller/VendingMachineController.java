package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.ItemDataValidationException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.view.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineController {

    private VendingMachineService service;
    private VendingMachineView view;

    public VendingMachineController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

//    private BigDecimal userMoneyInput;
    public void runMachine() throws VendingMachinePersistenceException, ItemDataValidationException {
        boolean keepRunning = true;

        //userMoneyInput = new BigDecimal("0"); // initilizes money in machine to 0
        int menuSelection;

        do {

            menuSelection = getMainMenuSelection();

            switch (menuSelection) {
                case 1:
                    purchaseItem();
                    break;
                case 2:
                    maintenanceMode();
                    break;
                case 3://exit Shut Down vending machine
                    keepRunning = false;
                    break;
                default:
                    unknownCommand();
            }

            //oprtion to make a purchase -- get string(itemName) -- get money input() -- get user if user selects  
            //option to maintain the machine. -- add or remove
            //option to exit -- goodbye 
        } while (keepRunning);
        shuttingDown();
    }

    private void maintenanceMode() throws VendingMachinePersistenceException, ItemDataValidationException {
        String password = view.getPassword();
        if (!password.equals("123randy")) {
            view.WrongPassord();
            return;
        }
        boolean keepRunning = true;

        do {
            int menuSelection = view.viewMaintenanceMenu();
            switch (menuSelection) {
                case 1:
                    addItemsToVending();
                    break;
                case 2:
                    removeItemFromVendingMachine();
                    break;
                case 3:
                    keepRunning = false;
                    break;
                default:
                    unknownCommand();
            }

        } while (keepRunning);
    }

    private void removeItemFromVendingMachine() throws VendingMachinePersistenceException {
        String itemName = view.getItemName();
        Item item;
        try {
            item = service.removeItem(itemName);
            if (item.getItemName().equals(itemName)) {
                view.successfullyRemoved(itemName);
            }
        } catch (NoItemInventoryException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addItemsToVending() throws VendingMachinePersistenceException, ItemDataValidationException {
        Item item = view.createItem();
        try {
            Item returnedItem = service.addItem(item);
            if (returnedItem != null && item.getItemName().equals(returnedItem.getItemName())) {
                view.successfullyAdded();
            }
        } catch (VendingMachinePersistenceException | ItemDataValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void purchaseItem() throws VendingMachinePersistenceException {
        boolean keepGoing = true;
        do {

            int numItems = displayAllItem(); // if the number of items in vending machie is 0 it 

            if (numItems == 0) {
                keepGoing = false;
                return;
            }

            BigDecimal money = view.getMoneyInput();

            List<Item> items = service.getItems();
            String itemName = view.getItemName();

            boolean hasErrors = false;
            Item dispensedItem = null;
            try {
                dispensedItem = service.getItem(itemName, money);
                view.enjoyYourSnacks();
            } catch (NoItemInventoryException | InsufficientFundsException e) { // if the item was not found or not enough money
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
            if (hasErrors == false) {
                money = money.subtract(dispensedItem.getPrice());
            }
            view.dispenseChange(money);
            if (!view.keepGoing()) {
                keepGoing = false;
            }

        } while (keepGoing);
        view.thankYouForShopping();
    }

    private int displayAllItem() throws VendingMachinePersistenceException {
        List<Item> items = service.getItems();
        view.viewAllItems(items);
        return items.size();
    }

    private int getMainMenuSelection() {
        return view.getMainMenuSelection();
    }

    private void unknownCommand() {
        view.unknownCommand();
    }

    private void shuttingDown() {
        view.shuttingDown();
    }
}
