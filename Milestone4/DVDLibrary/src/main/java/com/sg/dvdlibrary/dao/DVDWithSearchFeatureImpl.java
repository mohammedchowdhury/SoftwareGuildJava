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
    @Override
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

    @Override //fixed 
    public double findAverageAgeOfMovie(List<DVD> list) {
        double age = 0;
        for (int a = 0; a < list.size(); a++) {
            age = age + list.get(a).getReleaseDateLocalDate().getYear();
        }
        age = age / list.size();
        return age;
    }

    @Override
    public DVD findNewestMovieInCollection(List<DVD> list) {
        DVD newMoie;
        if (list == null || list.size() == 0) {
            return null;
        }
        newMoie = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (newMoie.getReleaseDateLocalDate().getYear() < list.get(i).getReleaseDateLocalDate().getYear()) {
                newMoie = list.get(i);
            }
        }
        return newMoie;
    }


    @Override
    public DVD findOldestMovieInCollection(List<DVD> list) {
       DVD oldestMovie;
        if (list == null || list.size() == 0) {
            return null;
        }
        oldestMovie = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (oldestMovie.getReleaseDateLocalDate().getYear()>list.get(i).getReleaseDateLocalDate().getYear()) {
                oldestMovie = list.get(i);
            }
        }
        return oldestMovie;
    }

}
