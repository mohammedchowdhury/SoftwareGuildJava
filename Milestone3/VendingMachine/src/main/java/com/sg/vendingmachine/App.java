package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.ItemDataValidationException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.VendingMachineServiceImpl;
import com.sg.vendingmachine.view.UserIO;
import com.sg.vendingmachine.view.UserIOConsoleImpl;
import com.sg.vendingmachine.view.VendingMachineView;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) throws VendingMachinePersistenceException, NoItemInventoryException, InsufficientFundsException, ItemDataValidationException {

        VendingMachineDao dao = new VendingMachineDaoImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineService service = new VendingMachineServiceImpl(dao, auditDao);

        UserIO io = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(io);

        VendingMachineController controller = new VendingMachineController(service, view);

        controller.runMachine();
        
    }

}
