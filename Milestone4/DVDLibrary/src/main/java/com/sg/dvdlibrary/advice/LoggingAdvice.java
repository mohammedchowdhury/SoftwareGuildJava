package com.sg.dvdlibrary.advice;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author mohammedchowdhury
 */
public class LoggingAdvice {
    DVDLibraryAuditDao auditDao;
    
    public LoggingAdvice(DVDLibraryAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (DVDLibraryPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}