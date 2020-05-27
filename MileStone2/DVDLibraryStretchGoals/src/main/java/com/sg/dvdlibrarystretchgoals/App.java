/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals;

import com.sg.dvdlibrarystretchgoals.controller.Controller;
import com.sg.dvdlibrarystretchgoals.dao.DVDLibraryDao;
import com.sg.dvdlibrarystretchgoals.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrarystretchgoals.ui.DVDLibraryView;
import com.sg.dvdlibrarystretchgoals.ui.UserIO;
import com.sg.dvdlibrarystretchgoals.ui.UserIOConsoleImpl;

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    public static void main(String[] args) {
        
        UserIO io = new UserIOConsoleImpl(); 
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dvdDao = new DVDLibraryDaoFileImpl(); 
        
        
        
        
        Controller controller = new Controller(view, dvdDao);  // willbe 
        
        
        
        
        
        
    }
    
}
