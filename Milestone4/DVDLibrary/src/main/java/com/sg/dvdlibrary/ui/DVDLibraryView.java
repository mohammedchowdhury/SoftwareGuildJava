/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mohammedchowdhury
 */
public class DVDLibraryView {

    private UserIO io; // gets instanciated when the constructor is called

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

//1 Allow the user to add a DVD to the collection
//2 Allow the user to remove a DVD from the collection
//3 Allow the user to edit the information for an existing DVD in the collection
//4 Allow the user to list the DVDs in the collection
//5 Allow the user to display the information for a particular DVD
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Create New DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List All DVD");
        io.print("5. List a Particular DVD");
        io.print("6. Search DVD library");
        io.print("7. EXIT");
        
        //  1. Create New DVD
//2. Remove a DVD
//3. Edit a DVD
//4. List All DVD
//5. List a Particular DVD
//6. Search DVD library
  //7. EXIT  

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter the title");
//            private String releaseDate; // (MM/DD/YYYY)
//    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)

        String releaseDate = getDate();

        //String releaseDate = io.readString("Please enter release date");
        String mpaaRating = io.readString("Please enter movie rating");
        String directorName = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio name");
        String rating = io.readString("Please enter rating");

        DVD dvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, rating);
        //DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating){

        return dvd;
    }

    private String getDate() {
        boolean keepGoing = true;
        String date;
        do {
            date = io.readString("Please enter date in MM/dd/YYYY format");
            String[] arr = date.split("/");

            if (arr.length == 3) {
                if (arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4) {

                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate ld = LocalDate.parse(date, formatter);
                        keepGoing = false;
                    } catch (Exception e) {
                        io.print("Invalid date");
                    }

                } else {
                    io.print("Invalid date format: MM/dd/YYYY");
                }
            } else {
                io.print("Invalid date format: MM/dd/YYYY");
            }
        } while (keepGoing);
        return date;
    }

    public void displayEditDVD() {
        io.print("=== Edit DVD ===");
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created.  Please hit enter to continue");
    }

    //String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String studentInfo = String.format("%s : %s %s %s %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getRating());

            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public DVD editDVD(DVD editDVD) {
//            private String releaseDate; // (MM/DD/YYYY)
//    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)
        if (editDVD == null) {
            io.print("No such DVDs.");
            return null;
        }

        editDVD.setReleaseDate(getDate());
        editDVD.setMpaaRating(io.readString("Please enter movie rating"));
        editDVD.setDirectorName(io.readString("Please enter director's name"));
        editDVD.setStudio(io.readString("Please enter studio name"));
        editDVD.setRating(io.readString("Please enter rating"));

        return editDVD;
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getReleaseDate());
            io.print("");
        } else {
            io.print("No such DVDs.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() { /// press 4 
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) { // press 4
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() { // press 5
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() { // press 5
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    // search DVD View
    public int displaySearchMenu() {
        io.print("Search Menu");
        io.print("1. Find all movies released in the last N years");
        io.print("2. Find all the movies with a given MPAA rating");
        io.print("3. Find all the movies by a given director");
        io.print("4. Search by director grouped by MPAA rating.");
        io.print("5. Find all the movies released by a particular studio");
        io.print("6. Find the average age of the movies in the collection.");
        io.print("7. Find the newest movie in your collection.");
        io.print("8. Find the oldest movie in your collection");
        io.print("9. EXIT");
        return io.readInt("Please select from the above choices.", 1, 9);
         
    }
    
        public void displayDVDListForSearch(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String studentInfo = String.format("%s : %s %s %s %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getRating());

            io.print(studentInfo);
        }
      
    }
    
    //displayDVDList(List<DVD> list); // will print all DVD in list
    //displayDVD(DVD dvd) //will show one DVD only 
    public void displayAverage(Double d){
        io.print(d+"");
    }
    public void displayMap(Map<String, List<DVD> > dvds){      
        List<String> keys = new ArrayList<String>(dvds.keySet()); 
       for(String s : keys){
           io.print(s);
           displayDVDListForSearch(dvds.get(keys));  
       }
    }
     public String getString(String message){       
        do{
            
          
           try{
               String s = io.readString("Please enter "+message); 
               return s;           
           }catch(Exception e){
               io.print("Invalid Year");
           }
            
        }while(true);
    }
    
    public int getYear(){       
        do{
            int year; 
           String s = io.readString("Please enter a year"); 
           try{
               if(s.length()==4){
                   year = Integer.parseInt(s); 
                   return year;
               }
               
           }catch(Exception e){
               io.print("Invalid Year");
           }
            
        }while(true);
    }
    
    
    
   // public void printListOfDVD()
    //
    

//        //    Find all movies released in the last N years
//    List<DVD> findMoviesReleasedInNYears(List<DVD> list, int date);
//
//    //Find all the movies with a given MPAA rating
//    List<DVD> findAllMoviesWithGivenMPAA(List<DVD> list, String rating);
//
//    //Find all the movies by a given director
//    List<DVD> findAllMoviesByGivenDirector(List<DVD> list, String directorsName);
//
//    //When searching by director, the movies should be sorted into separate data structures by MPAA rating.
//    Map<String, List<DVD>> findAllMoviesByGivenDirectorInMPAASorted(List<DVD> list, String directorsName); // key is MPAA value is DVD
//
//    //Find all the movies released by a particular studio
//    List<DVD> findAllMoviesReleasedByAParticularStudio(List<DVD> list, String studioName);
//
//    //Find the average age of the movies in the collection
//    double findAverageAgeOfMovie(List<DVD> list);
//
//    //Find the newest movie in your collection
//    DVD findNewestMovieInCollection(List<DVD> list);
//
//    //Find the oldest movie in your collection
//    DVD findOldestMovieInCollection(List<DVD> list);
    
    
    
}
