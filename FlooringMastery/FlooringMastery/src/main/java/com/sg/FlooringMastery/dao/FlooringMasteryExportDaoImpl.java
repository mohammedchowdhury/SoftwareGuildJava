package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FlooringMasteryExportDaoImpl implements FlooringMasteryExportDao{
    private Map<Integer, Order> orders = new TreeMap<Integer, Order>();
    
    public int exportData(Map<LocalDate, Map<Integer, Order>> tempOrders) throws FlooringMasteryPersistenceException {
        List<LocalDate> dates = new ArrayList(tempOrders.keySet());
        
        for (int i = 0; i < dates.size(); i++) {
            Map<Integer, Order> oneDayOrder = tempOrders.get(dates.get(i));
            List<Integer> orderNumbers = new ArrayList(oneDayOrder.keySet());

            for (int j = 0; j < orderNumbers.size(); j++) {
                this.orders.put(orderNumbers.get(j), oneDayOrder.get(orderNumbers.get(j)));
            }
        }
        writeOrder();
        return this.orders.size();

    }
    private void writeOrder() throws FlooringMasteryPersistenceException {
        PrintWriter out;
        String PATH = "FileData/Backup/DataExport.txt";
        try {
            out = new PrintWriter(new FileWriter(PATH));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("Could not save order data.", e);
        }
        String orderAsText;
        List<Integer> orderNumbers = new ArrayList(this.orders.keySet());
        for (int i = 0; i < this.orders.size(); i++) {
            Order currentOrder = this.orders.get(orderNumbers.get(i));

            orderAsText = currentOrder.orderToStringExportFile();
            out.println(orderAsText);
            out.flush();
        }
        out.close();
    }
}