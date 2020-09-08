/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.dao;

import com.mohammedchowdhury.bullsandcows.dto.Round;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface RoundDao {
    public Round addRound(Round newRound);
    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.
    
    public List<Round> getRoundForGameSortedByTime(int gameID);
    //"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.

    public void deleteRoundById(int roundID);
    
    
}
