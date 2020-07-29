package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryProductDaoImpl implements FlooringMasteryProductDao {

    private Map<String, Product> products = new HashMap<String, Product>();
    private String PRODUCT_File = "FileData/Data/Products.txt";
    private final String DELIMITER = ",";
    
    public FlooringMasteryProductDaoImpl(){}

    public FlooringMasteryProductDaoImpl(String path) {
        this.PRODUCT_File = path;
    }

    public Product getProduct(String productType) throws FlooringMasteryPersistenceException {
        loadProduct();
        return products.get(productType);
    }

    public List<Product> getProducts() throws FlooringMasteryPersistenceException {
        loadProduct();
        return new ArrayList(products.values());
    }

    private Product unmarshallProduct(String productAsText) {
        String[] productTokens = productAsText.split(DELIMITER);
        Product product = new Product(productTokens[0], productTokens[1], productTokens[2]);
        return product;
    }

    private void loadProduct() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_File)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("-_- Could not load product data into memory.", e);
        }
        String currentLine;
        Product currentProduct;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentProduct = unmarshallProduct(currentLine);
            products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }

}
