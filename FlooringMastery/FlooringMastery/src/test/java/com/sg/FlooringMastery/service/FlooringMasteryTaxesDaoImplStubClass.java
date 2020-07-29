/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dao.FlooringMasteryTaxesDao;
import com.sg.FlooringMastery.dto.Tax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryTaxesDaoImplStubClass implements FlooringMasteryTaxesDao {
//com.sg.FlooringMastery.service.FlooringMasteryTaxesDaoImplStubClass
    private Map<String, Tax> taxes = new HashMap<String, Tax>();

    public FlooringMasteryTaxesDaoImplStubClass() {
        Tax t1 = new Tax("TX", "4.45");
        Tax t2 = new Tax("WA", "9.25");
        Tax t3 = new Tax("KY", "6.00");
        Tax t4 = new Tax("CA", "25.00");
        taxes.put(t1.getState(), t1);
        taxes.put(t2.getState(), t2);
        taxes.put(t3.getState(), t3);
        taxes.put(t4.getState(), t4);
    }
    @Override
    public Tax getTax(String state) throws FlooringMasteryPersistenceException {
        return taxes.get(state.toUpperCase());
    }

    @Override
    public List<Tax> getTaxes() throws FlooringMasteryPersistenceException {
        return new ArrayList(taxes.values());
    }

}
