package com.sg.FlooringMastery.advice;

import com.sg.FlooringMastery.dao.FlooringMasteryAuditDaoFile;
import com.sg.FlooringMastery.dao.FlooringMasteryPersistenceException;
import com.sg.FlooringMastery.dto.Order;
import java.time.LocalDate;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author mohammedchowdhury
 */
public class LoggingAdvice {

    FlooringMasteryAuditDaoFile auditDao;

    public LoggingAdvice(FlooringMasteryAuditDaoFile auditDao) {
        this.auditDao = auditDao;
    }

    public void exceptionAudit(Exception ex) {
        String message = "Exception Thrown " + ex.getMessage();

        try {
            auditDao.writeAuditEntry(message);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    //used in service
    public void deleteOrderAudit(JoinPoint jp) {
        Object[] args = jp.getArgs();
        LocalDate ld = (LocalDate) args[0];
        int orderNumber = (int) args[1];

        try {
            auditDao.writeAuditEntry("Order successfully removed. Date: " + ld.toString() + " Order Number: " + orderNumber);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void addOrderAudit(JoinPoint jp) {
        Object[] args = jp.getArgs();
        Order o1 = (Order) args[0];
        try {
            auditDao.writeAuditEntry(o1.orderToStringExportFile()+ " Was Successfully added");
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void editOrderAudit(JoinPoint jp) {
        Object[] args = jp.getArgs();
        Order o1 = (Order) args[0];
        try {
            auditDao.writeAuditEntry(o1.orderToStringExportFile()+ " Was Successfully Edited");
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    //used in view
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = "";
        for (Object currentArg : args) {
             auditEntry = auditEntry+" "+currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
