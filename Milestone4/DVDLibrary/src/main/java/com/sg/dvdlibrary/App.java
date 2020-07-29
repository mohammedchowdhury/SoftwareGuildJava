package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateIdException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mohammedchowdhury
 */
public class App {
    public static void main(String[] args) throws DVDLibraryDataValidationException, DVDLibraryDuplicateIdException {
        
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml"); 
        DVDLibraryController controller = app.getBean("controller", DVDLibraryController.class); 
        controller.run();

    }   
}