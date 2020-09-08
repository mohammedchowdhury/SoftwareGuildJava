package com.mohammedchowdhury.bullsandcows.dao;

import com.mohammedchowdhury.bullsandcows.TestApplicationConfiguration;
import com.mohammedchowdhury.bullsandcows.dto.Game;
import com.mohammedchowdhury.bullsandcows.dto.Round;
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
public class RoundDaoImplTest {

    @Autowired
    RoundDao roundDao;

    @Autowired
    GameDao gameDao;

//    @Before
//    public void setUp() {
//        List<Game> listOfGames = gameDao.getListOfGames();
//        for (Game game : listOfGames) {
//            gameDao.deleteGameByID(game.getGameID());
//        }
//    }

//    @After
//    public void setUp2() {
//        List<Game> listOfGames = gameDao.getListOfGames();
//        for (Game game : listOfGames) {
//            gameDao.deleteGameByID(game.getGameID());
//        }
//    }

    @Test
    public void addRoundTest() {
        //arrange
        Game game = new Game("1234");
        game = gameDao.addNewGame(game);
        //act 
        Round round = new Round("1264", "e:3:p:0", game.getGameID());
        round = roundDao.addRound(round);
        Round roundTest = new Round(round.getRoundID(), "1264", "e:3:p:0", round.getTimeOfGuess(), game.getGameID());
        //assert
        assertEquals(roundTest, round);
    }

    @Test
    public void getRoundForGameSortedByTimeTest() {
        //arrange
        Game g1 = new Game("1234");
        Game g2 = new Game("5678");
        //act
        g1 = gameDao.addNewGame(g1);
        g2 = gameDao.addNewGame(g2);

        Round r1g1 = new Round("1230", "e:3:p:0", g1.getGameID());
        r1g1 = roundDao.addRound(r1g1);
        Round r2g1 = new Round("1930", "e:2:p:0", g1.getGameID());
        r2g1 = roundDao.addRound(r2g1);
        Round r3g1 = new Round("1730", "e:2:p:0", g1.getGameID());
        r3g1 = roundDao.addRound(r3g1);

        List<Round> listOfRound = roundDao.getRoundForGameSortedByTime(g1.getGameID());
        //assert
        assertEquals(r1g1, listOfRound.get(0));
        assertEquals(r2g1, listOfRound.get(1));
        assertEquals(r3g1, listOfRound.get(2));

    }

    @Test
    public void getRoundForGameSortedByTimeTest2() {
        //arrange
        Game g1 = new Game("1234");
        Game g2 = new Game("5678");
        //act
        g1 = gameDao.addNewGame(g1);
        g2 = gameDao.addNewGame(g2);

        Round r1g1 = new Round("1230", "e:3:p:0", g1.getGameID());
        r1g1 = roundDao.addRound(r1g1);
        
        Round r2g1 = new Round("1930", "e:2:p:0", g1.getGameID());
        r2g1 = roundDao.addRound(r2g1);
        
        Round r3g1 = new Round("1730", "e:2:p:0", g1.getGameID());
        r3g1 = roundDao.addRound(r3g1);

        Round r4g2 = new Round("1230", "e:3:p:0", g2.getGameID());
        r4g2 = roundDao.addRound(r4g2);
        
        Round r5g2 = new Round("1930", "e:2:p:0", g2.getGameID());
        r5g2 = roundDao.addRound(r5g2);
        
        Round r6g2 = new Round("1730", "e:2:p:0", g2.getGameID());
        r6g2 = roundDao.addRound(r6g2);

        List<Round> listOfRound = roundDao.getRoundForGameSortedByTime(g1.getGameID());
        //assert
        assertEquals(r1g1, listOfRound.get(0));
        assertEquals(r2g1, listOfRound.get(1));
        assertEquals(r3g1, listOfRound.get(2));

    }
    
    @Test
    public void getRoundForGameSortedByTimeTest2ss() {
        List<Round> list = roundDao.getRoundForGameSortedByTime(999); 
       
        
    }

}
