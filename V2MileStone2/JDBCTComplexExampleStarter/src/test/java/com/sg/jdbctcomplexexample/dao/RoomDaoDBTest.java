package com.sg.jdbctcomplexexample.dao;
import com.sg.jdbctcomplexexample.TestApplicationConfiguration;
import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
public class RoomDaoDBTest {

    @Autowired
    RoomDao roomDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    MeetingDao meetingDao;

    public RoomDaoDBTest() {
    }

    @Before
    public void setUp() {
        List<Room> rooms = roomDao.getAllRooms();
        for (Room room : rooms) {
            roomDao.deleteRoomById(room.getId());
        }

        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }

        List<Meeting> meetings = meetingDao.getAllMeetings();
        for (Meeting meeting : meetings) {
            meetingDao.deleteMeetingById(meeting.getId());
        }
    }

    @Test
    public void testAddGetRoom() {
        //arrange
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        //act
        room = roomDao.addRoom(room);
        Room fromDao = roomDao.getRoomById(room.getId());
        //assert
        assertEquals(room, fromDao);
    }

    @Test
    public void testGetAllRooms() {
        //arrange
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");

        Room room2 = new Room();
        room2.setName("Test Room 2");
        room2.setDescription("Test Room 2");
        //act
        roomDao.addRoom(room);
        roomDao.addRoom(room2);
        List<Room> rooms = roomDao.getAllRooms();
        //assert
        assertEquals(2, rooms.size());
        assertTrue(rooms.contains(room));
        assertTrue(rooms.contains(room2));
    }

    @Test
    public void testUpdateRoom() {
        //arrange 
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        //act 
        room = roomDao.addRoom(room);
        Room fromDao = roomDao.getRoomById(room.getId());

        //assert
        assertEquals(room, fromDao);

        //act
        room.setName("Another Test Room");

        //act
        roomDao.updateRoom(room);

        //assert
        assertNotEquals(room, fromDao);
        //act
        fromDao = roomDao.getRoomById(room.getId());

        assertEquals(room, fromDao);
    }
    
     @Test
    public void testDeleteRoom() {
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now());
        meeting.setRoom(room);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        roomDao.deleteRoomById(room.getId());
        
        Room fromDao = roomDao.getRoomById(room.getId());
        assertNull(fromDao);
    }

}
