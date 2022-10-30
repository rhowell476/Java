/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.recursivebinary;

import java.security.SecureRandom;

/**
 *
 * @author Reddogg
 */
public class RecursiveBinary {
    public static int[]data = {26, 39, 39, 44, 44, 48, 49, 53, 57, 60, 67, 73, 75, 80, 90}; //15 data members
    
// perform a binary search on the data      
    public static int binarySearch(int key, int low, int high) {
        int middle = (low + high + 1) / 2; // middle element
        int location = -1; // return value; -1 if not found 
        
        // loop to search for element
        // print remaining elements of array
        System.out.print(remainingElements(data, low, high));

        // output spaces for alignment
        for (int i = 0; i < middle; i++) {
            System.out.print("   ");
        }
        System.out.println(" * "); // indicate current middle


        // if the element is found at the middle                    
        if (key == data[middle]) {                                  
            location = middle; // location is the current middle     
        }                                                           
        else if (key < data[middle]) { // middle element is too high
            high = middle - 1; // eliminate the higher half          
        }                                                           
        else { // middle element is too low                         
            low = middle + 1; // eliminate the lower half            
        }                                                           

        middle = (low + high + 1) / 2; // recalculate the middle
        
        if (low == middle || location == -1){ // The binary search completed but hasn't printed a result.
            // loop to search for element
            // print remaining elements of array
            System.out.print(remainingElements(data, low, high));

            // output spaces for alignment
            for (int i = 0; i < middle; i++) {
                System.out.print("   ");
            }
            System.out.println(" * "); // indicate current middle

        }
        if (low == high && key == data[middle]){
            location = middle;
        }
        if (location != middle && low != high){
            return binarySearch(key,low, high);
        }
        else {
            return location; // return location of search key
        }
    }                         

   // method to output certain values in array
   private static String remainingElements(
        int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // append spaces for alignment
        for (int i = 0; i < low; i++) {
            temporary.append("   ");
        }                         

        // append elements left in array 
        for (int i = low; i <= high; i++) {
            temporary.append(data[i] + " ");
        }                         

        return String.format("%s%n", temporary);
   } 

   public static void main(String[] args) {
        int key = 0;
        int low = 0;
        int high = 15;
        boolean found = false;
        // Test with random number generator
        SecureRandom generator = new SecureRandom();
        while (!found){
            key = generator.nextInt(99);
            System.out.println("\n--------------------------------------------");
            // Recursive binary search
            int result = binarySearch(key, low, high-1);
            if (result == -1){
                System.out.printf("Key %d not found.", key);
            }
            else{
                System.out.printf("Key %d found at index %d", key, result);
                found = true;
            }
        }
    }
}
