/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.p3.arraymultiplier;

/**
 *
 * @author Reddogg
 */
public class P3ArrayMultiplier {

    // Multi-dimensional string work function
    public static void stringWork(String[][] str){
        //calculate the number of combinations
        int rows = str.length; // Row length
        int cols = 1; // Used to store column count
        int tempCount = 0; // Used to store a value later
        
        // Display the 2D array data
        for (int row = 0; row < str.length;row++){ // Loop through array's rows
            // Loop through columns of current row
            for (int col = 0; col < str[row].length;col++){
                System.out.printf("%s ", str[row][col]);
                tempCount++;
            }
            cols *= str[row].length;
            System.out.println();
        }
        
        // Create string array holding each combination
        String[] combinations = new String[cols]; // Stores all the output combinations
        String[] temp = new String[tempCount]; // Array index size --> stores the temps

        int counter = 0;
        // Pick items from data row
        for (int row = 0; row < str.length;row++){ // Loop through array's rows
            // Loop through columns of current row
            for (int col = 0; col < str[row].length;col++){
                System.out.println("What data: " + str[row][col]);
                temp[counter] = str[row][col]; //populate temp[] value
                counter++;
            }
            
        }
        
        
        
        //Results Output (temporary)
        for (String s: temp){
            System.out.println("The value is '" + s + "'.");
        }
        
        for (String s: combinations){
            System.out.println("The string is '" + s + "'.");
        }
    }
    
    
    public static void main(String[] args) {
        String[][] data0 = {{"A","B"},{"1","2"},{"XX","YY"}};
        String[][] data = {{"Try", "Do"}, {"at least"},{"1","3"},{"Tasks","Activity"},
            {"a day", "a week"}};
        String[][] data2 = {{"A"},{"1"},{"2"},{"XX","YY"}};

        
        stringWork(data); // choose which string[][] to work with
    }
}
