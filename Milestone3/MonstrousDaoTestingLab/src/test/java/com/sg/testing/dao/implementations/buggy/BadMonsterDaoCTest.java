/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing.dao.implementations.buggy;


import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import com.sg.testing.dao.MonsterDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohammedchowdhury
 */
public class BadMonsterDaoCTest {
    
     MonsterDao dao;
    
    public BadMonsterDaoCTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao = new BadMonsterDaoC();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testaddMonster() { // adding one monster test 
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);
        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        retrivedMonster = dao.getMonster(1);
        assertEquals(m1, retrivedMonster);
    }

    @Test
    public void testadd2Monster() { // adding two monster test 
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        Monster m2 = new Monster(2, "Randy", MonsterType.VAMPIRE, 9001, "Human Cookies");
        Monster retrivedMonster2 = dao.addMonster(2, m2);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        assertEquals(m1, dao.getMonster(1));

        assertNull(retrivedMonster2);
        assertEquals(m2, dao.getMonster(2));
    }

    @Test
    public void testadd3Monster() { // adding two monster with same id 
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        Monster m2 = new Monster(1, "Randy", MonsterType.VAMPIRE, 9001, "Human Cookies");
        Monster retrivedMonster2 = dao.addMonster(1, m2);

        assertNull(retrivedMonster);
        assertNotNull(retrivedMonster2);

        assertNotEquals(m1, dao.getMonster(1));

        assertEquals(m2, dao.getMonster(1));
    }

    @Test
    public void testgetAllMonsters() { // adding one monster and testing list 
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);
        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        retrivedMonster = dao.getMonster(1);
        assertEquals(m1, retrivedMonster);

        assertEquals(dao.getAllMonsters().size(), 1, "Should return 1");
        assertTrue(dao.getAllMonsters().contains(m1));
    }

    @Test
    public void testgetAllMonsters2() { // adding one monster and testing list 
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);
        //assertNotNull(retrivedMonster, "Make sure date is not null");

        Monster m2 = new Monster(2, "Randy", MonsterType.VAMPIRE, 9001, "Human Cookies");
        Monster retrivedMonster2 = dao.addMonster(2, m2);

        assertNull(retrivedMonster);
        assertNull(retrivedMonster2);

        retrivedMonster = dao.getMonster(1);
        assertEquals(m1, retrivedMonster);

        retrivedMonster = dao.getMonster(2);
        assertEquals(m2, retrivedMonster);

        assertEquals(dao.getAllMonsters().size(), 2, "Should return 1");
        assertTrue(dao.getAllMonsters().contains(m1));
        assertTrue(dao.getAllMonsters().contains(m2));
    }

    @Test
    public void testUpdateMonster() { // updating one monster
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        assertEquals(m1, dao.getMonster(1));

        m1.setFavoriteFood("Chips");
        m1.setName("Tenzin");
        m1.setPeopleEaten(122);
        m1.setType(MonsterType.WEREWOLF);

        dao.updateMonster(m1.getId(), m1);

        assertEquals(1, dao.getAllMonsters().size());
        assertTrue(dao.getAllMonsters().contains(m1));
    }

    @Test
    public void testRemoveMonster1() { // updating two monster
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        Monster m2 = new Monster(2, "Randy", MonsterType.VAMPIRE, 9001, "Human Cookies");
        Monster retrivedMonster2 = dao.addMonster(2, m2);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        assertNull(retrivedMonster2);

        assertEquals(m1, dao.getMonster(m1.getId()));
        assertEquals(m2, dao.getMonster(m2.getId()));

        m1.setFavoriteFood("PaniPuri");
        m1.setName("Tenzin");
        m1.setPeopleEaten(122);
        m1.setType(MonsterType.WEREWOLF);

        m2.setFavoriteFood("Chips");
        m2.setName("Tenzin");
        m2.setPeopleEaten(122);
        m2.setType(MonsterType.WEREWOLF);

        dao.updateMonster(m1.getId(), m1);
        dao.updateMonster(m2.getId(), m2);

        assertEquals(2, dao.getAllMonsters().size());
        assertTrue(dao.getAllMonsters().contains(m1));
        assertTrue(dao.getAllMonsters().contains(m2));
    }

    @Test
    public void testRemoveMonster() { // updating two monster
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);

        assertEquals(m1, dao.getMonster(m1.getId()));

        retrivedMonster = dao.removeMonster(m1.getId());

        assertEquals(0, dao.getAllMonsters().size());

        assertEquals(retrivedMonster, m1);

        assertFalse(dao.getAllMonsters().contains(m1));
    }

    @Test
    public void testRemoveMonster2() { // updating two monster
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        Monster m2 = new Monster(2, "Randy", MonsterType.VAMPIRE, 9001, "Human Cookies");
        Monster retrivedMonster2 = dao.addMonster(2, m2);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        assertNull(retrivedMonster2);

        retrivedMonster = dao.removeMonster(m1.getId());
        assertEquals(m1, retrivedMonster);

        retrivedMonster2 = dao.removeMonster(m2.getId());
        assertEquals(m2, retrivedMonster2);

        assertEquals(0, dao.getAllMonsters().size());
        assertFalse(dao.getAllMonsters().contains(m1));
        assertFalse(dao.getAllMonsters().contains(m2));
    }
    
    
        @Test
    public void testUpdateMonsterGetMonsterGetAllMonster() { // updating one monster
        Monster m1 = new Monster(1, "Joe", MonsterType.YETI, 10, "Chips");
        Monster retrivedMonster = dao.addMonster(1, m1);

        //assertNotNull(retrivedMonster, "Make sure date is not null");
        assertNull(retrivedMonster);
        assertEquals(m1, dao.getMonster(1));

        m1.setFavoriteFood("Chips");
        m1.setName("Tenzin");
        m1.setPeopleEaten(122);
        m1.setType(MonsterType.WEREWOLF);

        dao.updateMonster(m1.getId(), m1);

        assertEquals(1, dao.getAllMonsters().size());
        assertTrue(dao.getAllMonsters().contains(m1));
        
        retrivedMonster = dao.getMonster(m1.getId()); 
        
        assertEquals(retrivedMonster, m1);
    }
    
}
