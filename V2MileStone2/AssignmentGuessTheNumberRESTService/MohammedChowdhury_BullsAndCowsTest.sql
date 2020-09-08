DROP DATABASE IF EXISTS BullsAndCowsTest;
CREATE DATABASE BullsAndCowsTest;
USE BullsAndCowsTest;

-- Table structure for table `Game`
CREATE TABLE `Game`(
	`GameID` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`FourDigitNumber` CHAR(4) NOT NULL,
	`StatusOfGame` bit NOT NULL
);

-- Table structure for table `Round`
CREATE TABLE `Round`(
	`RoundID` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Answer` CHAR(4) NOT NULL,
	`Result` char(10) NOT NULL,
    `TimeOfGuess` DATETIME NOT NULL, 
	`GameID` INT UNSIGNED NOT NULL,
    FOREIGN KEY `fk_Round_Game`(`GameID`) REFERENCES `Game`(`GameID`)
);

