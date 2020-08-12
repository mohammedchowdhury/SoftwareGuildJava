USE PersonalTrainer;

-- Select all rows and columns from the Exercise table.
-- 64 rows
--------------------
SELECT *
FROM Exercise;

-- Select all rows and columns from the Client table.
-- 500 rows
--------------------
select *
from Client;

-- Select all columns from Client where the City is Metairie.
-- 29 rows
--------------------
select *
from Client
where city = 'Metairie';

-- Is there a Client with the ClientId '818u7faf-7b4b-48a2-bf12-7a26c92de20c'?
-- nope
--------------------
select *
from Client 
where ClientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';

-- How many rows in the Goal table?
-- 17 rows
--------------------
select *
from Goal; 


-- Select Name and LevelId from the Workout table.
-- 26 rows
--------------------
select w.Name, w.LevelId
from Workout w; 

-- Select Name, LevelId, and Notes from Workout where LevelId is 2.
-- 11 rows
--------------------
select w.Name, w.LevelId
from Workout w
where w.LevelId = 2; 

-- Select FirstName, LastName, and City from Client 
-- where City is Metairie, Kenner, or Gretna.
-- 77 rows
--------------------
select c.FirstName ,c.LastName, c.City
from Client c
where city in ('Metairie','Kenner','Gretn'); 

-- Select FirstName, LastName, and BirthDate from Client
-- for Clients born in the 1980s.
-- 72 rows
--------------------
Select c.FirstName, c.LastName, c.BirthDate
from Client c
where c.BirthDate >='1980-01-01' and 
c.BirthDate <'1990-01-01';


-- Write the query above in a different way. 
-- If you used BETWEEN, you can't use it again.
-- If you didn't use BETWEEN, use it!
-- Still 72 rows
--------------------
Select c.FirstName, c.LastName, c.BirthDate
from Client c
where c.BirthDate between '1980-01-01' and '1990-01-01';

-- How many rows in the Login table have a .gov EmailAddress?
-- 17 rows this is wrong 
--------------------
select *
from Login l
where l.EmailAddress like '%.gov%'  ; 


-- How many Logins do NOT have a .com EmailAddress?
-- 122 rows
--------------------
select *
from Login l
where l.EmailAddress not like '%.com'; 


-- Select first and last name of Clients without a BirthDate.
-- 37 rows
--------------------
select *
from Client c
where c.BirthDate is null; 

-- Select the Name of each ExerciseCategory that has a parent.
-- (ParentCategoryId value is not null)
-- 12 rows
--------------------
select e.Name
from ExerciseCategory e
where ParentCategoryId is not null; 


-- Select Name and Notes of each level 3 Workout that
-- contains the word 'you' in its Notes.
-- 4 rows
--------------------
select w.Name,w.Notes
from Workout w
where w.LevelId =3 and 
w.Notes like '%you%'; 


-- Select FirstName, LastName, City from Clients who have a LastName
-- that starts with L,M, or N and who live in LaPlace.
-- 5 rows
--------------------
select FirstName , LastName , City
from Client c
where 
c.City = 'LaPlace' and 
(c.LastName like 'L%' or 
c.LastName like 'M%' or 
c.LastName like 'N%') ; 


-- Select InvoiceId, Description, Price, Quantity, ServiceDate 
-- and the line item total, a calculated value, where the line item total
-- is between 15 and 25 dollars.
-- 667 rows
--------------------
SELECT InvoiceId,Description,Price,Quantity,Price * Quantity Total, ServiceDate
FROM InvoiceLineItem
WHERE 
Price * Quantity BETWEEN 15.0 AND 25.00;



-- Does the Client, Estrella Bazely, have a Login? 
-- If so, what is her email address?
-- This requires two queries:
-- First, select a Client record for Estrella Bazely. Does it exist?
-- Second, if it does, select a Login record that matches its ClientId.
--------------------


select EmailAddress
from Login
where ClientId = 
(select c.ClientId
from Client c
where 
c.FirstName = 'Estrella' and 
c.LastName = 'Bazely');

-- What are the Goals of the Workout with the Name 'This Is Parkour'?
-- You need three queries!:
-- 1. Select the WorkoutId from Workout where Name equals 'This Is Parkour'.
-- 2. Select GoalId from WorkoutGoal where the WorkoutId matches the WorkoutId
--    from your first query.
-- 3. Select everything from Goal where the GoalId is one of the GoalIds from your
--    second query.
-- 1 row, 3 rows, 3 rows
--------------------
select *
from Goal
where GoalId in (
select GoalId
from WorkoutGoal
where WorkoutId = 
(select WorkoutId
from Workout 
where Name = 'This Is Parkour')); 
