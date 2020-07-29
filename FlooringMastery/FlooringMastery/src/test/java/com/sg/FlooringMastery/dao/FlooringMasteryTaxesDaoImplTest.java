/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Tax;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryTaxesDaoImplTest {

    private FlooringMasteryTaxesDao taxDao;

    public FlooringMasteryTaxesDaoImplTest() {
    }

    @BeforeEach
    public void setUp() throws IOException {
//        String testFile = "FileData/Testing/TaxesTest.txt";
//        // new FileWriter(testFile);  
//        taxDao = new FlooringMasteryTaxesDaoImpl(testFile);

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.taxDao = app.getBean("taxDao", FlooringMasteryTaxesDaoImpl.class);
    }

    @Test
    public void testSize() throws FlooringMasteryPersistenceException {
        int size = 4;
        int actualSize = taxDao.getTaxes().size();
        assertEquals(size, actualSize);
    }

    @Test
    public void getTax() throws FlooringMasteryPersistenceException {
        //arrange
        Tax tx = new Tax("TX", "4.45");
        Tax wa = new Tax("WA", "9.25");
        Tax ky = new Tax("KY","6.00");
        Tax ca = new Tax("CA", "25.00");

        //act
        Tax testTX = taxDao.getTax("TX");
        Tax testWA = taxDao.getTax("WA");
        Tax testKY = taxDao.getTax("KY");
        Tax testCA = taxDao.getTax("CA");
        //assert
        assertEquals(tx, testTX);
        assertEquals(wa, testWA);
        assertEquals(ky, testKY);
        assertEquals(ca, testCA);
    }

    @Test
    public void getTaxes() throws FlooringMasteryPersistenceException {
        //arrange
        Tax tx = new Tax("TX", "4.45");
        Tax wa = new Tax("WA", "9.25");
        Tax ky = new Tax("KY", "6.00");
        Tax ca = new Tax("CA", "25.00");
        //act
        List<Tax> taxes = taxDao.getTaxes();
        //assert
        assertEquals(4, taxes.size());
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
                fail("Unexpected Tax item");
            }
        }
    }
}
