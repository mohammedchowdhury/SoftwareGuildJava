package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.Map;

public interface FlooringMasteryExportDao {

    public int exportData(Map<LocalDate, Map<Integer, Order>> orders) throws FlooringMasteryPersistenceException;

}
