/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public interface DVDWithSearchFeature {

    //    Find all movies released in the last N years
    List<DVD> findMoviesReleasedInNYears(List<DVD> list, int date);

    //Find all the movies with a given MPAA rating
    List<DVD> findAllMoviesWithGivenMPAA(List<DVD> list, String rating);

    //Find all the movies by a given director
    List<DVD> findAllMoviesByGivenDirector(List<DVD> list, String directorsName);

    //When searching by director, the movies should be sorted into separate data structures by MPAA rating.
    Map<String, List<DVD>> findAllMoviesByGivenDirectorInMPAASorted(List<DVD> list, String directorsName); // key is MPAA value is DVD

    //Find all the movies released by a particular studio
    List<DVD> findAllMoviesReleasedByAParticularStudio(List<DVD> list, String studioName);

    //Find the average age of the movies in the collection
    double findAverageAgeOfMovie(List<DVD> list);

    //Find the newest movie in your collection
    DVD findNewestMovieInCollection(List<DVD> list);

    //Find the oldest movie in your collection
    DVD findOldestMovieInCollection(List<DVD> list);

    //Find the average number of notes associated with movies in your collection
    //^that is a stupid Question !!! 

}
