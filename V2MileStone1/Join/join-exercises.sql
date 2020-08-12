USE PersonalTrainer;
-- Select all columns from ExerciseCategory and Exercise.
-- The tables should be joined on ExerciseCategoryId.
-- This query returns all Exercises and their associated ExerciseCategory.
-- 64 rows
-- --------------------
select *
from ExerciseCategory
INNER JOIN Exercise ON ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId; 
-- same as top 
select *
from ExerciseCategory , Exercise
where ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId; 

-- Select ExerciseCategory.Name and Exercise.Name
-- where the ExerciseCategory does not have a ParentCategoryId (it is null).
-- Again, join the tables on their shared key (ExerciseCategoryId).
-- 9 rows
-- ------------------
select ExerciseCategory.Name, Exercise.Name 
from ExerciseCategory 
Inner join Exercise on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
where ExerciseCategory.ParentCategoryId is NULL; 
-- same as top
select ExerciseCategory.Name, Exercise.Name 
from ExerciseCategory , Exercise
where ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId and 
ExerciseCategory.ParentCategoryId is NULL; 
-- The query above is a little confusing. At first glance, it's hard to tell
-- which Name belongs to ExerciseCategory and which belongs to Exercise.
-- Rewrite the query using an aliases. 
-- Alias ExerciseCategory.Name as 'CategoryName'.
-- Alias Exercise.Name as 'ExerciseName'.
-- 9 rows
-- ------------------
select ExerciseCategory.Name CategoryName, Exercise.Name ExerciseName
from ExerciseCategory  
Inner join Exercise on ExerciseCategory.ExerciseCategoryId = Exercise.ExerciseCategoryId
where ExerciseCategory.ParentCategoryId is NULL; 
-- Select FirstName, LastName, and BirthDate from Client
-- and EmailAddress from Login 
-- where Client.BirthDate is in the 1990s.
-- Join the tables by their key relationship. 
-- What is the primary-foreign key relationship?
-- 35 rows
-- ------------------
SELECT Client.FirstName, Client.LastName, Client.BirthDate, Login.EmailAddress
from Client,Login
where Client.ClientId = Login.ClientId and
Client.BirthDate BETWEEN '1990-01-01' AND '1999-12-31' ; 
-- same as top
SELECT Client.FirstName, Client.LastName, Client.BirthDate, Login.EmailAddress
from Client
inner join Login on Client.ClientId = Login.ClientId
where Client.BirthDate BETWEEN '1990-01-01' AND '1999-12-31' ; 
-- Select Workout.Name, Client.FirstName, and Client.LastName
-- for Clients with LastNames starting with 'C'?
-- How are Clients and Workouts related?
-- 25 rows
-- ------------------
select Workout.Name, Client.FirstName, Client.LastName
from Workout,Client, ClientWorkout
where ClientWorkout.WorkoutId = Workout.WorkoutId and 
Client.ClientId = ClientWorkout.ClientId and 
(Client.LastName like 'c%' or Client.LastName like'C%'); 
-- same as top
select Workout.Name, Client.FirstName, Client.LastName
from Client
inner join ClientWorkout on Client.ClientId = ClientWorkout.ClientId  
inner join Workout on ClientWorkout.WorkoutId = Workout.WorkoutId  
where (Client.LastName like 'c%' or Client.LastName like'C%'); 
-- Select Names from Workouts and their Goals.
-- This is a many-to-many relationship with a bridge table.
-- Use aliases appropriately to avoid ambiguous columns in the result.
-- ------------------
select Workout.Name , Goal.Name 
from Workout,Goal,WorkoutGoal
where Workout.WorkoutId = WorkoutGoal.WorkoutId and 
Goal.GoalId = WorkoutGoal.GoalId;
-- same as top
SELECT w.`Name` WorkoutName,g.`Name` GoalName
FROM Workout w
INNER JOIN WorkoutGoal wg ON w.WorkoutId = wg.WorkoutId
INNER JOIN Goal g ON wg.GoalId = g.GoalId;
-- Select FirstName and LastName from Client.
-- Select ClientId and EmailAddress from Login.
-- Join the tables, but make Login optional.
-- 500 rows
-- ------------------
select Client.FirstName,Client.LastName , Login.ClientId, Login.EmailAddress
from Client 
left outer join  Login on Client.ClientId = Login.ClientId; 
-- Using the query above as a foundation, select Clients
-- who do _not_ have a Login.
-- 200 rows
-- ------------------
select Client.FirstName,Client.LastName , Login.ClientId, Login.EmailAddress
from Client 
left outer join  Login on Client.ClientId = Login.ClientId
where Login.EmailAddress is Null; 
-- Does the Client, Romeo Seaward, have a Login?
-- Decide using a single query.
-- nope :(
-- ------------------
select *
from Login
where ClientId in(
select Client.ClientId
from Client 
where Client.FirstName = 'Romeo' and 
Client.LastName = 'Seaward'); 

-- Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
-- This requires a self-join.
-- 12 rows
-- ------------------
SELECT p.`Name` ParentCategory,ec.`Name` Category
FROM ExerciseCategory ec
INNER JOIN ExerciseCategory p ON ec.ParentCategoryId = p.ExerciseCategoryId;
    
-- Rewrite the query above so that every ExerciseCategory.Name is
-- included, even if it doesn't have a parent.
-- 16 rows
-- ------------------
SELECT p.`Name` ParentCategory,ec.`Name` Category
FROM ExerciseCategory ec
LEFT OUTER JOIN ExerciseCategory p ON ec.ParentCategoryId = p.ExerciseCategoryId;
-- Are there Clients who are not signed up for a Workout?
-- 50 rows
-- ------------------
select *
from Client
left outer join ClientWorkout on Client.ClientId = ClientWorkout.ClientId
where ClientWorkout.ClientId is Null; 
-- same as top
select *
from Client
where Client.ClientId not in(
select Client.ClientId
from Client,ClientWorkout
where Client.ClientId = ClientWorkout.ClientId); 
-- Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
-- Goals are associated to Clients through ClientGoal.
-- Goals are associated to Workouts through WorkoutGoal.
-- 6 rows, 4 unique rows
-- ------------------
SELECT w.WorkoutId,w.`Name` WorkoutName
FROM Client c 
INNER JOIN ClientGoal cg ON c.ClientId = cg.ClientId
INNER JOIN WorkoutGoal wg ON cg.GoalId = wg.GoalId
INNER JOIN Workout w ON wg.WorkoutId = w.WorkoutId
WHERE 
c.FirstName = 'Shell' AND 
c.LastName = 'Creane' AND 
w.LevelId = 1;
-- same as top
select Workout.WorkoutId, Workout.Name
from Client, ClientGoal, Goal, Workout, WorkoutGoal
where Client.ClientId = ClientGoal.ClientId and 
ClientGoal.GoalId = Goal.GoalId and
Goal.GoalId = WorkoutGoal.GoalId and 
WorkoutGoal.WorkoutId = Workout.WorkoutId and 
Workout.LevelId = 1 and
Client.FirstName = 'Shell' AND 
Client.LastName = 'Creane';
-- Select all Workouts. 
-- Join to the Goal, 'Core Strength', but make it optional.
-- You may have to look up the GoalId before writing the main query.
-- If you filter on Goal.Name in a WHERE clause, Workouts will be excluded.
-- Why?
-- 26 Workouts, 3 Goals
-- ------------------
select * 
from Workout
left outer join WorkoutGoal on WorkoutGoal.WorkoutId = Workout.WorkoutId and WorkoutGoal.GoalId = 10
left outer join Goal on WorkoutGoal.GoalId = Goal.GoalId and Goal.Name = 'Core Strength';
-- The relationship between Workouts and Exercises is... complicated.
-- Workout links to WorkoutDay (one day in a Workout routine)
-- which links to WorkoutDayExerciseInstance 
-- (Exercises can be repeated in a day so a bridge table is required) 
-- which links to ExerciseInstance 
-- (Exercises can be done with different weights, repetions,
-- laps, etc...) 
-- which finally links to Exercise.
-- Select Workout.Name and Exercise.Name for related Workouts and Exercises.
-- ------------------
   
-- An ExerciseInstance is configured with ExerciseInstanceUnitValue.
-- It contains a Value and UnitId that links to Unit.
-- Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
-- Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name
-- for the 'Plank' exercise. 
-- How many Planks are configured, which Units apply, and what 
-- are the configured Values?
-- 4 rows, 1 Unit, and 4 distinct Values
-- ------------------


