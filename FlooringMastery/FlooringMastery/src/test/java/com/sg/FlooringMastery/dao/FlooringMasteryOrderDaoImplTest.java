/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryOrderDaoImplTest {

    private FlooringMasteryOrderDao orderDao;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

    public FlooringMasteryOrderDaoImplTest() {
    }

    @BeforeEach
    public void setUp() throws IOException, FlooringMasteryPersistenceException {
//        String testFile = "FileData/Testing/TestingOrders";
//        orderDao = new FlooringMasteryOrderDaoImpl(testFile);

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.orderDao = app.getBean("orderDao", FlooringMasteryOrderDaoImpl.class);
    }

    @Test
    public void testSize() throws FlooringMasteryPersistenceException {
        //arrange
        int size = 5;
        //act 
        int actualSize = orderDao.getAllOrders().size();
        //assert
        assertEquals(size, actualSize);
    }

    @Test
    public void testgetOrderDate1() throws FlooringMasteryPersistenceException {
        //arrange
        LocalDate ld = LocalDate.parse("06012013", formatter);
        Order o1 = new Order("1", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012013");
        //act
        List<Order> l1 = orderDao.getOrders(ld);
        int l1Size = 1;
        int l1ActualSize = l1.size();
        //assert
        assertEquals(l1Size, l1ActualSize);
        assertEquals(o1, l1.get(0));
    }

    @Test
    public void testgetOrderDate2() throws FlooringMasteryPersistenceException {
        //arrange
        LocalDate d2 = LocalDate.parse("06022013", formatter);
        Order o2 = new Order("2", "Doctor Who", "WA", "9.25", "Wood", "243", "5.15", "4.75");
        o2.setOrderDate("06022013");
        Order o3 = new Order("3", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o3.setOrderDate("06022013");
        //act
        List<Order> l2 = orderDao.getOrders(d2);
        int listSize = 2, actuallistSize = l2.size();
        //assert
        assertEquals(listSize, actuallistSize);
        for (int i = 0; i < l2.size(); i++) {
            Order tempOrder = l2.get(i);
            if (tempOrder.getOrderNumber() == o2.getOrderNumber()) {
                assertEquals(o2, tempOrder);
            } else if (tempOrder.getOrderNumber() == o3.getOrderNumber()) {
                assertEquals(o3, tempOrder);
            } else {
                fail("Unexpected Order items");
            }
        }
    }

    @Test
    public void testgetOrderDate3() throws FlooringMasteryPersistenceException {
        //arrange 
        LocalDate d3 = LocalDate.parse("06022014", formatter);
        Order o4 = new Order("4", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o4.setOrderDate("06022014");
        Order o5 = new Order("5", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o5.setOrderDate("06022014");
        //act
        List<Order> l3 = orderDao.getOrders(d3);
        int listSize = 2, actuallistSize = l3.size();
        //assert
        assertEquals(listSize, actuallistSize);
        for (int i = 0; i < l3.size(); i++) {
            Order tempOrder = l3.get(i);
            if (tempOrder.getOrderNumber() == o4.getOrderNumber()) {
                assertEquals(o4, tempOrder);
            } else if (tempOrder.getOrderNumber() == o5.getOrderNumber()) {
                assertEquals(o5, tempOrder);
            } else {
                 fail("Unexpected Order items");
            }
        }
    }

    @Test
    public void testgetOrderDate4() throws FlooringMasteryPersistenceException {
        //arrange
        LocalDate d4 = LocalDate.parse("06022015", formatter);
        Order o6 = new Order("6", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o6.setOrderDate("06022015");
        Order o7 = new Order("7", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o7.setOrderDate("06022015");
        Order o8 = new Order("8", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o8.setOrderDate("06022015");
        //act
        List<Order> l4 = orderDao.getOrders(d4);
        int listSize = 3, actuallistSize = l4.size();
        //assert
        assertEquals(listSize, actuallistSize);
        for (int i = 0; i < l4.size(); i++) {
            Order tempOrder = l4.get(i);
            if (tempOrder.getOrderNumber() == o6.getOrderNumber()) {
                assertEquals(o6, tempOrder);
            } else if (tempOrder.getOrderNumber() == o7.getOrderNumber()) {
                assertEquals(o7, tempOrder);
            } else if (tempOrder.getOrderNumber() == o8.getOrderNumber()) {
                assertEquals(o8, tempOrder);
            } else {
                 fail("Unexpected Order items");
            }
        }
    }

    @Test
    public void testgetOrderDate5() throws FlooringMasteryPersistenceException {
        //arrange
        LocalDate d5 = LocalDate.parse("06022016", formatter);
        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate("06022016");
        //act
        List<Order> l5 = orderDao.getOrders(d5);
        int listSize = 1, actuallistSize = l5.size();
        //assert
        assertEquals(listSize, actuallistSize);
        assertEquals(o9, l5.get(0));
    }

    @Test
    public void testAddOrder() throws FlooringMasteryPersistenceException, IOException {
        //arrange
        String date = "06062030";
        Order newOrder = new Order("10", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);
        //act
        orderDao.addOrder(newOrder);
        List<Order> l1 = orderDao.getOrders(d1);
        int size = 6;
        int actualSize = orderDao.getAllOrders().size();
        //assert
        assertEquals(1, l1.size());
        assertEquals(newOrder, l1.get(0));
        assertEquals(size, actualSize);

        String path = "FileData/Testing/TestingOrders/Orders_" + date + ".txt";
        File myObj = new File(path);
        myObj.delete();
    }

    @Test
    public void testeditOrder() throws FlooringMasteryPersistenceException, IOException {
        //arrange
        String date = "06062030";
        Order newOrder1 = new Order("10", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder1.setOrderDate(date);
        Order newOrder2 = new Order("10", "This is changed", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder2.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);
        //act
        orderDao.addOrder(newOrder1);
        orderDao.editOrder(newOrder2);
        List<Order> l1 = orderDao.getOrders(d1);
        int size = 6;
        int actualSize = orderDao.getAllOrders().size();
        //assert
        assertEquals(1, l1.size());
        assertEquals(newOrder2, l1.get(0));
        assertEquals(size, actualSize);
        String path = "FileData/Testing/TestingOrders/Orders_" + date + ".txt";
        File myObj = new File(path);
        myObj.delete();
    }

    @Test
    public void testRemoveOrder() throws FlooringMasteryPersistenceException {
        //arrange
        String date = "06062030";
        Order newOrder = new Order("10", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);
        //act
        orderDao.addOrder(newOrder);
        orderDao.removeOrder(d1, 10);
        List<Order> l1 = orderDao.getOrders(d1);
        int size = 5;
        int actualSize = orderDao.getAllOrders().size();
        //assert
        assertEquals(null, l1);
        assertEquals(size, actualSize);
    }

    @Test
    public void testGetAllOrders() throws FlooringMasteryPersistenceException {
        //arrange 
        LocalDate d1 = LocalDate.parse("06012013", formatter);
        Order o1 = new Order("1", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012013");
        LocalDate d2 = LocalDate.parse("06022013", formatter);
        Order o2 = new Order("2", "Doctor Who", "WA", "9.25", "Wood", "243", "5.15", "4.75");
        o2.setOrderDate("06022013");
        Order o3 = new Order("3", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o3.setOrderDate("06022013");
        LocalDate d3 = LocalDate.parse("06022014", formatter);
        Order o4 = new Order("4", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o4.setOrderDate("06022014");
        Order o5 = new Order("5", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o5.setOrderDate("06022014");
        LocalDate d4 = LocalDate.parse("06022015", formatter);
        Order o6 = new Order("6", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o6.setOrderDate("06022015");
        Order o7 = new Order("7", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o7.setOrderDate("06022015");
        Order o8 = new Order("8", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o8.setOrderDate("06022015");
        LocalDate d5 = LocalDate.parse("06022016", formatter);
        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate("06022016");
        //act
        Map<LocalDate, Map<Integer, Order>> orders = orderDao.getAllOrders();
        List<Order> l1 = new ArrayList(orders.get(d1).values());
        List<Order> l2 = new ArrayList(orders.get(d2).values());
        List<Order> l3 = new ArrayList(orders.get(d3).values());
        List<Order> l4 = new ArrayList(orders.get(d4).values());
        List<Order> l5 = new ArrayList(orders.get(d5).values());
        int orderSize = 5, actualorderSize = orders.size();
        int l1size = 1, actuall1size = l1.size();
        int l2size = 2, actuall2size = l2.size();
        int l3size = 2, actuall3size = l3.size();
        int l4size = 3, actuall4size = l4.size();
        int l5size = 1, actuall5size = l5.size();

        //assert
        assertEquals(orderSize, actualorderSize);
        assertEquals(l1size, actuall1size);
        assertEquals(l2size, actuall2size);
        assertEquals(l3size, actuall3size);
        assertEquals(l4size, actuall4size);
        assertEquals(l5size, actuall5size);

        assertEquals(o1, l1.get(0));
        for (int i = 0; i < l2.size(); i++) {
            Order tempOrder = l2.get(i);
            if (tempOrder.getOrderNumber() == o2.getOrderNumber()) {
                assertEquals(o2, tempOrder);
            } else if (tempOrder.getOrderNumber() == o3.getOrderNumber()) {
                assertEquals(o3, tempOrder);
            } else {
                fail("Unexpected Order items");
            }
        }

        for (int i = 0; i < l3.size(); i++) {
            Order tempOrder = l3.get(i);
            if (tempOrder.getOrderNumber() == o4.getOrderNumber()) {
                assertEquals(o4, tempOrder);
            } else if (tempOrder.getOrderNumber() == o5.getOrderNumber()) {
                assertEquals(o5, tempOrder);
            } else {
                fail("Unexpected Order items");
            }
        }

        for (int i = 0; i < l4.size(); i++) {
            Order tempOrder = l4.get(i);
            if (tempOrder.getOrderNumber() == o6.getOrderNumber()) {
                assertEquals(o6, tempOrder);
            } else if (tempOrder.getOrderNumber() == o7.getOrderNumber()) {
                assertEquals(o7, tempOrder);
            } else if (tempOrder.getOrderNumber() == o8.getOrderNumber()) {
                assertEquals(o8, tempOrder);
            } else {
                fail("Unexpected Order items");
            }
        }
        assertEquals(o9, l5.get(0));
    }
}
