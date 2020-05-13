package Lesson5CExerciseExerciseStudentQuizScores;

import Lesson5CExerciseUserIOClassLab.UserIO;
import Lesson5CExerciseUserIOClassLab.UserIOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mohammedchowdhury
 */
public class StudentQuizGrades {

    private Map<String, ArrayList<Double>> listOfStudent = new HashMap<>(); //student name , list of quizScores
    private UserIO input = new UserIOImpl();

    StudentQuizGrades() {

    }

    public Set<String> showAllStudent() {
        for (String student : listOfStudent.keySet()) {
            input.print(student);
        }
        Set<String> students = listOfStudent.keySet();
        return students;

    }

    public void addStudent(String name, ArrayList<Double> quiz) {
        listOfStudent.put(name, quiz);
    }

    public void addStudent(String name) {
        ArrayList<Double> quiz = new ArrayList<Double>();
        int numQuiz = input.readInt("How many quiz grades does this student have?");
        for (int i = 0; i < numQuiz; i++) {
            quiz.add(input.readDouble("Enter student's quiz grade", 0, 100));
        }
        listOfStudent.put(name, quiz);
    }

    public void removeStudent(String student) {
        if (listOfStudent.containsKey(student)) {
            listOfStudent.remove(student);
        }
    }

    public void viewAllQuiz(String name) {
        ArrayList<Double> temp = listOfStudent.get(name);
        if (temp.size() == 0) {
            System.out.println("Student has no test grades");
            return;
        }
        System.out.println(name + " :");
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i) + " ");
        }
    }

    public double viewQuizAverage(String name) {
        ArrayList<Double> temp = listOfStudent.get(name);
        if (temp.size() == 0) {
            System.out.println("Student has no test grades");
            return 0;
        }
        System.out.println(name + " :");
        double total = 0;
        for (int i = 0; i < temp.size(); i++) {
            total = total + temp.get(i);
        }
//        System.out.println("Quiz average for " + name + " :");
//        System.out.print(total / temp.size());
        return total/temp.size(); 
    }

    public void getAverageForEntireClass() {
        Set<String> set = listOfStudent.keySet();
        int totalQuiz = 0;
        int totalQuizGrade = 0;
        for (String name : set) {
            ArrayList<Double> quiz = listOfStudent.get(name);
            for (int i = 0; i < quiz.size(); i++) {
                totalQuiz++;
                totalQuizGrade += quiz.get(i);
            }
        }

        System.out.print("Class average is : ");
        System.out.println(totalQuizGrade / totalQuiz);
    }


public ArrayList<String> studentsWithHighestQuizScore(){
    Set<String> student  = listOfStudent.keySet(); 
    ArrayList<String> smartKids = new ArrayList<String>(); 
    
    for(String st : student){
        double score = viewQuizAverage(st); 
        if(score>=90){
            smartKids.add(st); 
        }
    }
    System.out.println(smartKids);
    return smartKids;     
}

public ArrayList<String> studentsWithLowesttQuizScore(){
     Set<String> student  = listOfStudent.keySet(); 
    ArrayList<String> dumbKids = new ArrayList<String>(); 
    
    for(String st : student){
        double score = viewQuizAverage(st); 
        if(score<60){
            dumbKids.add(st); 
        }
    }
    System.out.println(dumbKids);
    return dumbKids;     
}
        
    
    
    
    
    
    
    
}


//Add a student to the system
//Remove a student from the system
//View a list of quiz scores for a given student
//View the average quiz score for a given student

//Find and list the student(s) with the highest quiz score.
//Find and list the student(s) with the lowest quiz score.
