/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.p4.hashmap;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Reddogg
 */
public class P4HashMap {

    // This function takes user input and maps it
    public static void inputNumbers(Map<Integer, Integer> map){
        Scanner input = new Scanner(System.in);
        int entry = 0;
        while (entry != -1){ // Continue until -1 is entered
            try{
                System.out.println("Enter a number: ");
                entry = input.nextInt();
            }
            catch (InputMismatchException e) { // Continue if not a number
                System.out.println("Must enter a number. Try again.");
                input.nextLine();
                continue;
            }
            if (entry == -1)
                break;
            
            // Add number to map
            if (map.containsKey(entry)){ // Check if previously added. Increment count
                int counter = map.get(entry);
                map.put(entry, counter + 1);
            }
            else {
                map.put(entry, 1); // Add number. Start value at 1.
            }
        }
    }
    
    // This function prints the histogram
    public static void printHistogram(Map<Integer, Integer> map){
        // A set to iterate map keys
        Set<Integer> numbers = map.keySet();
        
        // Iterate through keys, printing the results
        for (Integer number: numbers){
            System.out.printf("The number %s occurs %s times.%n", number, map.get(number));
        }
    }
    
    // Entry point
    public static void main(String[] args) {
        Map<Integer, Integer> histogram = new HashMap<>(); //HashMap histogram
        
        inputNumbers(histogram); // Get input
        printHistogram(histogram); // Print results
    }
}
