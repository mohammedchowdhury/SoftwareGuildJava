/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryOrderDao;
import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryOrderDaoImplStubClass implements FlooringMasteryOrderDao {

    private Map<LocalDate, Map<Integer, Order>> orders = new HashMap<LocalDate, Map<Integer, Order>>();

    FlooringMasteryOrderDaoImplStubClass() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        Map<Integer, Order> listOfOrders1 = new HashMap<Integer, Order>();
        LocalDate d1 = LocalDate.parse("06012013", formatter);
        Order o1 = new Order("1", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012013");
        listOfOrders1.put(o1.getOrderNumber(), o1);
        orders.put(d1, listOfOrders1);

        Map<Integer, Order> listOfOrders2 = new HashMap<Integer, Order>();
        LocalDate d2 = LocalDate.parse("06022013", formatter);
        Order o2 = new Order("2", "Doctor Who", "WA", "9.25", "Wood", "243", "5.15", "4.75");
        o2.setOrderDate("06022013");
        Order o3 = new Order("3", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o3.setOrderDate("06022013");
        listOfOrders2.put(o2.getOrderNumber(), o2);
        listOfOrders2.put(o3.getOrderNumber(), o3);
        orders.put(d2, listOfOrders2);

        //
        //
        Map<Integer, Order> listOfOrders3 = new HashMap<Integer, Order>();
        LocalDate d3 = LocalDate.parse("06022014", formatter);
        Order o4 = new Order("4", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o4.setOrderDate("06022014");
        Order o5 = new Order("5", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o5.setOrderDate("06022014");
        listOfOrders3.put(o4.getOrderNumber(), o4);
        listOfOrders3.put(o5.getOrderNumber(), o5);
        orders.put(d3, listOfOrders3);

        Map<Integer, Order> listOfOrders4 = new HashMap<Integer, Order>();
        LocalDate d4 = LocalDate.parse("06022015", formatter);
        Order o6 = new Order("6", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o6.setOrderDate("06022015");
        Order o7 = new Order("7", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o7.setOrderDate("06022015");
        Order o8 = new Order("8", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o8.setOrderDate("06022015");
        listOfOrders4.put(o6.getOrderNumber(), o6);
        listOfOrders4.put(o7.getOrderNumber(), o7);
        listOfOrders4.put(o8.getOrderNumber(), o8);
        orders.put(d4, listOfOrders4);

        Map<Integer, Order> listOfOrders5 = new HashMap<Integer, Order>();
        LocalDate d5 = LocalDate.parse("06022016", formatter);
        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate("06022016");
        listOfOrders5.put(o9.getOrderNumber(), o9);
        orders.put(d5, listOfOrders5);
    }

    @Override
    public List<Order> getOrders(LocalDate date) {
        if (orders.containsKey(date)) {
            return new ArrayList(orders.get(date).values());
        }
        return null;
    }

    @Override
    public Order addOrder(Order newOrder) throws FlooringMasteryPersistenceException {
        Order returnOrder = null;
        if (orders.containsKey(newOrder.getOrderDate())) {
            orders.get(newOrder.getOrderDate()).put(newOrder.getOrderNumber(), newOrder);
        } else {
            Map<Integer, Order> tempOrder = new HashMap<Integer, Order>();
            tempOrder.put(newOrder.getOrderNumber(), newOrder);
            orders.put(newOrder.getOrderDate(), tempOrder);
        }
        returnOrder = this.orders.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        return returnOrder;
    }

    @Override
    public Order editOrder(Order newOrder) throws FlooringMasteryPersistenceException {
       Order returnOrder = null;
        if (orders.containsKey(newOrder.getOrderDate())) {
            orders.get(newOrder.getOrderDate()).put(newOrder.getOrderNumber(), newOrder);
        } else {
            Map<Integer, Order> tempOrder = new HashMap<Integer, Order>();
            tempOrder.put(newOrder.getOrderNumber(), newOrder);
            orders.put(newOrder.getOrderDate(), tempOrder);
        }
        returnOrder = this.orders.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        return returnOrder;
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringMasteryPersistenceException {
        Map<Integer, Order> dayOrder = orders.get(date);
        if (dayOrder == null || dayOrder.size() == 0) {
            return null;
        }
        Order order = dayOrder.get(orderNumber);

        if (order != null) {
            if (dayOrder.size() == 1) {
                orders.remove(date);
                //remove the empty file
            } else {
                dayOrder.remove(orderNumber);
            }
        }
        return order;
    }

    @Override
    public Map<LocalDate, Map<Integer, Order>> getAllOrders() throws FlooringMasteryPersistenceException {
        return orders;
    }

    @Override
    public void setUp() throws FlooringMasteryPersistenceException {
        //do Nothing
    }

}
