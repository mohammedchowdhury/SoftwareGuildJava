/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public String ROSTER_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";

    public DVDLibraryDaoFileImpl() {
        ROSTER_FILE = "DVDLibrary.txt";
    }

    public DVDLibraryDaoFileImpl(String fileName) {
        ROSTER_FILE = fileName;
    }

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryPersistenceException {
        loadDVD();
        DVD newDVD = dvds.put(title, dvd);
        writeDVDLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVD() throws DVDLibraryPersistenceException {
        loadDVD();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryPersistenceException {
        loadDVD();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryPersistenceException {
        loadDVD();
        DVD removedDVD = dvds.remove(title);
        writeDVDLibrary();
        return removedDVD;
    }

    private DVD unmarshallDVD(String dvdAsText) { // takes in one line
        String[] dvdArr = dvdAsText.split(DELIMITER);
        String title = dvdArr[0];
        DVD dvd = new DVD(title);
        dvd.setReleaseDate(dvdArr[1]);
        dvd.setMpaaRating(dvdArr[2]);
        dvd.setDirectorName(dvdArr[3]);
        dvd.setStudio(dvdArr[4]);
        dvd.setRating(dvdArr[5]);
        //DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating)
        return dvd;
    }

    private void loadDVD() throws DVDLibraryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryPersistenceException("-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDVD holds the most recent DVD unmarshalled
        DVD currentDVD;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // DVD object by calling the unmarshallDVD method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);
            // We are going to use the DVD id as the map key for our DVD object.
            // Put currentDVD into the map using DVD id as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDVD(DVD aDVD) {
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        // public title, releaseDate, mpaaRating, directorName, studio, rating
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getRating();
        return dvdAsText;
    }

    /**
     * Writes all DVD's in the roster out to a ROSTER_FILE. See loadRoster for
     * file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeDVDLibrary() throws DVDLibraryPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DVDLibraryPersistenceException("Could not save DVD data.", e);
        }

        // Write out the DVD objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the DVD map,
        // get the Collection of DVD and iterate over them but we've
        // already created a method that gets a List of DVD so
        // we'll reuse it.
        String dvdAsText;
        List<DVD> DVDList = new ArrayList(dvds.values());

        for (DVD currentDVD : DVDList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        // Clean up
        out.close();
    }

}
