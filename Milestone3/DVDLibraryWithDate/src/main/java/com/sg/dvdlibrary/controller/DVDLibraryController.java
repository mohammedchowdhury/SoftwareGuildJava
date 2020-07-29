/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateIdException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author mohammedchowdhursy
 */
//1 Allow the user to add a DVD to the collection
//2 Allow the user to remove a DVD from the collection
//3 Allow the user to edit the information for an existing DVD in the collection
//4 Allow the user to list the DVDs in the collection
//5 Allow the user to display the information for a particular DVD
//Allow the user to search for a DVD by title
//Load the DVD library from a file
//Save the DVD library back to the file when the program completes
//Allow the user to add, edit, or delete many DVDs in one session
public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryServiceLayer service;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryServiceLayer service ) {
       this.service = service;
        this.view = view;
    }


    public void run() throws DVDLibraryDataValidationException, DVDLibraryDuplicateIdException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        //System.out.println("Add a DVD to collection");// add one DVD at a time
                        createDVD();
                        break;
                    case 2:
                        //System.out.println("Remove a DVD from collection");
                        removeDVD();
                        break;
                    case 3:
                        //System.out.println("Edit info of a DVD in file");
                        editDVD();
                        break;
                    case 4:
                        // System.out.println("List all DVD");
                        listDVDs();
                        break;
                    case 5:
                        // System.out.println("List info for one DVD");// search DVD by title
                        viewDVD();
                        break;
                    case 6:
                        //System.out.println("Exit");
                        exitMessage();
                        keepGoing = false;
                        break;
                }

            }
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void editDVD() throws DVDLibraryPersistenceException, DVDLibraryDataValidationException {
        view.displayEditDVD();
        String title = view.getDVDTitleChoice();
        DVD editDVD = service.getDVD(title);
        editDVD = view.editDVD(editDVD);
        if (editDVD != null) {
            service.editDVD(editDVD);
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listDVDs() throws DVDLibraryPersistenceException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = service.getAllDVD();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDLibraryPersistenceException, DVDLibraryDuplicateIdException, DVDLibraryDataValidationException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        service.createDVD(newDVD);
        view.displayCreateSuccessBanner();
    }

    private void viewDVD() throws DVDLibraryPersistenceException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD student = service.getDVD(title);
        view.displayDVD(student);
    }

    private void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedStudent = service.removeDVD(dvdTitle);
        view.displayRemoveResult(removedStudent);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
