package com.sg.jdbctcomplexexample;

import com.sg.jdbctcomplexexample.controller.MeetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author kylerudy
 */
@SpringBootApplication
public class App{
    
    @Autowired
    MeetingController controller;

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);
    }
    
    

    public void run(String... args) throws Exception {
        controller.run();
    }   
}