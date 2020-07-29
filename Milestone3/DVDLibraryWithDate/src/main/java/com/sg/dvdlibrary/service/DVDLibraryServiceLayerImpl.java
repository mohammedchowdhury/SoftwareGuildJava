/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
//package com.sg.dvdlibrary.dao;

import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {

    private DVDLibraryAuditDao auditDao;
    DVDLibraryDao dao;

    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createDVD(DVD dvd) throws DVDLibraryDuplicateIdException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        // First check to see if there is alreay a DVD 
        // associated with the given DVD's title
        // If so, we're all done here - 
        // throw a ClassRosterDuplicateIdException
        if (dao.getDVD(dvd.getTitle()) != null) {
            throw new DVDLibraryDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                    + dvd.getTitle()
                    + " already exists");
        }
        // Now validate all the fields on the given Student object.  
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateDVDData(dvd);

        // We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addDVD(dvd.getTitle(), dvd);

        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " CREATED.");
    }

    @Override
    public void editDVD(DVD dvd) throws DVDLibraryDataValidationException, DVDLibraryPersistenceException {
        // not chekcing for duplicates because this is called when we are editing the existing DVD

        // Now validate all the fields on the given Student object.  
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateDVDData(dvd);

        // We passed all our business rules checks so go ahead 
        // and persist the Student object
        dao.addDVD(dvd.getTitle(), dvd);

        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry("DVD " + dvd.getTitle() + " Edited.");

    }

    @Override
    public List<DVD> getAllDVD() throws DVDLibraryPersistenceException {
        return dao.getAllDVD();
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        DVD removedDVD = dao.removeDVD(title);
        auditDao.writeAuditEntry("Student " + title + " REMOVED.");
        return removedDVD;
    }
    
    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        return dao.getDVD(title);
    }

    private void validateDVDData(DVD dvd) throws DVDLibraryDataValidationException {
        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getDirectorName() == null
                || dvd.getDirectorName().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0
                || dvd.getRating() == null
                || dvd.getRating().trim().length() == 0) {

            throw new DVDLibraryDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
