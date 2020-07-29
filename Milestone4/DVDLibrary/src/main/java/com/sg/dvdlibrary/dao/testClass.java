 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */


public class testClass {

    public static void main(String[] args) {

        // DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio, String rating)
        DVD dvd1 = new DVD("1", "01/20/2000", "R", "Joe", "COW", "Great Movie");
        DVD dvd2 = new DVD("2", "01/20/2001", "P", "BOB", "FOX", "BAD Movie");
        DVD dvd3 = new DVD("3", "01/20/2018", "PG", "TIM", "DUCK", "TERRIBLE Movie");
        DVD dvd4 = new DVD("4", "01/20/2010", "T", "MOE", "CHICKEN", "CRAP Movie");
        DVD dvd5 = new DVD("5", "01/20/2008", "A", "STAR", "GOOSE", "NO Movie");
        DVD dvd6 = new DVD("6", "01/20/2020", "M", "Wallet", "ELF", "HORRIBLE Movie");

        List<DVD> movieList = new ArrayList<DVD>();

        movieList.add(dvd1);
        movieList.add(dvd2);
        movieList.add(dvd3);
        movieList.add(dvd4);
        movieList.add(dvd5);
        movieList.add(dvd6);
        
        DVDWithSearchFeature search  = new DVDWithSearchFeatureImpl(); 
        
       
        
        List<DVD> retArr = search.findAllMoviesByGivenDirector(movieList,"TIM");
        
         System.out.println(retArr.size());
         
        for(int i=0;i<retArr.size();i++){
            System.out.println(retArr.get(i).toString());
        }
        
        System.out.println("Test");

    }

}
