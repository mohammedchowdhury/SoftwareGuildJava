package com.sg.FlooringMastery.dao;

import com.sg.FlooringMastery.dto.Tax;
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
public class FlooringMasteryTaxesDaoImpl implements FlooringMasteryTaxesDao {

    private Map<String, Tax> taxes = new HashMap<String, Tax>(); //state : Taxes

    private final String DELIMITER = ",";
    private String TAX_File = "FileData/Data/Taxes.txt";

    public FlooringMasteryTaxesDaoImpl(String path) {
        this.TAX_File = path;
    }

    public FlooringMasteryTaxesDaoImpl() {
    }

    /**
     *
     * @param state ex TX or NY
     * @return Tax or null
     * @throws FlooringMasteryPersistenceException
     */
    public Tax getTax(String state) throws FlooringMasteryPersistenceException {
        loadTax();
        return taxes.get(state.toUpperCase());
    }

    public List<Tax> getTaxes() throws FlooringMasteryPersistenceException {
        loadTax();
        return new ArrayList(taxes.values());
    }

    private Tax unmarshallTax(String taxAsText) {
        String[] taxTokens = taxAsText.split(DELIMITER);
        //Tax tax = new Tax(taxTokens[0], taxTokens[1], taxTokens[2]);
        Tax tax = new Tax(taxTokens[0],taxTokens[2]);
        return tax;
    }

    private void loadTax() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_File)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("-_- Could not load tax data into memory.", e);
        }
        String currentLine;
        Tax currentTax;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTax = unmarshallTax(currentLine);
            taxes.put(currentTax.getState(), currentTax);
        }
        scanner.close();
    }
}
