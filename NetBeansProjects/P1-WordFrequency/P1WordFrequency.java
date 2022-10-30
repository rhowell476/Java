/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.p1.wordfrequency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Reddogg
 */
public class P1WordFrequency {

    // Entry point
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Input scanner
        Map<String, Integer> wordMap = new LinkedHashMap<>(); //Linked hash map keeps insertion order
        
        // Get input string from user
        System.out.println("Enter a line of text: ");
        String line = input.nextLine();
        
        // Remove common characters ,.:;?!
        line = line.replaceAll("[,.:;?!]", "").toLowerCase();
        
        // Create string array of words from the input string
        String[] words = line.split(" ");
        
        // Each word in 'words' string array, add to map 'wordMap'
        // Increment count value if the word is duplicated
        for (String str: words){
            // Checks if word is already in word map; increments count if yes
            if (wordMap.containsKey(str)) {
               int count = wordMap.get(str);
               wordMap.put(str, count + 1);
            }
            else {
               wordMap.put(str, 1);
            }
        }
        
        // A set to iterate map keys
        Set<String> keys = wordMap.keySet();
        
        // Iterate through keys, printing the results
        System.out.printf("%4sWords%4sCount%n", "", "");
        for (String key: keys){
            System.out.printf("%8s%8s%n", key, wordMap.get(key));
        }
    }
}
