package com.mohammedchowdhury.bullsandcows.service;
import com.mohammedchowdhury.bullsandcows.dto.Game;
import com.mohammedchowdhury.bullsandcows.dto.Round;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface Service {

    public Game startGame()throws NoSuchGameException;
    //"begin" - POST – Starts a game, generates an answer, and sets the correct status. 
    //Should return a 201 CREATED message as well as the created gameId.

    public Round guess(Round round)throws NoSuchGameException,InvalidUserInput;
    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON.
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.

    public List<Game> getAllGames() throws NoSuchGameException;
    //"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    
    
    public Game getGameById(int gameID) throws NoSuchGameException; 
    //"game/{gameId}" - GET – Returns a specific game based on ID. Be sure in-progress games 
    //do not display their answer.
    
    public List<Round> getRoundForGameSortedByTime(int GameID) throws NoSuchGameException; 
    //"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.s

 
}