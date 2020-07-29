
import java.math.BigDecimal;
import java.math.RoundingMode;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammedchowdhury
 */
public class BigDecimalPractice {

    public static void main(String[] args) {

//        BigDecimal a = new BigDecimal("42.355");
//        System.out.println(a);
//
//        a = a.setScale(2, RoundingMode.HALF_DOWN);
//
//        System.out.println(a.toString());
//
//        BigDecimal op1, op2, c;
//
//        op1 = new BigDecimal("10");
//        op2 = new BigDecimal("6");
//
////        c = op1.divide(op2,RoundingMode.HALF_UP); // use halfUp for moneey        
////        System.out.println(c.toString());
//
//        int scale = 2;  
//        
//        RoundingMode rounding = RoundingMode.HALF_UP; 
//
//        c = op1.divide(op2, rounding); // 2
//        System.out.println(c.toString());
//
//        c = op1.divide(op2, 2, rounding); // 1.67 //used for money
//        System.out.println(c.toString());
//
//        c = op1.divide(op2, 2, RoundingMode.DOWN); // 1.66
//        System.out.println(c.toString());

        BigDecimal b = new BigDecimal("85"); 
        
        System.out.println(b.compareTo(new BigDecimal("100")));
       
        
        
       

    }

}
