use PersonalTrainer;
-- Use an aggregate to count the number of Clients.
-- 500 rows
-- ------------------
select count(*)
from Client; 
-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows
-- ------------------
select count(Client.BirthDate)
from Client; 
-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
-- ------------------
select Client.City, count(Client.ClientId)
from Client
group by Client.City; 
-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
-- ------------------
select InvoiceLineItem.InvoiceId, sum(Price*Quantity)
from InvoiceLineItem
group by InvoiceLineItem.InvoiceId; 
-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
-- ------------------
select InvoiceLineItem.InvoiceId, sum(Price*Quantity) InvoiceTotal
from InvoiceLineItem
group by InvoiceLineItem.InvoiceId
having sum(Price*Quantity)>500
order by InvoiceTotal; 
-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
-- ------------------
select InvoiceLineItem.Description, avg(Price*Quantity)
from InvoiceLineItem
group by InvoiceLineItem.Description; 
-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
-- ------------------
select Client.ClientId, Client.FirstName, Client.LastName, SUM(InvoiceLineItem.Price*InvoiceLineItem.Quantity) Total
from Client,Invoice,InvoiceLineItem
where Client.ClientId = Invoice.ClientId and 
Invoice.InvoiceId = InvoiceLineItem.InvoiceId and 
Invoice.InvoiceStatus = 2
group by Client.ClientId, Client.FirstName, Client.LastName
having sum(InvoiceLineItem.Price*InvoiceLineItem.Quantity )> 1000 
order by Client.LastName,Client.FirstName; 
-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
-- ------------------
select ExerciseCategory.Name, count(Exercise.ExerciseId) 
from Exercise,ExerciseCategory
where Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
group by ExerciseCategory.Name; 
-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
-- ------------------
select Exercise.ExerciseId,Exercise.Name, min(ExerciseInstance.Sets), max(ExerciseInstance.Sets), avg(ExerciseInstance.Sets)
from Exercise,ExerciseInstance 
where Exercise.ExerciseId = ExerciseInstance.ExerciseId
group by Exercise.ExerciseId,Exercise.Name; 
-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
-- ------------------
select Workout.Name, min(BirthDate),  max(BirthDate) 
from Client, ClientWorkout, Workout
where Client.ClientId = ClientWorkout.ClientId and 
ClientWorkout.WorkoutId = Workout.WorkoutId 
group by Workout.Name;
-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
-- ------------------
SELECT client.ClientId,count(ClientGoal.ClientId)
from Client
left outer join ClientGoal on ClientGoal.ClientId = Client.ClientId
group by client.ClientId; 
-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
-- ------------------
select Exercise.Name, Unit.Name, min(ExerciseInstanceUnitValue.Value), max(ExerciseInstanceUnitValue.Value)
from Exercise,Unit,ExerciseInstanceUnitValue,ExerciseInstance
where Exercise.ExerciseId = ExerciseInstance.ExerciseId and 
ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId and 
ExerciseInstanceUnitValue.UnitId = Unit.UnitId
group by Exercise.Name,Unit.Name; 
-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
-- ------------------


SELECT ExerciseCategory.Name CategoryName,Exercise.Name 'ExerciseName', Unit.Name 'UnitName', MIN(ExerciseInstanceUnitValue.Value) 'MinValue',MAX(ExerciseInstanceUnitValue.Value) 'MaxValue'
FROM Exercise 
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
INNER JOIN ExerciseCategory 
ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
GROUP BY Exercise.ExerciseId, Exercise.Name, Unit.UnitId, Unit.Name, ExerciseCategory.Name
ORDER BY ExerciseCategory.Name, Exercise.Name, Unit.Name;
-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
-- ------------------


-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
-- ------------------

-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
-- ------------------
