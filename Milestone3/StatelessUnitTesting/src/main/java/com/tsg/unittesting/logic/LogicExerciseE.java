/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.tsg.unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseE {

    /**
     * Given the following chart, return the correct color designation given
     * measured wavelength, frequency and photonic energy. If it doesn't fall
     * within correct bands, return "Unknown" instead. If it falls exactly
     * within a band transition, return a compound color, with the longer
     * wavelength color first.
     *
     * Color	Wavelength	Frequency	Photon energy Violet	380–450 nm	668–789 THz
     * 2.75–3.26 eV Blue	450–495 nm	606–668 THz	2.50–2.75 eV Green	495–570 nm
     * 526–606 THz	2.17–2.50 eV Yellow	570–590 nm	508–526 THz	2.10–2.17 eV
     * Orange	590–620 nm	484–508 THz	2.00–2.10 eV Red	620–750 nm	400–484 THz
     * 1.65–2.00 eV
     *
     * Ex: whatColor( 575, 510, 2.15 ) -> "Yellow" whatColor( 449, 670, 3.00 )
     * -> "Violet" whatColor( 621, 475, 16.5 ) -> "Unknown" whatColor( 590, 508,
     * 2.05 ) -> "Orange" whatColor( 570, 526, 2.17 ) -> "Yellow-Green"
     *
     * @param waveLengthNM
     * @param frequencyTHZ
     * @param photonicEnergyEV
     * @return String color
     */
    public static String whatColor(int waveLengthNM, int frequencyTHZ, double photonicEnergyEV) {

        String color = "";
        int col = 0;

        if (waveLengthNM >= 620 && waveLengthNM <= 750) {
            color = "Red";
            col++;
        } else if (waveLengthNM >= 590 && waveLengthNM <= 620) {
            color = "Orange";
            col++;
        } else if (waveLengthNM >= 570 && waveLengthNM <= 590) {
            color = "Yellow";
            col++;
        } else if (waveLengthNM >= 495 && waveLengthNM <= 570) {
            color = "Green";
            col++;
        } else if (waveLengthNM >= 450 && waveLengthNM <= 495) {
            color = "Blue";
            col++;
        } else if (waveLengthNM >= 380 && waveLengthNM <= 450) {
            color = "Violet";
            col++;
        } else {
            return "Unknown";
        }

        String color2 = "";

        if (frequencyTHZ >= 400 && frequencyTHZ <= 484) {
            color2 = "Red";
            col++;
        } else if (frequencyTHZ >= 484 && frequencyTHZ <= 508) {
            color2 = "Orange";
            col++;
        } else if (frequencyTHZ >= 508 && frequencyTHZ <= 526) {
            color2 = "Yellow";
            col++;
        } else if (frequencyTHZ >= 526 && frequencyTHZ <= 606) {
            color2 = "Green";
            col++;
        } else if (frequencyTHZ >= 606 && frequencyTHZ <= 668) {
            color2 = "Blue";
            col++;
        } else if (frequencyTHZ >= 668 && frequencyTHZ <= 789) {
            color2 = "Violet";
            col++;
        } else {
            return "Unknown";
        }

        //     * 	Violet	380–450 nm	668–789 THz	2.75–3.26 eV
//     * 	Blue	450–495 nm	606–668 THz	2.50–2.75 eV
//     * 	Green	495–570 nm	526–606 THz	2.17–2.50 eV
//     * 	Yellow	570–590 nm	508–526 THz	2.10–2.17 eV
//     * 	Orange	590–620 nm	484–508 THz	2.00–2.10 eV
//     * 	Red	620–750 nm	400–484 THz	1.65–2.00 eV  
        String color3 = "";

        if (photonicEnergyEV >= 1.65 && photonicEnergyEV <= 2.00) {
            color3 = "Red";
            col++;
        } else if (photonicEnergyEV >= 2.00 && photonicEnergyEV <= 2.10) {
            color3 = "Orange";
            col++;
        } else if (photonicEnergyEV >= 2.10 && photonicEnergyEV <= 2.17) {
            color3 = "Yellow";
            col++;
        } else if (photonicEnergyEV >= 2.17 && photonicEnergyEV <= 2.50) {
            color3 = "Green";
            col++;
        } else if (photonicEnergyEV >= 2.50 && photonicEnergyEV <= 2.75) {
            color3 = "Blue";
            col++;
        } else if (photonicEnergyEV >= 2.75 && photonicEnergyEV <= 3.26) {
            color3 = "Violet";
            col++;
        } else {
            return "Unknown";
        }

        if (color.equals(color2)) {
            color2 = "";
        }
        if (color.equals(color3)) {
            color3 = "";
        }
        if (color2.equals(color3)) {
            color2 = "";
        }

        String ans = "";
        if (color.equals("Red") || color2.equals("Red") || color3.equals("Red")) {
            ans = "Red";
        }

        if (color.equals("Orange") || color2.equals("Orange") || color3.equals("Orange")) {
            if(ans.length()>1){
                 ans = ans+"-Orange";
            }
            else{
                ans = "Orange"; 
            }
           
        }

        if (color.equals("Yellow") || color2.equals("Yellow") || color3.equals("Yellow")) {
            if(ans.length()>1){
                 ans = ans+"-Yellow";
            }
            else{
                ans = "Yellow"; 
            }
        }

        if (color.equals("Green") || color2.equals("Green") || color3.equals("Green")) {
                      if(ans.length()>1){
                 ans = ans+"-Green";
            }
            else{
                ans = "Green"; 
            }
        }

        if (color.equals("Blue") || color2.equals("Blue") || color3.equals("Blue")) {
                     if(ans.length()>1){
                 ans = ans+"-Blue";
            }
            else{
                ans = "Blue"; 
            }
        }

        if (color.equals("Violet") || color2.equals("Violet") || color3.equals("Violet")) {
                        if(ans.length()>1){
                 ans = ans+"-Violet";
            }
            else{
                ans = "Violet"; 
            }
        }

        return ans;
    }

}
