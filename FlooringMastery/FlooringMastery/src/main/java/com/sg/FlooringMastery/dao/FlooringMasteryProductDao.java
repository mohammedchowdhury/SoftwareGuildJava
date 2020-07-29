/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Product;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface FlooringMasteryProductDao {

    public Product getProduct(String productType) throws FlooringMasteryPersistenceException;

    public List<Product> getProducts() throws FlooringMasteryPersistenceException;
}
