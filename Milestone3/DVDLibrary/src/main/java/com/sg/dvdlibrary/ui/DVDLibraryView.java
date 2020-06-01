/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDLibraryView {

    private UserIO io; // gets instanciated when the constructor is called

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

//1 Allow the user to add a DVD to the collection
//2 Allow the user to remove a DVD from the collection
//3 Allow the user to edit the information for an existing DVD in the collection
//4 Allow the user to list the DVDs in the collection
//5 Allow the user to display the information for a particular DVD
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Create New DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List All DVD");
        io.print("5. List a Particular DVD");
        io.print("6. EXIT");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title");
//            private String releaseDate; // (MM/DD/YYYY)
//    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)

        String releaseDate = io.readString("Please enter release date");
        String mpaaRating = io.readString("Please enter movie rating");
        String directorName = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio name");
        String rating = io.readString("Please enter rating");

        DVD dvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, rating);
        //DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating){

        return dvd;
    }

    public void displayEditDVD() {
        io.print("=== Edit DVD ===");
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created.  Please hit enter to continue");
    }

    //String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating
    public void displayStudentList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String studentInfo = String.format("%s : %s %s %s %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getRating());

            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public DVD editDVD(DVD editDVD) {
//            private String releaseDate; // (MM/DD/YYYY)
//    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)
        if (editDVD == null) {
            io.print("No such DVDs.");
            return null;
        }

        editDVD.setReleaseDate(io.readString("Please enter release date"));
        editDVD.setMpaaRating(io.readString("Please enter movie rating"));
        editDVD.setDirectorName(io.readString("Please enter director's name"));
        editDVD.setStudio(io.readString("Please enter studio name"));
        editDVD.setRating(io.readString("Please enter rating"));

        return editDVD;
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getReleaseDate());
            io.print("");
        } else {
            io.print("No such DVDs.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() { /// press 4 
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) { // press 4
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() { // press 5
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() { // press 5
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
