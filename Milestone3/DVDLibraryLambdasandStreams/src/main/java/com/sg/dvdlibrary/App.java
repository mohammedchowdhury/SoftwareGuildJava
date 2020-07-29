/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryAuditDaoFileImpl;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dao.DVDWithSearchFeature;
import com.sg.dvdlibrary.dao.DVDWithSearchFeatureImpl;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateIdException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayerImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    public static void main(String[] args) throws DVDLibraryDataValidationException, DVDLibraryDuplicateIdException {
        
        
        
        UserIO myIo = new UserIOConsoleImpl(); // Instanciates the IO class for user input
        DVDLibraryView myView = new DVDLibraryView(myIo); // takes in the Input class 
        
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();     
        DVDLibraryAuditDao myAuditDao = new DVDLibraryAuditDaoFileImpl(); 
        
        DVDLibraryServiceLayer service = new DVDLibraryServiceLayerImpl(myDao,myAuditDao);  
        
        DVDWithSearchFeature search = new DVDWithSearchFeatureImpl(); 
       
        DVDLibraryController controller = new DVDLibraryController(myView,service,search); 
        
        controller.run();
        
    }
    
}
