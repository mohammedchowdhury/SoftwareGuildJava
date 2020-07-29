package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import com.sg.FlooringMastery.dto.Product;
import com.sg.FlooringMastery.dto.Tax;
import java.time.LocalDate;
import java.util.List;

public interface FlooringMasteryService {

    public List<Order> getOrders(LocalDate date) throws NoOrderException, FlooringMasteryPersistenceException;

    public List<Tax> getTaxes() throws FlooringMasteryPersistenceException, NoTaxesFoundException;

    public List<Product> getProducts() throws FlooringMasteryPersistenceException, NoProductsFoundException;

    public void setUp() throws FlooringMasteryPersistenceException;

    public Order addOrder(Order tempOrder) throws FlooringMasteryPersistenceException, InvalidOrderException;

    public Order editOrder(Order tempOrder) throws FlooringMasteryPersistenceException, InvalidOrderException;

    public Order getOrder(LocalDate date, int orderNumber) throws NoOrderException, FlooringMasteryPersistenceException;

    public Order removeOrder(LocalDate date, int orderNumber) throws NoOrderException, FlooringMasteryPersistenceException;

    public int exportData() throws NoOrderException, FlooringMasteryPersistenceException;
}
