/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.service;

import com.mohammedchowdhury.bullsandcows.dao.GameDao;
import com.mohammedchowdhury.bullsandcows.dao.RoundDao;
import com.mohammedchowdhury.bullsandcows.dto.Game;
import com.mohammedchowdhury.bullsandcows.dto.Round;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohammedchowdhury
 */
@Component
public class ServiceImpl implements Service {

    @Autowired
    GameDao gameDao;

    @Autowired
    RoundDao roundDao;

    //"begin" - POST – Starts a game, generates an answer, and sets the correct status. 
    //Should return a 201 CREATED message as well as the created gameId.
    @Override
    public Game startGame() throws NoSuchGameException {
        Game newGame = new Game(generateRandomNumber());
        newGame = gameDao.addNewGame(newGame);
        if (newGame == null) {
            throw new NoSuchGameException("Failed to create new game.");
        }
        return newGame;
    }

    //"guess" – POST – Makes a guess by passing the guess and gameId in as JSON.
    //The program must calculate the results of the guess and mark the game finished if the guess is correct. 
    //It returns the Round object with the results filled in.
    @Override
    public Round guess(Round round) throws NoSuchGameException, InvalidUserInput {
        validateInputNumber(round.getAnswer());
        Game playingGame = getGameById(round.getGameID());
//        Game playingGame = gameDao.getGameById(round.getGameID());
//        if (playingGame == null) {
//            throw new NoSuchGameException("No Game found for Game ID :" + round.getGameID());
//        }
        if (playingGame.getStatus() == false) {
            throw new NoSuchGameException("Game ID :" + playingGame.getGameID() + " has finished, please start a new game");
        }
        String[] result = gameLogic(round.getAnswer(), playingGame.getRandomNumber());
        round.setResult(result[0]);
        if (result[1].equals("4")) {
            playingGame.endGame();
            gameDao.updateGame(playingGame);
        }
        round = roundDao.addRound(round);
        return round;
    }

    //"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
    @Override
    public List<Game> getAllGames() throws NoSuchGameException {
        List<Game> games = gameDao.getListOfGames();
        if (games.size() == 0) {
            throw new NoSuchGameException("No Games were created");
        }
        return games;
    }

    //"game/{gameId}" - GET – Returns a specific game based on ID. Be sure in-progress games 
    //do not display their answer.
    @Override
    public Game getGameById(int gameID) throws NoSuchGameException {
        Game getGame = gameDao.getGameById(gameID);
        if (getGame == null) {
            throw new NoSuchGameException("No Game found for Game ID : " + gameID);
        }
        return getGame;
    }

    //"rounds/{gameId} – GET – Returns a list of rounds for the specified game sorted by time.
    @Override
    public List<Round> getRoundForGameSortedByTime(int gameID) throws NoSuchGameException {
        Game game = getGameById(gameID);
        List<Round> rounds = roundDao.getRoundForGameSortedByTime(game.getGameID());
        if (rounds.size() == 0) {
            throw new NoSuchGameException("This game has 0 rounds. It was not played yet");
        }
        return rounds;
    }

    private String generateRandomNumber() {
        String number = "";
        HashSet<Integer> set = new HashSet<Integer>();
        Random rand = new Random();
        while (set.size() != 4) {
            int num = rand.nextInt(10);
            if (!set.contains(num)) {
                set.add(num);
                number = number + num;
            }
        }
        return number;
    }

    private String[] gameLogic(String guess, String randomNumber) {
        HashSet<Character> set = new HashSet<Character>();
        int exactMatch = 0, partialMatch = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == randomNumber.charAt(i)) {
                exactMatch++;
            } else {
                set.add(randomNumber.charAt(i));
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (set.contains(guess.charAt(i))) {
                partialMatch++;
            }
        }
        String[] arr = new String[2];
        arr[0] = "e:" + exactMatch + ":p:" + partialMatch;
        arr[1] = exactMatch + "";
        return arr;
    }

    private boolean validateInputNumber(String number) throws InvalidUserInput {
        if (number.length() != 4) {
            throw new InvalidUserInput("Please enter a 4 digit number");
        }
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < number.length(); i++) {
            char temp = number.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new InvalidUserInput("Please enter a 4 digit number, " + temp + " is not a number");
            } else if (set.contains(temp)) {
                throw new InvalidUserInput("Please enter a 4 digit non-repeating number, " + temp + " is repeating");
            } else {
                set.add(temp);
            }
        }
        if (set.size() == 4) {
            return true;
        } else {
            throw new InvalidUserInput("Invalid number input for" + number);
        }
    }


}
