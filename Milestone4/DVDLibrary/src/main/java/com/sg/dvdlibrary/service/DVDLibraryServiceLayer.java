/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface DVDLibraryServiceLayer {

    void createDVD(DVD dvd) throws
            DVDLibraryDuplicateIdException,
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;
    
    void editDVD(DVD dvd) throws // used for edited DVD
            DVDLibraryDataValidationException,
            DVDLibraryPersistenceException;

    List<DVD> getAllDVD() throws DVDLibraryPersistenceException;

    DVD removeDVD(String title) throws DVDLibraryPersistenceException;

    DVD getDVD(String title) throws DVDLibraryPersistenceException;

}
