package com.mohammedchowdhury.bullsandcows.dto;

import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Game {

    private int gameID;
    private String randomNumber;
    private boolean status; // 1 = true = game in progress // 0 = false = game ended

    public Game(String randomNumber) {
        this.randomNumber = randomNumber;
        status = true;
    }

    public Game(int gameID, String randomNumber,boolean status) {
        this.gameID = gameID; 
        this.randomNumber = randomNumber;
        this.status = status;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    

//    public void setGameID(int gameID) {
//        this.gameID = gameID;
//    }

    public void endGame() {
        status = false;
    }
//
//    public int getGameID() {
//        return this.gameID;
//    }
//
//    public String getRandomNumber() {
//        return this.randomNumber;
//    }
//
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.gameID;
        hash = 37 * hash + Objects.hashCode(this.randomNumber);
        hash = 37 * hash + (this.status ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameID != other.gameID) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.randomNumber, other.randomNumber)) {
            return false;
        }
        return true;
    }





}
