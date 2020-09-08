/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.dao;

import com.mohammedchowdhury.bullsandcows.dto.Game;
import java.util.List;

/**
 *
 * @author mohammedchowdhury
 */
public interface GameDao {

    public Game addNewGame(Game newGame);
    //"begin" - POST – Starts a game, generates an answer, and sets the
    //correct status. Should return a 201 CREATED message as well as the created gameId.

    public Game getGameById(int gameID);
    // getGameById()
    //"game/{gameId}" - GET – Returns a specific game based on ID. Be sure in-progress games do not display their answer.

    public List<Game> getListOfGames();
    //getListOfGames()
    //"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.

    public void updateGame(Game game);
    //used to update the game when the players win. 

    public void deleteGameByID(int GameID);
    //used only in testing

}
