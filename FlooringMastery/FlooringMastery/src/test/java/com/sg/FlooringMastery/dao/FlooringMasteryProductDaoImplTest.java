/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Product;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryProductDaoImplTest {

    private FlooringMasteryProductDao productDao;

    public FlooringMasteryProductDaoImplTest() {
    }

    @BeforeEach
    public void setUp() throws IOException {
//        String testFile = "FileData/Testing/ProductsTest.txt";
//        productDao = new FlooringMasteryProductDaoImpl(testFile);

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.productDao = app.getBean("productDao", FlooringMasteryProductDaoImpl.class);
    }

    @Test
    public void testSize() throws FlooringMasteryPersistenceException {
        //arrange 
        int size = 4;
        //act
        int actualSize = productDao.getProducts().size();
        //assert
        assertEquals(size, actualSize);
    }

    @Test
    public void testGetProduct() throws FlooringMasteryPersistenceException {
        //arrange
        Product carpet = new Product("Carpet", "2.25", "2.10");
        Product laminate = new Product("Laminate", "1.75", "2.10");
        Product tile = new Product("Tile", "3.50", "4.15");
        Product wood = new Product("Wood", "5.15", "4.75");
        //act
        Product testLaminate = productDao.getProduct("Laminate");
        Product testCarpet = productDao.getProduct("Carpet");
        Product testTile = productDao.getProduct("Tile");
        Product testWood = productDao.getProduct("Wood");
        //assert
        assertEquals(carpet, testCarpet);
        assertEquals(laminate, testLaminate);
        assertEquals(tile, testTile);
        assertEquals(wood, testWood);
    }

    @Test
    public void getProducts() throws FlooringMasteryPersistenceException {
        //arrange
        Product carpet = new Product("Carpet", "2.25", "2.10");
        Product laminate = new Product("Laminate", "1.75", "2.10");
        Product tile = new Product("Tile", "3.50", "4.15");
        Product wood = new Product("Wood", "5.15", "4.75");
        //act
        List<Product> products = productDao.getProducts();
        //assert
        assertEquals(4, products.size());
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
                fail();
            }
        }
    }
}
