package com.mohammedchowdhury.bullsandcows.service;

import com.mohammedchowdhury.bullsandcows.TestApplicationConfiguration;
import com.mohammedchowdhury.bullsandcows.dao.GameDao;
import com.mohammedchowdhury.bullsandcows.dto.Game;
import com.mohammedchowdhury.bullsandcows.dto.Round;
import java.util.HashSet;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
public class ServiceTest {

    @Autowired
    Service service;

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
    public void startGameTest() throws NoSuchGameException {
        //arange 
        Game game;
        //act
        game = service.startGame();
        //assert
        assertNotNull(game.getGameID());
        assertNotNull(game.getRandomNumber());
        assertNotNull(game.getStatus());
    }

    @Test
    public void startGameTestDuplicate() throws NoSuchGameException {
        //arange 
        Game game;
        HashSet<Character> set = new HashSet<Character>();
        //act
        game = service.startGame();
        //assert
        for (int i = 0; i < game.getRandomNumber().length(); i++) {
            char temp = game.getRandomNumber().charAt(i);
            if (!set.contains(temp)) {
                set.add(temp);
            } else {
                fail("Duplicate digits found");
            }
        }
    }

    @Test
    public void startGameTestNonNumberAndLength() throws NoSuchGameException {
        //arange 
        Game game;
        //act
        game = service.startGame();
        //assert
        if (game.getRandomNumber().length() != 4) {
            fail("Generated number is less then or greater then 4 digit");
        }

        for (int i = 0; i < game.getRandomNumber().length(); i++) {
            char temp = game.getRandomNumber().charAt(i);
            if (!Character.isDigit(temp)) {
                fail("Non Digit found");
            }
        }
    }

    @Test
    public void startGameTest2() throws NoSuchGameException {
        //arange 
        Game game;
        Game game2;
        //act
        game = service.startGame();
        game2 = service.startGame();
        //assert
        assertNotNull(game.getGameID());
        assertNotNull(game.getRandomNumber());
        assertNotNull(game.getStatus());

        assertNotNull(game2.getGameID());
        assertNotNull(game2.getRandomNumber());
        assertNotNull(game2.getStatus());

        assertEquals(game.getGameID() + 1, game2.getGameID());
    }

    @Test
    public void guessTest() throws NoSuchGameException, InvalidUserInput {
        //arrange 
        Game game = new Game("1234");
        game = gameDao.addNewGame(game);

        Round round = new Round("1234", game.getGameID());
        //act
        round = service.guess(round);
        //assert
        assertEquals(round.getResult(), "e:4:p:0");

    }

    @Test
    public void guessTest2() throws NoSuchGameException, InvalidUserInput {
        //arrange 
        Game game = new Game("1234");
        game = gameDao.addNewGame(game);

        Round round = new Round("1064", game.getGameID());
        //act
        round = service.guess(round);
        //assert
        assertEquals(round.getResult(), "e:2:p:0");
    }

    @Test
    public void guessTestInvalidUserInput() throws NoSuchGameException, InvalidUserInput {
        //arrange 
        Game game = new Game("1245");
        game = gameDao.addNewGame(game);
        Round round = new Round("1224", game.getGameID());
        //act
        try {
            round = service.guess(round);
            fail("Duplicate digits found");
        } catch (InvalidUserInput ex) {
            //assert
            assertTrue(true);
        }
    }

    @Test
    public void guessTestInvalidUserInput2() throws NoSuchGameException, InvalidUserInput {
        //arrange 
        Game game = new Game("1245");
        game = gameDao.addNewGame(game);
        Round round = new Round("123A", game.getGameID());
        //act
        try {
            round = service.guess(round);
            fail("NonDigit Input");
        } catch (InvalidUserInput ex) {
            //assert
            assertTrue(true);
        }
    }

    @Test
    public void guessTestInvalidUserInput3() throws NoSuchGameException, InvalidUserInput {
        //arrange 
        Game game = new Game("1245");
        game = gameDao.addNewGame(game);
        Round round = new Round("12345", game.getGameID());
        //act
        try {
            round = service.guess(round);
            fail("Expected More than 4 digit number fail");
        } catch (InvalidUserInput ex) {
            //assert
            assertTrue(true);
        }
    }

    @Test
    public void getAllGamesTest() throws NoSuchGameException {
        //arrange 
        Game game1 = new Game("1234");
        Game game2 = new Game("5678");
        //act
        game1 = gameDao.addNewGame(game1);
        game2 = gameDao.addNewGame(game2);
        List<Game> listOfGames = service.getAllGames();
        //assert
        assertTrue(listOfGames.contains(game1));
        assertTrue(listOfGames.contains(game2));

    }

    @Test
    public void getAllGamesTestNoGamesFoundException() throws NoSuchGameException {
        try {
            List<Game> listOfGames = service.getAllGames();
            fail("Expected exceptions for no games");
        } catch (NoSuchGameException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void getGameByIdTest() {
        //arrange
        Game g1 = new Game("1234");
        //act
        g1 = gameDao.addNewGame(g1);
        Game g1Test = gameDao.getGameById(g1.getGameID());
        //assert
        assertEquals(g1Test, g1);
    }

    @Test
    public void getGameByIdTestNoSuchGameException() {
        try {
            Game g1Test = service.getGameById(1);
            fail("Expected a NoSuchGameException, No game was added");
        } catch (NoSuchGameException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void getRoundForGameSortedByTimeTest() throws NoSuchGameException, InvalidUserInput {
        //arrange
        Game g1 = new Game("1234");
        Game g2 = new Game("5678");
        //act
        g1 = gameDao.addNewGame(g1);
        g2 = gameDao.addNewGame(g2);

        Round r1g1 = new Round("1230", g1.getGameID());
        r1g1 = service.guess(r1g1);

        Round r2g1 = new Round("1930", g1.getGameID());
        r2g1 = service.guess(r2g1);

        Round r3g1 = new Round("1730", g1.getGameID());
        r3g1 = service.guess(r3g1);

        Round r4g2 = new Round("1230", g2.getGameID());
        r4g2 = service.guess(r4g2);

        Round r5g2 = new Round("1930", "e:2:p:0", g2.getGameID());
        r5g2 = service.guess(r5g2);

        Round r6g2 = new Round("1730", g2.getGameID());
        r6g2 = service.guess(r6g2);

        List<Round> listOfRound = service.getRoundForGameSortedByTime(g1.getGameID());
        //assert
        assertEquals(r1g1, listOfRound.get(0));
        assertEquals(r2g1, listOfRound.get(1));
        assertEquals(r3g1, listOfRound.get(2));

    }

    @Test
    public void getRoundForGameSortedByTimeTestNoSuchGameException() {
        try {
            List<Round> listOfRound = service.getRoundForGameSortedByTime(1);
            fail("Expected a no such game found exception");
        } catch (NoSuchGameException ex) {
            assertTrue(true);
        }

    }

}
