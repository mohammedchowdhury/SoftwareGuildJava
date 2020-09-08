package com.mohammedchowdhury.bullsandcows.dao;

import com.mohammedchowdhury.bullsandcows.TestApplicationConfiguration;
import com.mohammedchowdhury.bullsandcows.dto.Game;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author mohammedchowdhury
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoImplTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() {
        List<Game> listOfGames = gameDao.getListOfGames();
        for (Game game : listOfGames) {
            gameDao.deleteGameByID(game.getGameID());
        }
    }

    @After
    public void setUp2() {
        List<Game> listOfGames = gameDao.getListOfGames();

        for (Game game : listOfGames) {
            gameDao.deleteGameByID(game.getGameID());
        }
    }

    @Test
    public void testAddGame() {
        //arrange 
        Game ng = new Game("1234");
        //act
        ng = gameDao.addNewGame(ng);
        Game game = gameDao.getGameById(ng.getGameID());
        //assert
        assertEquals(ng, game);
    }

    @Test
    public void testGetGameByID() {
        //arrange 
        Game ng = new Game("1234");
        //act
        ng = gameDao.addNewGame(ng);
        Game game = gameDao.getGameById(ng.getGameID());

        //assert
        assertEquals(ng, game);
    }

    @Test
    public void getAllGames() {
        //arrange
        List<Game> listOfGames = gameDao.getListOfGames();
        //act
        int size = 0;
        //
        assertEquals(size, listOfGames.size());
    }

    @Test
    public void getAllGamesSize2() {
        //arrange
        Game ng = new Game("1234");
        Game ng2 = new Game("5438");
        //act
        int size = 2;
        gameDao.addNewGame(ng);
        gameDao.addNewGame(ng2);
        List<Game> listOfGames = gameDao.getListOfGames();
        //
        assertEquals(size, listOfGames.size());
    }

    @Test
    public void updateGameTest() {
        //arrange
        Game ng = new Game("1234");
        ng = gameDao.addNewGame(ng);
        ng.endGame();
        //ACT
        gameDao.updateGame(ng);
        ng = gameDao.getGameById(ng.getGameID()); 
        Game ng2 = new Game(ng.getGameID(), "1234", false);
        //ASSERT
        assertEquals(ng, ng2);

    }
    

    

}
