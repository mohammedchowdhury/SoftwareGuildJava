package com.sg.FlooringMastery.controller;

import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import com.sg.FlooringMastery.dto.Tax;
import com.sg.FlooringMastery.service.FlooringMasteryService;
import com.sg.FlooringMastery.service.InvalidOrderException;
import com.sg.FlooringMastery.service.NoOrderException;
import com.sg.FlooringMastery.service.NoProductsFoundException;
import com.sg.FlooringMastery.service.NoTaxesFoundException;
import com.sg.FlooringMastery.ui.FlooringMasteryView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlooringMasteryController {

    private FlooringMasteryView view;
    private FlooringMasteryService service;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = printMenu();
            switch (selection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addAnOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeAnOrder();
                    break;
                case 5:
                    exportData();
                    break;
                case 6:
                    keepRunning = false;
                    break;
                default:
                    keepRunning = false;
                    break;
            }
        }
        exitMessage();
    }

    private int printMenu() {
        return view.printMainMenu();
    }

    private void exitMessage() {
        view.goodbyeMessage();
    }

    //selection 1
    private void displayOrders() {
        LocalDate ld = view.getDate();
        try {
            List<Order> orders = service.getOrders(ld);
            view.displayOrders(orders);
        } catch (NoOrderException e) {
            view.printErrorNoOrders(ld.format(this.formatter));
            return;
        } catch (FlooringMasteryPersistenceException e) {
            view.printErrorFileCannotBeRead();
            return;
        }
    }

    //selection2
    public void addAnOrder() {
        try {
            service.setUp();
            LocalDate futureDate = view.getFutureDate();
            String name = view.getName();

            List<Tax> statesAndTaxes = service.getTaxes();
            Tax taxPicked = view.pickTax(statesAndTaxes);

            List<Product> products = service.getProducts();
            Product productPicked = view.pickProduct(products);

            BigDecimal area = view.getArea();
            String stArea = area.toString();

            Order tempOrder = new Order(name, taxPicked, stArea, productPicked);
            //Order tempOrder = new Order(name, taxPicked.getState(), taxPicked.getTaxRate().toString(), productPicked.getProductType(), stArea, productPicked.getCostPerSquareFoot().toString(), productPicked.getLaborCostPerSquareFoot().toString());
            tempOrder.setOrderDate(futureDate.format(this.formatter));
            int orderNumber = tempOrder.getOrderNumber();
            boolean ans = view.keepOrder(tempOrder,"Place");
            if (ans == false) {
                orderNumber--;
                tempOrder.setOrderCounter(orderNumber);
                return;
            }
            tempOrder = service.addOrder(tempOrder);
            view.OrderSuccessfullyMessage(tempOrder, "Successfully added");

        } catch (FlooringMasteryPersistenceException e) {
            view.printErrorFileCannotBeRead();
            return;
        } catch (NoTaxesFoundException e) {
            view.printErrorNoTax();
            return;
        } catch (NoProductsFoundException e) {
            view.printErrorNoProducts();
            return;
        } catch (InvalidOrderException e) {
            view.printInvalidDataa();
            return;
        }
    }

    //selection 3
    public void editOrder() {
        try {
            service.setUp();
            LocalDate date = view.getDate();
            int orderNumber = view.getOrderNumber();
            Order order = service.getOrder(date, orderNumber);
            List<Product> products = service.getProducts();

            order = view.editOrder(order, products, service.getTaxes());
            if (order == null) {
                return;
            }

            boolean ans = view.keepOrder(order,"Edit");
            if (ans == false) {
                return;
            }
            order = service.editOrder(order);
            view.OrderSuccessfullyMessage(order, "Successfully edited");

        } catch (NoOrderException e) {
            view.printErrorNoOrders(" OrderNumber or Date");
            return;
        } catch (NoProductsFoundException e) {
            view.printErrorNoProducts();
            return;
        } catch (NoTaxesFoundException e) {
            view.printErrorNoTax();
            return;
        } catch (FlooringMasteryPersistenceException e) {
            view.printErrorFileCannotBeRead();
            return;
        } catch (InvalidOrderException e) {
            view.printInvalidDataa();
            return;
        }

    }

    //selection 4
    public void removeAnOrder() {
        LocalDate date = view.getDate();
        int orderNumber = view.getOrderNumber();
        try {
            Order order = service.getOrder(date, orderNumber);
            
            boolean ans = view.keepOrder(order,"Remove");
            if (ans == false) {
                return;
            }
             order = service.removeOrder(date, orderNumber);

            view.OrderSuccessfullyMessage(order, "Successfully Removed");
        } catch (NoOrderException e) {
            view.printErrorNoOrders(date + " Order Number:" + orderNumber);
            return;
        } catch (FlooringMasteryPersistenceException e) {
            view.printErrorFileCannotBeRead();
            return;
        }
    }

    public void exportData() {
        try {
            int size = service.exportData();
            view.numberItemsExported(size, "Orders exported");
        } catch (NoOrderException e) {
            view.printErrorNoOrders("No Data Exists");
            return;
        } catch (FlooringMasteryPersistenceException e) {
            view.printErrorFileCannotBeRead();
            return;
        }
    }
}
