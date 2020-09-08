use HotelSoftwareGuild; 

-- 1.Write a query that returns a list of reservations that end in July 2023, 
-- including the name of the guest, the room number(s), and the reservation dates.
-- 4 Rows are found 
-- -------------------
select Guest.GuestFirstName,Guest.GuestLastName,RoomReservation.RoomNumberID,Reservation.StartDate,Reservation.EndDate
from Guest
inner join Reservation on Reservation.GuestID = Guest.GuestID
inner join RoomReservation on Reservation.ReservationID = RoomReservation.ReservationID
where EndDate between '2023-07-01'and'2023-07-31'; 

-- 2.Write a query that returns a list of all reservations for rooms with a jacuzzi,
-- displaying the guest's name, the room number, and the dates of the reservation.
-- 11 Rows are found 
-- -------------------
select Guest.GuestFirstName,Guest.GuestLastName,RoomReservation.RoomNumberID,Reservation.StartDate,Reservation.EndDate
from Amenities
inner join RoomAmenities on Amenities.AmenitiesID = RoomAmenities.AmenitiesID and Amenities.AmenitiesType = 'jacuzzi'
inner join RoomNumber on RoomAmenities.RoomNumberID = RoomNumber.RoomNumberID
inner join RoomReservation on RoomNumber.RoomNumberID = RoomReservation.RoomNumberID 
inner join Reservation on RoomReservation.ReservationID = Reservation.ReservationID 
inner join Guest on Reservation.GuestID = Guest.GuestID; 

-- RoomAmenities.AmenitiesID = 
-- (select AmenitiesID
-- from Amenities
-- where AmenitiesType = 'jacuzzi'); 
-- 3.Write a query that returns all the rooms reserved for a specific guest, 
-- including the guest's name, the room(s) reserved, the starting date of the reservation, 
-- and how many people were included in the reservation. (Choose a guest's name from the existing data.)
-- Mohammed Chowdhury
-- 2 Rows returned 
-- -------------------
select Guest.GuestFirstName,Guest.GuestLastName,RoomReservation.RoomNumberID,Reservation.StartDate, (SUM(Reservation.NumberOfAdults+Reservation.NumberOfChildren)) as 'TotalGuest'
from Guest
inner join Reservation on Guest.GuestID = Reservation.GuestID 
inner join RoomReservation on Reservation.ReservationID = RoomReservation.ReservationID
where Guest.GuestFirstName = 'Mohammed' and 
Guest.GuestLastName = 'Chowdhury'
GROUP BY Guest.GuestFirstName,Guest.GuestLastName,RoomReservation.RoomNumberID,Reservation.StartDate; 

-- 4.Write a query that returns a list of rooms, reservation ID, 
-- and per-room cost for each reservation. The results should include all rooms, 
-- whether or not there is a reservation associated with the room.
-- 26 Rows returned, 2 Rooms were never reserved 
-- -------------------
select RoomNumber.RoomNumberID,Reservation.ReservationID, Reservation.TotalRoomCost
from RoomNumber
-- left outer join RoomType on RoomType.RoomTypeID = RoomNumber.RoomTypeID 
left outer join RoomReservation on RoomReservation.RoomNumberID = RoomNumber.RoomNumberID 
left outer join Reservation on RoomReservation.ReservationID = Reservation.ReservationID
order by RoomReservation.ReservationID; 

-- 5.Write a query that returns all the rooms accommodating at least three guests 
-- and that are reserved on any date in April 2023.
-- 0 Rows Returned
-- -------------------
select Reservation.ReservationID, Reservation.StartDate,Reservation.EndDate,RoomReservation.RoomNumberID,sum(Reservation.NumberOfAdults+Reservation.NumberOfChildren) 'TotalGuests'
from Reservation
inner join RoomReservation on Reservation.ReservationID = RoomReservation.ReservationID 
where 
(Reservation.EndDate between '2023-04-01'and'2023-04-30' or 
Reservation.StartDate between '2023-04-01'and'2023-04-30') AND
Reservation.NumberOfAdults+Reservation.NumberOfChildren>2
group by Reservation.ReservationID, Reservation.StartDate,Reservation.EndDate,RoomReservation.RoomNumberID; 
-- 6.Write a query that returns a list of all guest names and the number of reservations per guest, 
-- sorted starting with the guest with the most reservations and then by the guest's last name.
-- 11 Rows Returned
-- -------------------
select Guest.GuestFirstName,Guest.GuestLastName, count(Reservation.ReservationID) as 'TotalReservation'
from Guest
left outer join Reservation on Guest.GuestID = Reservation.GuestID
group BY Guest.GuestFirstName,Guest.GuestLastName
order by TotalReservation DESC,Guest.GuestLastName ASC ; 

-- 7.Write a query that displays the name, address, 
-- and phone number of a guest based on their phone number. 
-- (Choose a phone number from the existing data.)
-- (917) 917-9170
-- 1 Row returned
-- -------------------
select Guest.GuestFirstName,Guest.GuestLastName,Guest.Address,Guest.Phone
from Guest
where Guest.Phone = '(917) 917-9170'; 