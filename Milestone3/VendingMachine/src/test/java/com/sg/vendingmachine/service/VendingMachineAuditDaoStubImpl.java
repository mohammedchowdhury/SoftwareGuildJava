package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author mohammedchowdhury
 */
public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {

    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        //do nothing . . .
    }
}
