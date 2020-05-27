/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals.dto;
/**
 *
 * @author mohammedchowdhury
 */
//Title
//Release date
//MPAA rating
//Director's name
//Studio
//User rating or note (allows the user to enter additional information, e.g., "Good family movie")
public class DVD {
    
    private String title; 
    private String releaseDate; // (MM/DD/YYYY)
    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)
    private String directorName; 
    private String studio; 
    private String rating; 
    private boolean borrowed ; // if the item is borrowed out true; 
    
    public DVD(String title){
        this.title = title; 
    }
    
    public DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating, String borrow){
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating; 
        this.directorName = directorName; 
        this.studio = studio;
        this.rating = rating; 
        
        if(borrow.equals("true")){ //  if the item is borroed; 
              this.borrowed = true;  
        }else{
            this.borrowed = false; 
        }      
    }

    
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public void setBorrowed(){
        this.borrowed = true; 
    }
    
    public void setReturned(){
        this.borrowed = false; 
    }
    
    public boolean getBorrowedStatus(){ // checks to see if the DVD item was returned 
        return this.borrowed; 
    }
}