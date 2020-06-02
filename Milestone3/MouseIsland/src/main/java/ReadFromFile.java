
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
public class ReadFromFile {

    public static String title = "";
    public static int simulations = 0;
    public static int Width = 0, Height = 0;
    public static int[][] map;
    public static ArrayList<String[]> list = new ArrayList<String[]>();

    public static void readFromFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("MouseIslandTestMap.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Could not load in map");
            return;
        }
        String currentLine;
        int counter = 0;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            if (counter == 0) { // title 
                title = currentLine;
                counter++;
                continue;
            } else if (counter == 1) { // num of sim
                simulations = Integer.parseInt(currentLine);
                counter++;
                continue;
            } else if (counter == 2) { // width of island
                Width = Integer.parseInt(currentLine);
                counter++;
                continue;

            } else if (counter == 3) { // height of island
                simulations = Integer.parseInt(currentLine);
                Height = Integer.parseInt(currentLine);
                counter++;
                continue;
            } else { //  belongs in the array

                String[] arr = currentLine.split(" ");
                list.add(arr);

            }
        }
        scanner.close();
        loadMap();

    }

    public static void loadMap() {
        map = new int[Height][Width];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                map[i][j] = Integer.parseInt(list.get(i)[j]);
            }
        }
    }

}
