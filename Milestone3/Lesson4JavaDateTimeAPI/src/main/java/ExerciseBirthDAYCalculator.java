import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammedchowdhury
 */
public class ExerciseBirthDAYCalculator {
    public static void main(String[] args) {
        getUserBirthDay();
    }

    public static void getUserBirthDay() {
        System.out.println("Welcome to the Magical BirthDAY Calculator!\n\n");
        boolean keepGoing = true;
        Scanner keyboard = new Scanner(System.in);
        String birthday;
        do {
            System.out.println("What's your birthday?");
            birthday = keyboard.nextLine();
            String[] arr = birthday.split("/");
            if (arr.length == 3) {
                if (arr[0].length() == 2 && arr[1].length() == 2 && arr[2].length() == 4) {
                    keepGoing = false;
                } else {
                    System.out.println("Invalid birthday format: MM/dd/YYYY");
                }
            } else {
                System.out.println("Invalid birthday format: MM/dd/YYYY");
            }
        } while (keepGoing);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(birthday, formatter);//birthday

        String day = ld.getDayOfWeek().toString();
        System.out.println("That's means you were born on a " + day + "!");

        LocalDate timeNow = LocalDate.now();
        String s = timeNow.format(formatter);

        int age = timeNow.getYear() - ld.getYear();

        LocalDate birthdayThisyear = ld.plusYears(age);

        System.out.println("This year it falls on a " + birthdayThisyear.getDayOfWeek().toString() + "...");

        long noOfDaysBetween = ChronoUnit.DAYS.between(timeNow, birthdayThisyear);
        if (noOfDaysBetween < 0) {
            birthdayThisyear = birthdayThisyear.plusYears(1);
            noOfDaysBetween = ChronoUnit.DAYS.between(timeNow, birthdayThisyear);
            age++;
        }

        System.out.println("And since today is " + s + ", there's only " + noOfDaysBetween + " more days until the next one!");
        System.out.println("Bet yer excited to be turning " + age + "!");

    }

}
//Your birthday calculator application should do the following:
//
//Ask someone for their birthday ex: 01/01/2002
//Tell them the day of the week their birthday falls on.
//Then tell them the day of the week it falls on this year!
//Next tell them what day it is today & the number of days until their next birthday...
//And how many years old they will be!

//Welcome to the Magical BirthDAY Calculator!
//
//What's your birthday?
//01-01-2002
//That's means you were born on a TUESDAY!
//This year it falls on a MONDAY...
//And since today is 12-30-2018, there's only 2 more days until the next one!
//Bet yer excited to be turning 17!
