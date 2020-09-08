package com.mohammedchowdhury.bullsandcows.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author mohammedchowdhury
 */
public class Round {

    private int roundID;
    private int gameID;
    private String answer;
    private String result;
    private LocalDateTime timeOfGuess;

    public Round() {

    }

    //used for Testing
    public Round(String answer, String result, int gameID) {
        this.answer = answer;
        this.result = result;
        timeOfGuess = LocalDateTime.now();
        timeOfGuess = timeOfGuess.withNano(0);
        this.gameID = gameID;
    }

    //used by UserInput
    public Round(String answer, int gameID) {
        this.answer = answer;
        timeOfGuess = LocalDateTime.now();
        timeOfGuess = timeOfGuess.withNano(0);
        this.gameID = gameID;
    }

    //used by DataBase
    public Round(int roundId, String answer, String result, LocalDateTime timeOfGuess, int gameID) {
        this.roundID = roundId;
        this.answer = answer;
        this.result = result;
        this.timeOfGuess = timeOfGuess;
        this.gameID = gameID;
    }

    public int getRoundID() {
        return roundID;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        timeOfGuess = LocalDateTime.now();
        timeOfGuess = timeOfGuess.withNano(0);
    }

    public LocalDateTime getTimeOfGuess() {
        return timeOfGuess;
    }

    public void setTimeOfGuess(LocalDateTime timeOfGuess) {
        this.timeOfGuess = timeOfGuess;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.roundID;
        hash = 79 * hash + Objects.hashCode(this.answer);
        hash = 79 * hash + Objects.hashCode(this.result);
        hash = 79 * hash + Objects.hashCode(this.timeOfGuess);
        hash = 79 * hash + Objects.hashCode(this.gameID);
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
        final Round other = (Round) obj;
        if (this.roundID != other.roundID) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.gameID, other.gameID)) {
            return false;
        }
        if (!Objects.equals(this.timeOfGuess, other.timeOfGuess)) {
            return false;
        }
        return true;
    }

}
