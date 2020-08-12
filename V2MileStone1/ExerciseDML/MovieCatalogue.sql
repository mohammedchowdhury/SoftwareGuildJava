-- This approach destroys the existing database and starts from scratch each time you run it.
-- It's good for new development, but won't work for existing
--   databases that must be altered but left intact.
DROP DATABASE IF EXISTS MovieCatalogue;

CREATE DATABASE MovieCatalogue;
-- Make sure we're in the correct database before we add schema.
USE MovieCatalogue;

CREATE TABLE IF NOT EXISTS Genre(
GenreID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
GenreName varchar(30) NOT null 
); 
-- Genre 
-- GenreID - Primary key, Identity
-- GenreName - Required, Extended character set, Length: 30

CREATE TABLE IF NOT EXISTS Director(
DirectorID INT(11) Primary key AUTO_INCREMENT,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
BirthDate DATE NULL
); 
-- Director 
-- DirectorID - Primary key, Identity
-- FirstName - Required, Extended character set, Length: 30
-- LastName - Required, Extended character set, Length: 30
-- BirthDate - Not required

CREATE TABLE IF NOT EXISTS Rating(
RatingID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, 
RatingName VARCHAR(5) NOT NULL
); 
-- Rating 
-- RatingID - Primary key, Identity
-- RatingName - Required, Standard character set, Length: 5

CREATE TABLE IF NOT EXISTS Movie(
MovieID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
GenreID INT(11) NOT NULL,
FOREIGN KEY FK_MOVIE_GENRE(GenreID) REFERENCES Genre(GenreID),
DirectorID INT(11) NULL,
FOREIGN KEY FK_MOVIE_DIRECTOR(DirectorID) REFERENCES Director(DirectorID),
RatingID INT(11) NULL,
FOREIGN KEY FK_MOVIE_RATING(RatingID) REFERENCES Rating(RatingID),
Title VARCHAR(128) NOT NULL, 
ReleaseDate DATE NULL
); 
-- Movie 
-- MovieID - Primary key, Identity
-- GenreID - Foreign key, Genre table, Required
-- DirectorID - Foreign key, Director table, Not required
-- RatingID - Foreign key, Rating table, Not required
-- Title - Required, Extended character set, Length: 128
-- ReleaseDate - Not required

CREATE TABLE IF NOT EXISTS Actor(
ActorID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
BirthDate DATE NULL
); 
-- Actor 
-- ActorID - Primary key, Identity
-- FirstName - Required, Extended character set, Length: 30
-- LastName - Required, Extended character set, Length: 30
-- BirthDate - Not required

CREATE TABLE IF NOT EXISTS CastMembers(
CastMemberID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
ActorID INT(11) NOT NULL,
FOREIGN KEY FK_CASTMEMBERS_ACTOR(ActorID) REFERENCES Actor(ActorID),
MovieID INT(11) NOT NULL,
FOREIGN KEY FK_CASTMEMBERS_MOVIE(MovieID) REFERENCES Movie(MovieID),
Role VARCHAR(50) NOT NULL
); 
-- CastMembers 
-- CastMemberID - Primary key, Identity
-- ActorID - Foreign key, Actor table, Required
-- MovieID - Foreign key, Movie table, Required
-- Role - Required, Extended character set, Length: 50

