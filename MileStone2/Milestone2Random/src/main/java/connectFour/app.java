/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectFour;

import java.util.Scanner;

/**
 *
 * @author mohammedchowdhury
 */
public class app {
     static String winner = ""; 
     static boolean won = false; 
     static String [][] arr = {{"_","_","_","_","_","_","_"},
                               {"_","_","_","_","_","_","_"},
                               {"_","_","_","_","_","_","_"},
                               {"_","_","_","_","_","_","_"},
                               {"_","_","_","_","_","_","_"},
                               {"_","_","_","_","_","_","_"}};
    
     public static void main(String[] args) {
         int counter =1;    
         System.out.println("1. An empty board"); 
         displayBoard(arr);
         
         while(won==false){
             
             
             int x = getUserInputNumber("Choose a column: ");
             x--; 
             
             if(counter%2==0){
                 System.out.println("Player two chooses column "+(x+1));
                 userInput(x, "X");
             }else{
                 System.out.println("Player one chooses column "+(x+1));
                 userInput(x, "O");
                 
             }
             counter++; 
             System.out.println(" ");
             
      
        } 
         
         if(winner.equals("X")){
             System.out.println("Winner is X ");
         }
         else{
             System.out.println("Winner is 0");
         }
         System.exit(0);
        
    }
     
     public static void validateLastInput(int x, int y){
         checkHorixontal(x,y); 
         checkVertical(x,y);   
         
         int t = Math.min(x, y);        
         int tX1 = x-t,tY1 = y-t; 
         while(tX1 != arr.length && tY1 != arr[0].length){
             //System.out.println(tX+"  "+tY);
             checkDiagnalLeftToRightDown(tX1,tY1);  
             tX1++; 
             tY1++; 
         }

        int tX,tY; 
        if(x+y<arr.length){
           
           tX = x+y;
           tY = 0; 
           // System.out.println(tX+" "+tY);
        }
        else{
           int sum = x+y; 
           tX = arr.length-1;
           sum = sum-tX; 
           tY = sum; 
           // System.out.println(tX+"  "+tY);
        }

        while(tX != -1 && tY!=arr[0].length){
           //System.out.println(tX+" "+tY);
           checkDiagnalRightToLeftUp(tX,tY);
            tX--; 
            tY++; 
        }

         
     }
     
