/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.controller;

import com.mohammedchowdhury.bullsandcows.dto.Game;
import com.mohammedchowdhury.bullsandcows.dto.GameVM;
import com.mohammedchowdhury.bullsandcows.dto.Round;
import com.mohammedchowdhury.bullsandcows.dto.RoundVM;
import com.mohammedchowdhury.bullsandcows.service.InvalidUserInput;
import com.mohammedchowdhury.bullsandcows.service.NoSuchGameException;
import com.mohammedchowdhury.bullsandcows.service.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohammedchowdhury
 */
@RestController
//@RequestMapping()
public class Controller {

    @Autowired
    Service service;

//"begin" - POST – Starts a game, generates an answer, and sets the correct status. 
//Should return a 201 CREATED message as well as the created gameId.
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public GameVM create()throws NoSuchGameException{
        return new GameVM(service.startGame());
    }

//"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
//The program must calculate the results of the guess and mark the game finished if the guess is correct. 
//It returns the Round object with the results filled in.
    @PostMapping("/guess")
    // @ResponseStatus(HttpStatus.CREATED)
    public RoundVM guess(@RequestBody Round round)throws NoSuchGameException,InvalidUserInput{
        Round thisRound = round;
        Round newround = service.guess(round);
        
        return new RoundVM(newround);
    }

//"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    @GetMapping("/game")
    public List<GameVM> getListOfGames()throws NoSuchGameException{
        List<GameVM> listOfGameVM = new ArrayList<>();
        List<Game> listOFGames = service.getAllGames();
        for (int i = 0; i < listOFGames.size(); i++) {
            listOfGameVM.add(new GameVM(listOFGames.get(i)));
        }
        return listOfGameVM;

    }

//"game/{gameId}" - GET – Returns a specific game based on ID.Be sure in-progress games do not display their answer.
    @GetMapping("/game/{gameID}")
    public GameVM getGameByID(@PathVariable int gameID)throws NoSuchGameException{
        return new GameVM(service.getGameById(gameID));
    }

//"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    @GetMapping("/rounds/{gameID}")
    public List<Round> getListOfRoundsForGame(@PathVariable int gameID) throws NoSuchGameException{
        return service.getRoundForGameSortedByTime(gameID);
    }

}
