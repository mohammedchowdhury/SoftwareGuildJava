/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammedchowdhury.bullsandcows.dao;

import com.mohammedchowdhury.bullsandcows.dto.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mohammedchowdhury
 */
@Repository
public class GameDaoImpl implements GameDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Game addNewGame(Game newGame) {
        final String sql = "INSERT INTO Game(FourDigitNumber,StatusOfGame) "
                + "VALUES(?,?);";
        jdbcTemplate.update(sql, newGame.getRandomNumber(), newGame.getStatus());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newGame.setGameID(newId);
        return newGame;
    }

    @Override
    public Game getGameById(int gameID) {
        final String sql = "SELECT * "
                + "FROM Game "
                + "WHERE GameID = ?;";

        String a = "aa";
        try {
            return jdbcTemplate.queryForObject(sql, new GameMapper(), gameID);
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public void updateGame(Game game) {
        final String sql = "UPDATE GAME "
                + "SET StatusOfGame = ? "
                + "WHERE GameID = ?;";
        jdbcTemplate.update(sql, game.getStatus(), game.getGameID());
    }

    @Override
    public List<Game> getListOfGames() {
        final String sql = "SELECT * "
                + "FROM Game;";
        List<Game> listOfGames = jdbcTemplate.query(sql, new GameMapper());
        return listOfGames;
    }

    @Override
    @Transactional
    public void deleteGameByID(int GameID) {
        final String sql = "DELETE FROM Round "
                + "WHERE GameID = ?";
        jdbcTemplate.update(sql, GameID);

        final String sql2 = "DELETE FROM Game "
                + "WHERE GameID = ?";
        jdbcTemplate.update(sql2, GameID);
    }

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game(rs.getInt("GameID"), rs.getString("FourDigitNumber"), rs.getBoolean("StatusOfGame"));
            return game;
        }
    }
}
