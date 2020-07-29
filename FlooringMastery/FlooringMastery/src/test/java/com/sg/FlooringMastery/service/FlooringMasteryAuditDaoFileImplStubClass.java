/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.service;

import com.sg.FlooringMastery.dao.FlooringMasteryAuditDaoFile;
import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;

/**
 *
 * @author mohammedchowdhury
 */
public class FlooringMasteryAuditDaoFileImplStubClass implements FlooringMasteryAuditDaoFile{
        private static final String AUDIT_FILE = "FileData/Audit/audit.txt";

    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException {
       //do nothing
    }
}
//com.sg.FlooringMastery.service.FlooringMasteryAuditDaoFileImplStubClass