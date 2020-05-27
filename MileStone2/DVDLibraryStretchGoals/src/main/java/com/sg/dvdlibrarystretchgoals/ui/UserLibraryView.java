/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarystretchgoals.ui;

import com.sg.dvdlibrarystretchgoals.dto.User;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public class UserLibraryView {

    private UserIO io; // gets instanciated when the constructor is called

    public UserLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() { // 
        io.print("User Menu");
        io.print("1. Create New User");
        io.print("2. Remove a User");
        io.print("3. Edit a User");
        io.print("4. List All Users");
        io.print("5. List a Particular User");
        io.print("6. EXIT");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
   public User getNewUserInfo(){// selection 1 
    String name = io.readString("Please enter User Name :");
    int userId = io.readInt("Please enter userID"); 
    User user = new User(userId, name);        
    return user; 
    }
      

    public void displayCreateUserBanner() {
        io.print("=== Create User ===");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Users ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    //String title, String releaseDate, String mpaaRating, String directorName, String studio,String rating
    public void displayUSerList(List<User> userList) {
        for (User currentUser : userList) {
            String userInfo = ""; 
            
            userInfo = currentUser.getUserId()+" "+currentUser.getName();
            for(String s : currentUser.getBorrowedItem()){
                userInfo = userInfo + s; 
            }
            



            io.print(userInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayUserBanner() {
        io.print("=== Display User ===");
    }

//    public User editUser(User editUser) {
////            private String releaseDate; // (MM/DD/YYYY)
////    private String mpaaRating; //  (G , PG , PG-13 , R , NC-17)
//        if (editDVD == null) {
//            io.print("No such DVDs.");
//            return null;
//        }
//
//        editDVD.setReleaseDate(io.readString("Please enter release date"));
//        editDVD.setMpaaRating(io.readString("Please enter movie rating"));
//        editDVD.setDirectorName(io.readString("Please enter director's name"));
//        editDVD.setStudio(io.readString("Please enter studio name"));
//        editDVD.setRating(io.readString("Please enter rating"));
//
//        return editDVD;
//    }

    public String getUserIdChoice() {
        return io.readString("Please enter the User ID.");
    }

    public void displayStudent(User user) {
        if (user != null) {
            io.print(user.getUserId()+"");
            io.print(user.getName());
            io.print("");
        } else {
            io.print("No such User.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveUserBanner() { /// press 4 
        io.print("=== Remove User ===");
    }

    public void displayRemoveResult(User user) { // press 4
        if (user != null) {
            io.print("User successfully removed.");
        } else {
            io.print("No such User.");
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
     
}
