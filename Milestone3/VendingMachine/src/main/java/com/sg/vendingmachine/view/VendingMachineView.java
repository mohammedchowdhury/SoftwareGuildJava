package com.sg.vendingmachine.view;

import com.sg.vendingmachine.dto.Coins;
import com.sg.vendingmachine.dto.DispenseChange;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineView {

    private UserIO io; // gets instanciated when the constructor is called

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public String getPassword() {
        return io.readString("Enter Machine Password").trim().toLowerCase();
    }

    public void WrongPassord() {
        io.print("Invalid password!!");
    }

    public int viewMaintenanceMenu() { //// continue form maintainance
        io.print("1. Add item"); //adds one item at a time 
        io.print("2. Remove item"); // removes an item from machine 
        io.print("3. Exit"); // exits maintenance
        return io.readInt("Please enter a selection from above", 1, 3);
    }

    // remove 
    public String getItemName() {
        return io.readString("Please enter Item name:").trim();
    }
    public void successfullyRemoved(String itemName){
        io.print(itemName+ ": Successfully removed from Vending machine");
    }
    
    

    //create 
    public Item createItem() {
        String itemName = io.readString("Please enter Item name ");
        itemName = itemName.trim();
        String money = getMoney().toString();
        String quantity = (io.readInt("Enter the quantity : ", 1, 100)) + "";
        Item newItem = new Item(itemName, money, quantity);
        return newItem;
    }

    public void successfullyAdded() {
        io.print("Successfully added Item ... .. .");
    }

    public BigDecimal getMoney() {
        BigDecimal money = null;
        boolean keepGoing = true;
        do {
            String stMoney = io.readString("Please enter the cost of item.");
            try {
                money = new BigDecimal(stMoney);
                money = money.setScale(2, RoundingMode.HALF_EVEN);
                if (money.compareTo(new BigDecimal("0")) > 0) {//make sure money is positive                
                    keepGoing = false;
                } else {
                    io.print("Invalid money input");
                }
            } catch (Exception e) {
                io.print("Invalid input");
            }
        } while (keepGoing);
        return money;
    }

    /// Used for purchase 
    public void viewAllItems(List<Item> items) {
        if (items.size() == 0) {
            io.print("Vending Machine is Empty");
        }
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            io.print((i + 1) + ". " + item.getItemName() + " : $" + item.getPriceString());
        }
    }

    public int getMainMenuSelection() {
        io.print("\n");
        io.print("1 : Purchase an item");// used to make purchase
        io.print("2 : Maintain Vending Machine"); // add and remove item
        io.print("3 : Shut Down Machine / Exit"); // End program
        return io.readInt("Please select from the above choices.", 1, 3);
    }

    public BigDecimal getMoneyInput() {
        io.print("___________________________________\n"
                + "|#######====================#######|\n"
                + "|#(1)*UNITED STATES OF AMERICA*(1)#|\n"
                + "|#**          /===\\   ********  **#|\n"
                + "|*# {G}      | (\") |             #*|\n"
                + "|#*  ******  | /v\\ |    O N E    *#|\n"
                + "|#(1)         \\===/            (1)#|\n"
                + "|##=========ONE DOLLAR===========##|\n"
                + "------------------------------------");
        BigDecimal money = null;
        boolean keepGoing = true;
        do {
            String stMoney = io.readString("Please insert your money.");
            try {
                money = new BigDecimal(stMoney);
                money = money.setScale(2, RoundingMode.HALF_EVEN);
                if (money.compareTo(new BigDecimal("0")) > 0) {//make sure money is positive                
                    keepGoing = false;
                } else {
                    io.print("Invalid money input");
                }
            } catch (Exception e) {
                io.print("Invalid input");
            }
        } while (keepGoing);
        return money;
    }

    public void dispenseChange(BigDecimal money) {

        Coins[] arr = DispenseChange.dispenseChange(money);

        BigDecimal temp = new BigDecimal("0");

        if ((arr[0].QUARTER.getnumOfCoinInt() + arr[2].NICKLE.getnumOfCoinInt() + arr[1].DIME.getnumOfCoinInt() + arr[3].PENNY.getnumOfCoinInt()) > 0) {
            io.print("Dispensing coins . . . ");
        }

        if (arr[0].QUARTER.getnumOfCoin().compareTo(temp) > 0) {
            System.out.println(arr[0].QUARTER + " : " + arr[0].QUARTER.getnumOfCoin());
        }
        if (arr[1].DIME.getnumOfCoin().compareTo(temp) > 0) {
            System.out.println(arr[1].DIME + " : " + arr[1].DIME.getnumOfCoin());
        }

        if (arr[2].NICKLE.getnumOfCoin().compareTo(temp) > 0) {
            System.out.println(arr[2].NICKLE + " : " + arr[2].NICKLE.getnumOfCoin());
        }
        if (arr[3].PENNY.getnumOfCoin().compareTo(temp) > 0) {
            System.out.println(arr[3].PENNY + " : " + arr[3].PENNY.getnumOfCoin());
        }

//        BigDecimal x = money;
//        BigDecimal[] ans = x.divideAndRemainder(Coins.QUARTER.getValue());
//        Coins.QUARTER.setnumOfCoin(ans[0]);   //Holds the number of Quarter     
//
//        x = ans[1];
//        ans = x.divideAndRemainder(Coins.DIME.getValue());
//        Coins.DIME.setnumOfCoin(ans[0]);
//
//        x = ans[1];
//        ans = x.divideAndRemainder(Coins.NICKLE.getValue());
//        Coins.NICKLE.setnumOfCoin(ans[0]);
//
//        x = ans[1];
//        ans = x.divideAndRemainder(Coins.PENNY.getValue());
//        Coins.PENNY.setnumOfCoin(ans[0]);
//        BigDecimal temp = new BigDecimal("0");
//        if ((Coins.QUARTER.getnumOfCoinInt() + Coins.NICKLE.getnumOfCoinInt() + Coins.DIME.getnumOfCoinInt() + Coins.PENNY.getnumOfCoinInt()) > 0) {
//            io.print("Dispensing coins . . . ");
//        }
//
//        if (Coins.QUARTER.getnumOfCoin().compareTo(temp) > 0) {
//            System.out.println(Coins.QUARTER + " : " + Coins.QUARTER.getnumOfCoin());
//        }
//        if (Coins.DIME.getnumOfCoin().compareTo(temp) > 0) {
//            System.out.println(Coins.DIME + " : " + Coins.DIME.getnumOfCoin());
//        }
//
//        if (Coins.NICKLE.getnumOfCoin().compareTo(temp) > 0) {
//            System.out.println(Coins.NICKLE + " : " + Coins.NICKLE.getnumOfCoin());
//        }
//        if (Coins.PENNY.getnumOfCoin().compareTo(temp) > 0) {
//            System.out.println(Coins.PENNY + " : " + Coins.PENNY.getnumOfCoin());
//        }
    }

    public void enjoyYourSnacks() {

        String a = "  ______       _                                         _____                  _    \n"
                + " |  ____|     (_)                                       / ____|                | |   \n"
                + " | |__   _ __  _  ___  _   _   _   _  ___  _   _ _ __  | (___  _ __   __ _  ___| | __\n"
                + " |  __| | '_ \\| |/ _ \\| | | | | | | |/ _ \\| | | | '__|  \\___ \\| '_ \\ / _` |/ __| |/ /\n"
                + " | |____| | | | | (_) | |_| | | |_| | (_) | |_| | |     ____) | | | | (_| | (__|   < \n"
                + " |______|_| |_| |\\___/ \\__, |  \\__, |\\___/ \\__,_|_|    |_____/|_| |_|\\__,_|\\___|_|\\_\\\n"
                + "             _/ |       __/ |   __/ |                                                \n"
                + "            |__/       |___/   |___/                                                 ";

        System.out.println(a);

    }

    public boolean keepGoing() {
        String input = io.readString("Purchase another Item? 1. Y(yes) 2. N(no)");
        input = input.toLowerCase();
        if (input.equals("yes") || input.equals("y") || input.equals("1") || input.equals("y(yes)")) {
            return true;
        }
        return false;
    }

    public void thankYouForShopping() {
        io.print("Thank you for shopping with us ... .. . ");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void unknownCommand() {
        io.print("Unknown Commands");
    }

    public void shuttingDown() {
        io.print("Shutting Down . . . ");
    }
}
