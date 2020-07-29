package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dao.FlooringMasteryProductDao;
import com.sg.FlooringMastery.dto.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryProductDaoImplStubClass implements FlooringMasteryProductDao {

    private Map<String, Product> products = new HashMap<String, Product>();

    public FlooringMasteryProductDaoImplStubClass() {
        Product p1 = new Product("Carpet", "2.25", "2.10");
        Product p2 = new Product("Laminate", "1.75", "2.10");
        Product p3 = new Product("Tile", "3.50", "4.15");
        Product p4 = new Product("Wood", "5.15", "4.75");
        products.put("Carpet", p1);
        products.put("Laminate", p2);
        products.put("Tile", p3);
        products.put("Wood", p4);

    }

    @Override
    public Product getProduct(String productType) throws FlooringMasteryPersistenceException {
        return products.get(productType);
    }

    @Override
    public List<Product> getProducts() throws FlooringMasteryPersistenceException {
        return new ArrayList(products.values());
    }

}