
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) {

//        //LocalDate ld = LocalDate.now(); // prints the current time from the system
//        LocalDate ld = LocalDate.parse("2015-09-12"); //yyyy-mm-dd  // you can set a specfic date
//        System.out.println(ld);// prints 2015-09-12
//
////          int d = ld.now().getDayOfMonth();
////
////        int m = ld.now().getMonthValue();
////        int y= ld.now().getYear(); 
////        
////        String packed = m+"/"+d+"/"+y ; 
////        System.out.println(packed);
//        ld = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));// can format a date 
//
//        System.out.println(ld);
//
//        LocalDate past = ld.minusYears(3);
//        System.out.println(past); // 2007-02-07
//
//        Period diff = past.until(ld);
//
//        System.out.println(diff);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDate ld = LocalDate.parse("02/07/2010", formatter);
//        String formatted = ld.format(formatter);
//        System.out.println(formatted);


       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

       LocalDate ld = LocalDate.now(); 
       String s = ld.format(formatter); 
        
       System.out.println(s);
       
       String formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(formatted);
        

    }

}
