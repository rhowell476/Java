/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.p2.filehandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Reddogg
 */
public class P2FileHandler {

    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom(); // Used to generate random numbers
        try (Formatter out = new Formatter("numbers.txt");){
            
            
            // Generate random numbers between 0 and 9
            for (int counter = 1; counter <= 10000; counter++){
            Integer num = randomNumbers.nextInt(10);
            
            try {
                // Write the random integer, one number per line
                out.format("%d%n", num);
            }
            catch (IllegalFormatException e) {
                System.out.println("Illegal format. Try again");
            }
        }
        } catch (SecurityException | FileNotFoundException  | FormatterClosedException ex) {
            System.out.printf("There's been a problem with the file." +
                    "Please refer stack trace:\n");
        }
        
        
        // PART B.
        // Read and calculate the results
        try (Formatter out2 = new Formatter("output.txt");){
            // Ppen numbers.txt, read its contents and close the file
            try(Scanner input = new Scanner(Paths.get("numbers.txt"))) {
                Integer[] intCount = new Integer[10];
                
                // Initialize intCount starting all 0
                for (int i = 0; i < intCount.length; i++){
                    intCount[i] = 0;
                }
                
                // Read record from file
                while (input.hasNext()) {
                    // increment the number count
                    intCount[input.nextInt()]++;
                }
                
                for (int i = 0; i < intCount.length; i++){
                    System.out.println("Count [" + i + "] is: " + intCount[i]);
                    //String.format("%-12s%-12d%n", "Numbers", "Frequency");
                    
                    try {
                    // Write the random integer, one number per line
                    out2.format("%-12s%-12d%n", "Number " + i, intCount[i]);
                    }
                    catch (IllegalFormatException e) {
                        System.out.println("Illegal format. Try again");
                    }
                }
            } 
            catch (IOException | NoSuchElementException | 
               IllegalStateException e) {
               e.printStackTrace();
            } 
            
            
        } catch (SecurityException | FileNotFoundException  | FormatterClosedException ex) {
            System.out.printf("There's been a problem with the file." +
                    "Please refer stack trace:\n");
        }
    }
}
