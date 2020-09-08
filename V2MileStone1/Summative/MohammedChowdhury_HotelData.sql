use HotelSoftwareGuild; 
-- Data Entry For `RoomType`
INSERT INTO RoomType(RoomTypeID,Type,StandardOccupancy,MaximumOccupancy,Price,ExtraPerson) VALUES
(1,'Single',2,2,149.99,0),
(2,'Double',2,4,174.99,10),
(3,'Suite',3,8,399.99,20); 

-- Data Entry For `Amenities`
INSERT INTO Amenities(AmenitiesID,AmenitiesType,AmenitiesCost) VALUES
(1,'Microwave',0),
(2,'Oven',0),
(3,'Refrigerator',0),
(4,'Jacuzzi',25),
(5,'Oven',0);

-- Data Entry For `RoomNumber`
INSERT INTO RoomNumber(RoomNumberID,RoomTypeID,ADAAccessible) VALUES
(201,2,0),
(202,2,1),
(203,2,0),
(204,2,1),
(205,1,0),
(206,1,1),
(207,1,0),
(208,1,1),
(301,2,0),
(302,2,1),
(303,2,0),
(304,2,1),
(305,1,0),
(306,1,1),
(307,1,0),
(308,1,1),
(401,3,1),
(402,3,1);


-- Data Entry For `RoomAmenities`
INSERT INTO RoomAmenities(RoomNumberID,AmenitiesID) VALUES
(201,1),
(201,4),
(202,3),
(203,1),
(203,4),
(204,3),
(205,1),
(205,3),
(205,4),
(206,1),
(206,3),
(207,1),
(207,3),
(207,4),
(208,1),
(208,3),
(301,1),
(301,4),
(302,3),
(303,1),
(303,4),
(304,3),
(305,3),
(305,1),
(305,4),
(306,3),
(306,1),
(307,3),
(307,1),
(307,4),
(308,3),
(308,1),
(401,3),
(401,1),
(401,5),
(402,3),
(402,1),
(402,5); 

-- Data Entry For `Guest`
INSERT INTO Guest(GuestID,GuestFirstName,GuestLastName,Address,City,State,ZIP,Phone) VALUES
(1,'Mack','Simmer','379 Old Shore Street','Council Bluffs','IA','51501','(291) 553-0508'),
(2,'Bettyann','Seery','750 Wintergreen Dr.','Wasilla','AK','99654','(478) 277-9632'),
(3,'Duane','Cullison','9662 Foxrun Lane','Harlingen','TX','78552','(308) 494-0198'),
(4,'Karie','Yang','9378 W. Augusta Ave.','West Deptford','NJ','08096','(214) 730-0298'),
(5,'Aurore','Lipton','762 Wild Rose Street','Saginaw','MI','48601','(377) 507-0974'),
(6,'Zachery','Luechtefeld','7 Poplar Dr.','Arvada','CO','80003','(814) 485-2615'),
(7,'Jeremiah','Pendergrass','70 Oakwood St.','Zion','IL','60099','(279) 491-0960'),
(8,'Walter','Holaway','7556 Arrowhead St.','Cumberland','RI','02864','(446) 396-6785'),
(9,'Wilfred','Vise','77 West Surrey Street','Oswego','NY','13126','(834) 727-1001'),
(10,'Maritza','Tilton','939 Linda Rd.','Burke','VA','22015','(446) 351-6860'),
(11,'Joleen','Tison','87 Queen St.','Drexel Hill','PA','19026','(231) 893-2755'),
(12,'Mohammed','Chowdhury','8111 45th ave','New York','NY','11373','(917) 917-9170'); 

-- Data Entry For `Reservation`
INSERT INTO Reservation(ReservationID,StartDate,EndDate,NumberOfAdults,NumberOfChildren,TotalRoomCost,GuestID) VALUES
(1,'2023-02-02','2023-02-04',1,0,299.98,1),
(2,'2023-02-05','2023-02-10',2,1,999.95,2),
(3,'2023-02-22','2023-02-24',2,0,349.98,3),
(4,'2023-03-06','2023-03-07',2,2,199.99,4),
(5,'2023-03-17','2023-03-20',1,1,524.97,12),
(6,'2023-03-18','2023-03-23',3,0,924.95,5),
(7,'2023-03-29','2023-03-31',2,2,349.98,6),
(8,'2023-03-31','2023-04-05',2,0,874.95,7),
(9,'2023-04-09','2023-04-13',1,0,799.96,8),
(10,'2023-04-23','2023-04-24',1,1,174.99,9),
(11,'2023-05-30','2023-06-02',2,4,1199.97,10),
(12,'2023-06-10','2023-06-14',2,0,599.96,11),
(13,'2023-06-10','2023-06-14',1,0,599.96,11),
(14,'2023-06-17','2023-06-18',3,0,184.99,5),
(15,'2023-06-28','2023-07-02',2,0,699.96,12),
(16,'2023-07-13','2023-07-14',3,1,184.99,8),
(17,'2023-07-18','2023-07-21',4,2,1259.97,9),
(18,'2023-07-28','2023-07-29',2,1,199.99,2),
(19,'2023-08-30','2023-09-01',1,0,349.98,2),
(20,'2023-09-16','2023-09-17',2,0,149.99,1),
(21,'2023-09-13','2023-09-15',2,2,399.98,4),
(22,'2023-11-22','2023-11-25',2,2,1199.97,3),
(23,'2023-11-22','2023-11-25',2,0,449.97, 1),
(24,'2023-11-22','2023-11-25',2,2,599.97, 1),
(25,'2023-12-24','2023-12-28',2,0,699.96, 10); 


-- Data Entry For `RoomReservation`
INSERT INTO RoomReservation(ReservationID,RoomNumberID)  VALUES
(1,308),
(2,203),
(3,305),
(4,201),
(5,307),
(6,302),
(7,202),
(8,304),
(9,301),
(10,207),
(11,401),
(12,206),
(13,208),
(14,304),
(15,205),
(16,204),
(17,401),
(18,303),
(19,305),
(20,208),
(21,203),
(22,401),
(23,206),
(24,301),
(25,302);

-- Delete Jeremiah Pendergrass 
SET SQL_SAFE_UPDATES = 0;

-- remove data from RoomReservation
Delete FROM RoomReservation
where RoomReservation.ReservationID in
(select Reservation.ReservationID
from Guest
inner join Reservation on 
Reservation.GuestID = Guest.GuestID 
and  Guest.GuestFirstName = 'Jeremiah' and 
Guest.GuestLastName = 'Pendergrass' ); 

-- remove from Reservation
Delete FROM Reservation
where Reservation.GuestID in
(select Guest.GuestID
from Guest
where Guest.GuestFirstName = 'Jeremiah' and 
Guest.GuestLastName = 'Pendergrass' ); 

-- -- remove from Guest
Delete FROM Guest
where Guest.GuestFirstName = 'Jeremiah' and 
Guest.GuestLastName = 'Pendergrass'; 

SET SQL_SAFE_UPDATES = 1;