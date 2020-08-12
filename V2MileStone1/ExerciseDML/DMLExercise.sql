use MovieCatalogue;
SET SQL_SAFE_UPDATES = 0;


-- adding Actor data
insert into Actor(ActorID,FirstName,LastName,BirthDate) values
(1,'Bill','Murray','1950/9/21'),
(2,'Dan','Aykroyd','1952/7/1'),
(3,'John','Candy','1950/10/31'),
(4,'Steve','Martin',NULL),
(5,'Sylvester','Stallone',NULL);
select *
from Actor; 


-- adding Director data
INSERT INTO Director (DirectorID,FirstName, LastName, BirthDate)VALUES 
(1,'Ivan', 'Reitman', '1946/10/27'),
(2,'Ted', 'Kotcheff', NULL);
select *
from Director; 

-- adding Rating data
insert into Rating (RatingID,RatingName) values
(1,'G'),
(2,'PG'),
(3,'PG-13'),
(4,'R');
select *
from Rating; 

-- adding Genre data
insert into Genre (GenreID,GenreName) values
(1,'Action'),
(2,'Comedy'),
(3,'Drama'),
(4,'Horror');
select *
from Genre; 

-- adding Movie data
insert into Movie(MovieID,GenreID,DirectorID,RatingID,Title,ReleaseDate) values
(1,1,2,4,'Rambo: First Blood','1982/10/22'),
(2,2,NULL,4,'Planes, Trains & Automobiles','1987/11/25'),
(3,2,1,2,'Ghostbusters',NULL),
(4,2,NULL,2,'The Great Outdoors','1988/6/17');
select *
from Movie; 

-- adding CastMember data
insert into CastMembers(CastMemberID,ActorID,MovieID,`Role`) values
(1,5,1,'John Rambo'),
(2,4,2,'Neil Page'),
(3,3,2,'Del Griffith'),
(4,1,3,'Dr. Peter Venkman'),
(5,2,3,'Dr. Raymond Stanz'),
(6,2,4,'Roman Craig'),
(7,3,4,'Chet Ripley');
select *
from CastMembers; 

-- Update Queries
-- Please write UPDATE queries:
-- Change the title of Ghostbusters to Ghostbusters (1984) and the release date to 6/8/1984.
-- Change the Action genre to Action/Adventure.

update Movie
set Title = 'Ghostbusters (1984)',
ReleaseDate = '1984/6/8'
WHERE MovieID = 3; 

update Genre
set GenreName = 'Action/Adventure'
where GenreName = 'Action'; 

-- Delete Queries
-- Delete the movie Rambo: First Blood.
Delete from CastMembers where MovieID = 1;
Delete from Movie where MovieID = 1;

-- Altering Tables
-- Alter the Actor table to add a column DateOfDeath. Set John Candy's record to be 3/4/1994.
Alter table Actor add DateOfDeath date null; 
update Actor 
set  DateOfDeath = '1994/3/4'
where FirstName = 'John' and
LastName =  'Candy';

SET SQL_SAFE_UPDATES = 1; 