    public static void checkHorixontal(int x, int y){
         String s1,s2,s3,s4;     
         for(int a=0; a<arr[0].length-3; a++){
                    s1 = arr[x][a]; 
             s2 = arr[x][a+1]; 
             s3 = arr[x][a+2]; 
             s4 = arr[x][a+3]; 
            // System.out.println(s1+" "+s2+" "+s3+" "+s4);
             if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false) ){
                
                 won  = true; 
                 winner = s1;
                 //System.out.println(arr[x][a]+" "+arr[x][a+1]+" "+arr[x][a+2]+" "+arr[x][a+3]);
                 return; 
             }
         }
     }

    public static void checkDiagnalRightToLeftUp(int x, int y){
           if(x<3 || y>3){ // cannot check because we dont have a stacl greater then 3
            //System.out.println("Cannot check diag");
            return; 
        }
         String s1="",s2="",s3="",s4="";     // goign up form left corner to right corner
             s1 = arr[x][y]; 
             s2 = arr[x-1][y+1]; 
             s3 = arr[x-2][y+2]; 
             s4 = arr[x-3][y+3]; 
             
           
             
             //System.out.println(s1+" "+s2+" "+s3+" "+s4+"  ssss");
             if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false)){
                 won  = true; 
                 winner = s1;
                 return; 
             }
    }
    
    public static void checkDiagnalLeftToRightDown(int x, int y){
        int tempX = arr.length-x,tempY = arr.length-y; 
        if(tempX<4 || tempY<3){ // cannot check because we dont have a stacl greater then 3
            //System.out.println("Cannot check diag");
            return; 
        }
         String s1="",s2="",s3="",s4="";     
//         //for(int a=0; a<arr[y].length-3; a++){
             s1 = arr[x][y]; 
             s2 = arr[x+1][y+1]; 
             s3 = arr[x+2][y+2]; 
             s4 = arr[x+3][y+3]; 
             
             //System.out.println(s1+" "+s2+" "+s3+" "+s4);
             if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false)){
                 // System.out.println("aa was hitt");     
                 won  = true; 
                 winner = s1;
                 //System.out.println(s1+" "+s2+" "+s3+" "+s4);
                 return; 
             }
    }
  
    public static void checkVertical(int x,int y){
        String s1,s2,s3,s4;        
//         System.out.println(x+" x");
//          System.out.println(y+" y");
             
         for(int a=arr.length-4; a>-1; a--){
       
        //for(int a=0; a<arr.length-3; a++){
            s1 = arr[a][y]; 
            s2 = arr[a+1][y]; 
            s3 = arr[a+2][y]; 
            s4 = arr[a+3][y]; 
            
            if(s4.equals("_")){ /// if the item on the col is _ then we return becaue we havent seen 4 in rows 
                return; 
            }
            
           // System.out.println(arr[a][y]+" "+arr[a+1][y]+" "+arr[a+2][y]+" "+arr[a+3][y]);             
            if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false)){            
                won  = true; 
                winner = s1;
//                System.out.println("Won");
               //System.out.println(arr[a][y]+" "+arr[a+1][y]+" "+arr[a+2][y]+" "+arr[a+3][y]);
                return; 
             }
         }
     }
    
    public static  void userInput(int x, String st){ //puts userinput in the grid will need to get user input 1-7 and minus one 
              
       if(arr[0][x].equals("_")==false){  // check to see if the column if full
           System.out.println("COLUMN IS FULL");
            return; 
        } 
       if(arr[5][x].equals("_")){  // checks to see if the column is empty
           arr[5][x] = st; 
           //displayBoard(arr); 
           validateLastInput(5, x);
           displayBoard(arr);
           return; 
       }
          
       for(int a=0; a< arr.length-1;a++){ // if the column is not empty then we start stcking on top
           if(arr[a+1][x].equals("_")==false){
               arr[a][x] = st;            
               validateLastInput(a, x);
               displayBoard(arr);
               return; 
           }
       }        
    }
    
     public static int getUserInputNumber(String message) {
        Scanner myScanner = new Scanner(System.in);
        boolean isValid = false;
        int number = 0;
        do {
            try {
                System.out.print(message);
                String input = myScanner.nextLine();// getting a user String
                number = Integer.parseInt(input); //then converting it your self to a format we want
                if (number > 0 && number<8) { //validating the number is greater than 0
                    isValid = true;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That was not a whole number!  " + ex);
                // ex.printStackTrace();
            }
            System.out.println(number);
        } while (isValid == false);
        return number;
    }
    
    public static void displayBoard(String [][] arr){    
        System.out.println("1 2 3 4 5 6 7");
        for(int a=0; a<arr.length; a++){
            for(int b=0; b<arr[0].length;b++){
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
    

    ////////////////// Code under works well ///////////////
     
//    public static void checkDiagnalRightToLeftDown(int x, int y){ 
//           if(x>2 || y<3){ // cannot check because we dont have a stacl greater then 3
//            //System.out.println("Cannot check diag");
//            return; 
//        }
//         String s1="",s2="",s3="",s4="";     // goign up form left corner to right corner
//             s1 = arr[x][y]; 
//             s2 = arr[x+1][y-1]; 
//             s3 = arr[x+2][y-2]; 
//             s4 = arr[x+3][y-3]; 
//                    
//             if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false)){
//                 won  = true; 
//                 winner = s1;
//                 return; 
//             }
//    }
     

     
//    public static void checkDiagnalLeftToRightUp(int x, int y){
//        System.out.println(x+" "+y);
//        if(x<3 || y<3){ // cannot check because we dont have a stacl greater then 3
//            //System.out.println("Cannot check diag");
//            return; 
//        }
//         String s1="",s2="",s3="",s4="";     
//             s1 = arr[x][y]; 
//             s2 = arr[x-1][y-1]; 
//             s3 = arr[x-2][y-2]; 
//             s4 = arr[x-3][y-3]; 
//             
//             if(s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && (s1.equals("_")==false)){
//                 won  = true; 
//                 winner = s1;
//                 return; 
//             }
//    }