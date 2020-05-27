/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingCodeHere;

import Lesson5CExerciseUserIOClassLab.UserIO;
import Lesson5CExerciseUserIOClassLab.UserIOImpl;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author mohammedchowdhury
 */
public class App {

    public static void main(String[] args) throws IOException {

//        Item i1 = new Item(); //d.ctor
//        Item i2 = new Item(15.0, 2.0); //paramatized ctor
//        
//        i2.setWeight(50.0);
//
//       Potion p1=new Potion(30.0, 1.0); //uses's the item p.ctor
//       p1.drink();
//      
////        //polymorphism
//        Item p2 =new Potion(30.0, 2.0);
//        
//       // p2.drink(); //bc it is Item, can't access the child class behaviors
//        ((Potion)p2).drink(); //Using a cast to now access the child methods
////        
////        //using var weak typing
//       // var theClass=p2.getClass();
//       // System.out.println("theClass = " + theClass);
////        
////        //inventory
//       Item[] inventory={i1, i2, p1, p2};
//       double totalWeight=0.0;
//        for (int i = 0; i < inventory.length; i++) {
//            totalWeight+=inventory[i].getWeight();
//        }
//        System.out.println(totalWeight);
////        
////        //healing potions, child of potion which is child of item
//        HealingPotion p3 = new HealingPotion(50.0, 3.0);
//        p3.drink(); //uses the override
////        
////        //shopkeeper
//        NPC potionShop = new ShopKeeper();
//        potionShop.talk();
//        potionShop.showInventory();

        
//        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//        //PrintWriter out = new PrintWriter(new FileWriter("/Users/mohammedchowdhury/Desktop/OutFile.txt"));
//        out.println("this is a line in my file...");
//        out.println("a second line in my file...");
//        out.println("a third line in my file...");
//        out.flush();
//        out.close();


//        Random rand = new Random(); 
//  
//        // Generate random integers in range 0 to 999 
//        int rand_int1 = rand.nextInt(51);   
//        System.out.println(rand_int1);

//    Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
////    
//        System.out.println(map.put(1, 22));
//        System.out.println(map.put(2, 23));
//        
//        
//    
//        //System.out.println(xx);
//        
//       ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());

 //   print(1,2,39,"aa",12.11); 
 
// Map<String,String> map = new HashMap<String,String>(); 
// map.put("1", "11"); 
// 
//        System.out.println(map.remove("8"));

    List<String> list = new ArrayList<String>(); 
    
    list.add("1"); 
    list.add("2"); 
    
    boolean aa = list.remove("jj"); 
        System.out.println(aa);
    
    

    }
    
    public static void print(Object ... obj){
        int total = 0; 
        for(int a=0; a<obj.length;a++){
            System.out.println(obj[a]);
        }
    }
    
}
