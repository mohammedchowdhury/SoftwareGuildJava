/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl(); // Instanciates the IO class for user input
        ClassRosterView myView = new ClassRosterView(myIo); // takes in the Input class 
        
        ClassRosterDao myDao = new ClassRosterDaoFileImpl(); // reads and write to file
        
        
        ClassRosterController controller = new ClassRosterController(myDao, myView); // Passess ClassRosterView

        controller.run();


        

    }
}
