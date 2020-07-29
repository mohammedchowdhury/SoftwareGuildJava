package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import com.sg.FlooringMastery.dto.Tax;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryServiceImplTest {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
    private FlooringMasteryService service;

    public FlooringMasteryServiceImplTest() {

//        FlooringMasteryOrderDao orderDao = new FlooringMasteryOrderDaoImplStubClass();
//        FlooringMasteryProductDao productDao = new FlooringMasteryProductDaoImplStubClass();
//        FlooringMasteryTaxesDao taxDao = new FlooringMasteryTaxesDaoImplStubClass();
//        FlooringMasteryExportDao exportDao = new FlooringMasteryExportDaoImplStubClass();
//        FlooringMasteryAuditDaoFile auditDao = new FlooringMasteryAuditDaoFileImplStubClass();
//        service = new FlooringMasteryServiceImpl(orderDao, productDao, taxDao, exportDao, auditDao);
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.service = app.getBean("serviceLayer", FlooringMasteryServiceImpl.class);

    }

    /**
     * This is testing all the Orders using getOrder()
     *
     * @throws NoOrderException
     * @throws FlooringMasteryPersistenceException
     */
    @Test
    public void testgetOrders() throws NoOrderException, FlooringMasteryPersistenceException {
        //arrange 
        Order o1 = new Order("1", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012013");
        Order o2 = new Order("2", "Doctor Who", "WA", "9.25", "Wood", "243", "5.15", "4.75");
        o2.setOrderDate("06022013");
        Order o3 = new Order("3", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o3.setOrderDate("06022013");
        Order o4 = new Order("4", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o4.setOrderDate("06022014");
        Order o5 = new Order("5", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o5.setOrderDate("06022014");
        Order o6 = new Order("6", "Doctor Who", "WA", "9.25", "Wood", "243.00", "5.15", "4.75");
        o6.setOrderDate("06022015");
        Order o7 = new Order("7", "Albert Einstein", "KY", "6.00", "Carpet", "217.00", "2.25", "2.10");
        o7.setOrderDate("06022015");
        Order o8 = new Order("8", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o8.setOrderDate("06022015");
        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate("06022016");

        LocalDate d1 = LocalDate.parse("06012013", formatter);
        LocalDate d2 = LocalDate.parse("06022013", formatter);
        LocalDate d3 = LocalDate.parse("06022014", formatter);
        LocalDate d4 = LocalDate.parse("06022015", formatter);
        LocalDate d5 = LocalDate.parse("06022016", formatter);

        //act 
        List<Order> l1 = service.getOrders(d1);
        List<Order> l2 = service.getOrders(d2);
        List<Order> l3 = service.getOrders(d3);
        List<Order> l4 = service.getOrders(d4);
        List<Order> l5 = service.getOrders(d5);

        int l1size = 1, l1sizeActual = l1.size();
        int l2size = 2, l2sizeActual = l2.size();
        int l3size = 2, l3sizeActual = l3.size();
        int l4size = 3, l4sizeActual = l4.size();
        int l5size = 1, l5sizeActual = l5.size();

        //assert
        assertEquals(l1size, l1sizeActual);
        assertEquals(l2size, l2sizeActual);
        assertEquals(l3size, l3sizeActual);
        assertEquals(l4size, l4sizeActual);
        assertEquals(l5size, l5sizeActual);

        assertEquals(o1, l1.get(0));
        for (int i = 0; i < l2.size(); i++) {
            Order tempOrder = l2.get(i);
            if (tempOrder.getOrderNumber() == o2.getOrderNumber()) {
                assertEquals(o2, tempOrder);
            } else if (tempOrder.getOrderNumber() == o3.getOrderNumber()) {
                assertEquals(o3, tempOrder);
            } else {
                fail("Unexpected Order");
            }
        }
        for (int i = 0; i < l3.size(); i++) {
            Order tempOrder = l3.get(i);
            if (tempOrder.getOrderNumber() == o4.getOrderNumber()) {
                assertEquals(o4, tempOrder);
            } else if (tempOrder.getOrderNumber() == o5.getOrderNumber()) {
                assertEquals(o5, tempOrder);
            } else {
                fail("Unexpected Order");
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
                fail("Unexpected Order");
            }
        }

        assertEquals(o9, l5.get(0));
    }

    @Test
    public void testgetOrdersTestException() throws FlooringMasteryPersistenceException {
        //arrange 
        LocalDate d5 = LocalDate.parse("10102016", formatter);
        //act//assert
        try {
            List<Order> l5 = service.getOrders(d5);
            fail("Expected NoOrderException");
        } catch (NoOrderException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testgetTaxes() throws FlooringMasteryPersistenceException, NoTaxesFoundException {
        //arrange
        Tax tx = new Tax("TX", "4.45");
        Tax wa = new Tax("WA", "9.25");
        Tax ky = new Tax("KY", "6.00");
        Tax ca = new Tax("CA", "25.00");
        //act
        List<Tax> taxes = service.getTaxes();
        int size = 4, actualSize = taxes.size();
        //assert
        assertEquals(size, actualSize);
        for (int i = 0; i < taxes.size(); i++) {
            Tax tempTax = taxes.get(i);
            if (tx.getState().equals(tempTax.getState())) {
                assertEquals(tx, tempTax);
            } else if (wa.getState().equals(tempTax.getState())) {
                assertEquals(wa, tempTax);
            } else if (ky.getState().equals(tempTax.getState())) {
                assertEquals(ky, tempTax);
            } else if (ca.getState().equals(tempTax.getState())) {
                assertEquals(ca, tempTax);
            } else {
                fail("UnExpected Tax Item");
            }
        }

    }

    @Test
    public void testgetProducts() throws FlooringMasteryPersistenceException, NoProductsFoundException {
        //arrange
        Product carpet = new Product("Carpet", "2.25", "2.10");
        Product laminate = new Product("Laminate", "1.75", "2.10");
        Product tile = new Product("Tile", "3.50", "4.15");
        Product wood = new Product("Wood", "5.15", "4.75");
        //act
        List<Product> products = service.getProducts();
        int size = 4, actualSize = products.size();
        //assert
        assertEquals(size, actualSize);
        for (int i = 0; i < products.size(); i++) {
            Product tempProduct = products.get(i);
            if (carpet.getProductType().equals(tempProduct.getProductType())) {
                assertEquals(carpet, tempProduct);
            } else if (laminate.getProductType().equals(tempProduct.getProductType())) {
                assertEquals(laminate, tempProduct);
            } else if (tile.getProductType().equals(tempProduct.getProductType())) {
                assertEquals(tile, tempProduct);
            } else if (wood.getProductType().equals(tempProduct.getProductType())) {
                assertEquals(wood, tempProduct);
            } else {
                fail("Unexpected Product Item");
            }
        }
    }

    @Test
    public void testeditOrder() throws FlooringMasteryPersistenceException, InvalidOrderException, NoOrderException {
        //arrange
        String date = "06022016";
        Order newOrder = new Order("9", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder.setOrderDate(date);

        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);
        //act
        List<Order> l1 = service.getOrders(d1);
        Order o1 = l1.get(0);
        int l1size = 1, actuall1Size = l1.size();
        service.editOrder(newOrder);
        l1 = service.getOrders(d1);
        Order o2 = l1.get(0);

        //assert
        assertEquals(l1size, actuall1Size);
        assertEquals(newOrder, o2);
        assertEquals(o9, o1);
    }

    @Test
    public void testaddOrder() throws FlooringMasteryPersistenceException, InvalidOrderException, NoOrderException {
        //arrange
        String date = "06062030";
        Order newOrder = new Order("10", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        newOrder.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);

        //act
        service.addOrder(newOrder);
        List<Order> l1 = service.getOrders(d1);
        int l1size = 1, actuall1Size = l1.size();
        //assert
        assertEquals(l1size, actuall1Size);
        assertEquals(newOrder, l1.get(0));
    }

    @Test
    public void testaddOrderInvaildOrder() throws FlooringMasteryPersistenceException, InvalidOrderException, NoOrderException {
        //arrange
        String date = "06062030";
        Order newOrder = new Order("10", "This is a Test", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        //act
        //assert
        try {
            service.addOrder(newOrder);
            fail("Expected InvalidOrderException");
        } catch (InvalidOrderException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testgetOrder() throws NoOrderException, FlooringMasteryPersistenceException {
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
        Order actualo1 = service.getOrder(d1, 1);
        Order actualo2 = service.getOrder(d2, 2);
        Order actualo3 = service.getOrder(d2, 3);
        Order actualo4 = service.getOrder(d3, 4);
        Order actualo5 = service.getOrder(d3, 5);
        Order actualo6 = service.getOrder(d4, 6);
        Order actualo7 = service.getOrder(d4, 7);
        Order actualo8 = service.getOrder(d4, 8);
        Order actualo9 = service.getOrder(d5, 9);

        //assert
        assertEquals(o1, actualo1);
        assertEquals(o2, actualo2);
        assertEquals(o3, actualo3);
        assertEquals(o4, actualo4);
        assertEquals(o5, actualo5);
        assertEquals(o6, actualo6);
        assertEquals(o7, actualo7);
        assertEquals(o8, actualo8);
        assertEquals(o9, actualo9);
    }

    @Test
    public void testgetOrderNoOrderException() throws FlooringMasteryPersistenceException {
        //arrange 
        LocalDate d1 = LocalDate.parse("06012050", formatter);
        Order o1 = new Order("1", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012050");
        LocalDate d2 = LocalDate.parse("06012013", formatter);
        Order o2 = new Order("4", "Ada Lovelace", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o1.setOrderDate("06012013");
        //act//assert
        try {
            assertEquals(o1, service.getOrder(d1, 1));
            fail();
        } catch (NoOrderException e) {
            assertTrue(true);
        }
        try {
            assertEquals(o2, service.getOrder(d2, 4));
            fail("Expected NoOrderException");
        } catch (NoOrderException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testremoveOrder() throws NoOrderException, FlooringMasteryPersistenceException {
        //arrange
        String date = "06022016";
        Order o9 = new Order("9", "Ada Shoe", "CA", "25.00", "Tile", "249.00", "3.50", "4.15");
        o9.setOrderDate(date);
        LocalDate d1 = LocalDate.parse(date, formatter);

        //act
        Order order = service.removeOrder(d1, 9);
        //assert
        assertEquals(order, o9);
        try {
            List<Order> l1 = service.getOrders(d1);
            fail("Expected NoOrderException");
        } catch (NoOrderException e) {
            assertTrue(true);
        }
    }
}