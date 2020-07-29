/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDLibraryDaoFileImplTest {

    DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testDVDLibrary.txt";
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetDVD() throws Exception {
        String title = "Aladdin";
        String releaseDate = "01/01/2020";
        String mpaaRating = "PG-13";
        String directorName = "Guy Ritchie";
        String studio = "Fox";
        String rating = "Aladdin wants to wow you constantly, but just ends up tripping over itself.";

        DVD newDvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, rating);

        testDao.addDVD(newDvd.getTitle(), newDvd);
        // Get the DVD from the DAO
        DVD retrievedDVD = testDao.getDVD(title);

        // Check the data is equal
        assertEquals(newDvd.getTitle(), retrievedDVD.getTitle(), "Checking DVD title.");

        assertEquals(newDvd.getReleaseDate(), retrievedDVD.getReleaseDate(), "Checking DVD release date.");

        assertEquals(newDvd.getMpaaRating(), retrievedDVD.getMpaaRating(), "Checking DVD MPAA Rating.");

        assertEquals(newDvd.getDirectorName(), retrievedDVD.getDirectorName(), "Checking DVD Directors Name.");

        assertEquals(newDvd.getStudio(), retrievedDVD.getStudio(), "Checking DVD Studio.");

        assertEquals(newDvd.getRating(), retrievedDVD.getRating(), "Checking DVD Rating.");
    }

    @Test
    public void testAddGetAllDVD() throws Exception {
        String title = "Aladdin";
        String releaseDate = "01/01/2020";
        String mpaaRating = "PG-13";
        String directorName = "Guy Ritchie";
        String studio = "Fox";
        String rating = "Aladdin wants to wow you constantly, but just ends up tripping over itself.";

        DVD newDvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, rating);

        String title2 = "Dumbo";
        String releaseDate2 = "03/29/2019";
        String mpaaRating2 = "PG-13";
        String directorName2 = "Tim Burton";
        String studio2 = "Walt Disney Studio";
        String rating2 = "Dumbo is as expressively adorable as any human actor in the film, which includes many, nearly wordless turns by supporting characters as circus performers.";

        DVD newDvd2 = new DVD(title2, releaseDate2, mpaaRating2, directorName2, studio2, rating2);

        // Add both our DVD to the DAO
        testDao.addDVD(title, newDvd);
        testDao.addDVD(title2, newDvd2);

        // Retrieve the list of all DVD's within the DAO
        List<DVD> allDVD = testDao.getAllDVD();

        // First check the general contents of the list
        assertNotNull(allDVD, "The list of dvd must not null");
        assertEquals(2, allDVD.size(), "List of dvds should have 2 dvd.");

        // Then the specifics
        assertTrue(testDao.getAllDVD().contains(newDvd), "The list of dvd should include aladdin.");
        assertTrue(testDao.getAllDVD().contains(newDvd2), "The list of dvd should include Dumbo.");
    }

    @Test
    public void testRemoveDVD() throws Exception {
        //  Create two new students
        String title = "Aladdin";
        String releaseDate = "01/01/2020";
        String mpaaRating = "PG-13";
        String directorName = "Guy Ritchie";
        String studio = "Fox";
        String rating = "Aladdin wants to wow you constantly, but just ends up tripping over itself.";

        DVD newDvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, rating);

        String title2 = "Dumbo";
        String releaseDate2 = "03/29/2019";
        String mpaaRating2 = "PG-13";
        String directorName2 = "Tim Burton";
        String studio2 = "Walt Disney Studio";
        String rating2 = "Dumbo is as expressively adorable as any human actor in the film, which includes many, nearly wordless turns by supporting characters as circus performers.";

        DVD newDvd2 = new DVD(title2, releaseDate2, mpaaRating2, directorName2, studio2, rating2);

        // Add both our DVD to the DAO
        testDao.addDVD(title, newDvd);
        testDao.addDVD(title2, newDvd2);

        // remove the first DVD - Aladdin
        DVD removedDVD = testDao.removeDVD(title);

        // Check that the correct object was removed.
        assertEquals(removedDVD, newDvd, "The removed DVD should be Aladdin.");

        // Get all the DVD
        List<DVD> allDVD = testDao.getAllDVD();

        // First check the general contents of the list
        assertNotNull(allDVD, "All DVD list should be not null.");
        assertEquals(1, allDVD.size(), "All DVD should only have 1 DVD.");

        // Then the specifics
        assertFalse(allDVD.contains(newDvd), "All DVD should NOT include Aladdin.");
        assertTrue(allDVD.contains(newDvd2), "All DVD should include Dumbo.");

        // Remove the second DVD
        removedDVD = testDao.removeDVD(newDvd2.getTitle());

        // Check that the correct object was removed.
        assertEquals(removedDVD, newDvd2, "The removed DVD should be DUMBO.");

        // retrieve all of the DVD again, and check the list.
        allDVD = testDao.getAllDVD();

        // Check the contents of the list - it should be empty
        assertTrue(allDVD.isEmpty(), "The retrieved list of DVD's should be empty.");

        // Try to 'get' both DVD by their old title - they should be null!
        DVD retrievedDVD = testDao.getDVD(newDvd.getTitle());
        assertNull(retrievedDVD, "Aladdin was removed, should be null.");

        retrievedDVD = testDao.getDVD(newDvd2.getTitle());
        assertNull(retrievedDVD, "Aladdin was removed, should be null.");
    }

}


