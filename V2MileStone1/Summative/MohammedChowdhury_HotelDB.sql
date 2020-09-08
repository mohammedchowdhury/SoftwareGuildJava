DROP DATABASE IF EXISTS HotelSoftwareGuild;
CREATE DATABASE HotelSoftwareGuild;
USE HotelSoftwareGuild;

-- Table structure for table `RoomType`
CREATE TABLE RoomType(
	RoomTypeID TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Type VARCHAR(10) NOT NULL,
	StandardOccupancy TINYINT UNSIGNED NOT NULL,
    MaximumOccupancy TINYINT UNSIGNED NOT NULL,
    Price DECIMAL(6,2) NOT NULL,
    ExtraPerson DECIMAL(4,2) NOT NULL
);

-- Table structure for table `Amenities`
CREATE TABLE Amenities(
	AmenitiesID SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,
	AmenitiesType VARCHAR(15) NOT NULL,
    AmenitiesCost DECIMAL(4,2) NOT NULL
);

-- Table structure for table `RoomNumber`
CREATE TABLE RoomNumber(
	RoomNumberID SMALLINT UNSIGNED NOT NULL PRIMARY KEY,
	RoomTypeID TINYINT UNSIGNED NOT NULL,
    ADAAccessible bit NOT NULL,
    FOREIGN KEY fk_RoomNumber_RoomType(RoomTypeID) REFERENCES RoomType(RoomTypeID)
);


-- Table structure for table `RoomAmenities`
CREATE TABLE RoomAmenities(
	RoomNumberID SMALLINT UNSIGNED NOT NULL,
    AmenitiesID SMALLINT UNSIGNED NOT NULL,
	PRIMARY KEY pk_RoomNumberAmenities (RoomNumberID, AmenitiesID),
	FOREIGN KEY fk_RoomAmenities_RoomNumber (RoomNumberID) REFERENCES RoomNumber(RoomNumberID),
    FOREIGN KEY fk_RoomAmenities_Amenities (AmenitiesID) REFERENCES Amenities(AmenitiesID)
);

-- Table structure for table `Guest`
CREATE TABLE Guest(
	GuestID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	GuestFirstName VARCHAR(30) NOT NULL,
    GuestLastName VARCHAR(30) NOT NULL,
	Address VARCHAR(100) NOT NULL,
	City VARCHAR(30) NOT NULL,
	State CHAR(2) NOT NULL,
	ZIP CHAR(5) NOT NULL,
    Phone VARCHAR(20) NOT NULL
);

-- Table structure for table `Reservation`
CREATE TABLE Reservation(
	ReservationID int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StartDate DATE NOT NULL, 
	EndDate DATE NOT NULL, 
	NumberOfAdults TINYINT NOT NULL,
	NumberOfChildren TINYINT NOT NULL,
    TotalRoomCost DECIMAL(8,2) NOT NULL,
    GuestID int UNSIGNED NOT NULL, 
    FOREIGN KEY fk_Reservation_Guest(GuestID) REFERENCES Guest(GuestID)
);

-- Table structure for table `RoomReservation`
CREATE TABLE RoomReservation(
	ReservationID int UNSIGNED NOT NULL, 
	RoomNumberID SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY pk_ReservationRoomNumber(ReservationID,RoomNumberID),
	FOREIGN KEY fk_RoomReservation_Reservation (ReservationID) REFERENCES Reservation(ReservationID),
    FOREIGN KEY fk_RoomReservation_RoomNumber (RoomNumberID) REFERENCES RoomNumber(RoomNumberID)
);
