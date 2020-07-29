/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryExportDao;
import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryExportDaoImplStubClass implements FlooringMasteryExportDao {

    private Map<Integer, Order> orders = new TreeMap<Integer, Order>();

    @Override
    public int exportData(Map<LocalDate, Map<Integer, Order>> tempOrders) throws FlooringMasteryPersistenceException {
        List<LocalDate> dates = new ArrayList(tempOrders.keySet());

        for (int i = 0; i < dates.size(); i++) {
            Map<Integer, Order> oneDayOrder = tempOrders.get(dates.get(i));
            List<Integer> orderNumbers = new ArrayList(oneDayOrder.keySet());

            for (int j = 0; j < orderNumbers.size(); j++) {
                this.orders.put(orderNumbers.get(j), oneDayOrder.get(orderNumbers.get(j)));
            }
        }
        return this.orders.size();
    }

}
