/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.dto;

/**
 *
 * @author mohammedchowdhury
 */
public class GameVM {

    private String gameID;
    private String answer;
    private String status;

    public GameVM(Game newGame) {
        if(newGame!=null){
        this.gameID = String.valueOf(newGame.getGameID());
        if (newGame.getStatus() == true) {
            this.status = "Game in progress.";
            this.answer = "Hidden";
        } else {
            this.status = "Game ended.";
            this.answer = newGame.getRandomNumber();
        }
        }
    }

    public String getGameID() {
        return gameID;
    }

    public String getAnswer() {
        return answer;
    }

    public String getStatus() {
        return status;
    }
}
