package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDWithSearchFeatureImpl implements DVDWithSearchFeature {

    @Override//  Find all movies released in the last N years
    public List<DVD> findMoviesReleasedInNYears(List<DVD> list, int date) {
        List<DVD> returnDate = list.stream()
                .filter((p) -> p.getReleaseDateLocalDate().getYear() >= date)
                .collect(Collectors.toList());
        return returnDate;
    }

    @Override 
    public List<DVD> findAllMoviesWithGivenMPAA(List<DVD> list, String rating) {
        List<DVD> returnDate = list.stream()
                .filter((p) -> p.getMpaaRating().equals(rating))
                .collect(Collectors.toList());
        return returnDate;
    }

    @Override
    public List<DVD> findAllMoviesByGivenDirector(List<DVD> list, String directorsName) {
        List<DVD> returnDate = list.stream()
                .filter((p) -> p.getDirectorName().equals(directorsName))
                .collect(Collectors.toList());
        return returnDate;
    }

   
    //Find all the movies released by a particular studio
    @Override //fixed
    public List<DVD> findAllMoviesReleasedByAParticularStudio(List<DVD> list, String studioName) {
        List<DVD> returnDate = list.stream()
                .filter(p -> p.getStudio().equals(studioName))
                .collect(Collectors.toList());
        return returnDate;
    }

    
        @Override //fix me
    public Map<String, List<DVD>> findAllMoviesByGivenDirectorInMPAASorted(List<DVD> list, String directorsName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //FixMe
    @Override
    public double findAverageAgeOfMovie(List<DVD> list) {
        return 1;
    }

        //FixMe
    @Override
    public DVD findNewestMovieInCollection(List<DVD> list) {

//       DVD minByAge = list.stream()
//      .max(Comparator.comparing(DVD::getReleaseDate())) 
//      .orElseThrow(Exception ::new);     
 //     return minByAge; 

      return null;
        
    }

        //FixMe
    @Override
    public DVD findOldestMovieInCollection(List<DVD> list) {
       return null; 
    }

}
