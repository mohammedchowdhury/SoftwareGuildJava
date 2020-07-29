package com.sg.FlooringMastery.dao;
import com.sg.FlooringMastery.dto.Tax;
import java.util.List;
/**
 *
 * @author mohammedchowdhury
 */
public interface FlooringMasteryTaxesDao {

    public Tax getTax(String state) throws FlooringMasteryPersistenceException;

    public List<Tax> getTaxes() throws FlooringMasteryPersistenceException;

}