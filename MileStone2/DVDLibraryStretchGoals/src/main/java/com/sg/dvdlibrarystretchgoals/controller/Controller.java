/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals.controller;


import com.sg.dvdlibrarystretchgoals.dao.DVDLibraryDao;
import com.sg.dvdlibrarystretchgoals.dao.DVDLibraryDaoException;
import com.sg.dvdlibrarystretchgoals.dao.UserLibraryDaoFileImpl;
import com.sg.dvdlibrarystretchgoals.dto.DVD;
import com.sg.dvdlibrarystretchgoals.ui.DVDLibraryView;
import com.sg.dvdlibrarystretchgoals.ui.UserLibraryView;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
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
public class Controller {

    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    private UserLibraryView userView; 
    private UserLibraryDaoFileImpl dao; 

    public Controller(DVDLibraryView view, DVDLibraryDao dao) {
        this.dao = dao;
        this.view = view;
        
    }
    public void runUser(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                 menuSelection = getMenuSelectionUser();

                switch (menuSelection) {
                    case 1:
                        System.out.println("Add a new User to collection");// add one DVD at a time
                        //createDVD(); 
                        break;
                    case 2:
                        System.out.println("Remove a DVD from collection");
                        removeDVD();
                        break; 
                    case 3:
                        System.out.println("Edit info of a DVD in file");
                        editDVD(); 
                        break; 
                    case 4:
                        System.out.println("List all DVD");
                        listDVDs(); 
                        break; 
                    case 5:
                        System.out.println("List info for one DVD");// search DVD by title
                        viewDVD(); 
                        break; 
                    case 6:
                        System.out.println("Exit");
                        exitMessage(); 
                        keepGoing = false;
                        break;
                }

            }
        }catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }
    
    
    public int getMenuSelectionUser(){
        return 0; 
    }

    public void runDVD() { // this adds a new DVD
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                 menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        System.out.println("Add a DVD to collection");// add one DVD at a time
                        createDVD(); 
                        break;
                    case 2:
                        System.out.println("Remove a DVD from collection");
                        removeDVD();
                        break; 
                    case 3:
                        System.out.println("Edit info of a DVD in file");
                        editDVD(); 
                        break; 
                    case 4:
                        System.out.println("List all DVD");
                        listDVDs(); 
                        break; 
                    case 5:
                        System.out.println("List info for one DVD");// search DVD by title
                        viewDVD(); 
                        break; 
                    case 6:
                        System.out.println("Exit");
                        exitMessage(); 
                        keepGoing = false;
                        break;
                }

            }
        }catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }
    
    private void editDVD() throws DVDLibraryDaoException{
        view.displayEditDVD(); 
        String title = view.getDVDTitleChoice();
        DVD editDVD = dao.getDVD(title);
        editDVD = view.editDVD(editDVD); 
        dao.addDVD(editDVD.getTitle(), editDVD); 
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVD();
        view.displayDVDList(dvdList);
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD student = dao.getDVD(title);
        view.displayStudent(student);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedStudent = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedStudent);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }


}
