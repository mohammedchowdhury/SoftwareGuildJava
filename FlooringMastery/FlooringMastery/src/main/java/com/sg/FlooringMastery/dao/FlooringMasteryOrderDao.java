package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringMasteryOrderDao {

    public List<Order> getOrders(LocalDate date) throws FlooringMasteryPersistenceException;

    public Order addOrder(Order newOrder) throws FlooringMasteryPersistenceException;

    public Order editOrder(Order newOrder) throws FlooringMasteryPersistenceException;

    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringMasteryPersistenceException;

    public Map<LocalDate, Map<Integer, Order>> getAllOrders() throws FlooringMasteryPersistenceException;

    public void setUp() throws FlooringMasteryPersistenceException;

}
