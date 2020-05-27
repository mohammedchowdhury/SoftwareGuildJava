/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals.dao;

import com.sg.dvdlibrarystretchgoals.dto.DVD;
import com.sg.dvdlibrarystretchgoals.dto.User;
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
public class UserLibraryDaoFileImpl {

    public static final String ROSTER_FILE = "User.txt";
    public static final String DELIMITER = "::";

    private Map<Integer, User> users = new HashMap<>(); // user id and User object 

    public User addUser(int id, User user) throws DVDLibraryDaoException {
        loadUser();
        User newUser = users.put(id, user);
        writeUser();
        return newUser;
    }

    public List<User> getAllUsers() {
        loadUser();
        return new ArrayList(users.values());
    }

    public User getUser(int id) {
        loadUser();
        return users.get(id);
    }

    public User removeDVD(int id) {
        loadUser();
        User removedUser = users.remove(id);
        writeUser();
        return removedUser;
    }

    private User unmarshallUser(String userAsText) { // takes in one line
        String[] userArr = userAsText.split(DELIMITER);
        int id = Integer.parseInt(userArr[0]);
        User user = new User(id);
        user.setName(userArr[1]);

        for (int i = 1; i < userArr.length; i++) {
            user.addItem(userArr[i]);
        }
        return user;
    }

    private void loadUser() {
        Scanner scanner = null;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            System.out.println("-_- Could not load roster data into memory.");
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        User user;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            user = unmarshallUser(currentLine);
            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            users.put(user.getUserId(), user);
        }
        // close scanner
        scanner.close();
    }

    private String marshallUser(User user) {
        String userAsText = user.getUserId() + DELIMITER;
        // public title, releaseDate, mpaaRating, directorName, studio, rating

        List list = user.getBorrowedItem();
        if (list.size() == 0) {
            userAsText += user.getName();
        } else {
            userAsText += user.getName() + DELIMITER;
        }

        for(int i=0;i<list.size();i++){
            userAsText += list.get(i); 
        }
        return userAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeUser()  {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            System.out.println("Could not write to file "+e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String userAsText;
        List<User> UserList = new ArrayList(users.values());

        for (User currentUser : UserList) {
            userAsText = marshallUser(currentUser);
            out.println(userAsText);
            out.flush();
        }
        // Clean up
        out.close();
    }

}
