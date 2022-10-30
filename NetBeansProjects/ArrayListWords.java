/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package words;

import java.util.ArrayList;

/**
 *
 * @author Reddogg
 */
public class ArrayListWords {

    public static void main(String[] args) {
        
        ArrayList<String> words = new ArrayList<String>(2187);
        String[] two = {"A", "B", "C"};

        int counter = 0;
        String printChar = " ";
        System.out.println("Starting script.");
        for (int i = 0; i < 2187; i++){
            printChar = two[counter];
            words.add(printChar);
            if (i == 0){
                continue;
            }
            if (i % 729 == 0){
                printChar = two[counter + 1];
                counter++;
            }
        }
        
        for (String word : words){
            System.out.println(word);
        }
    }
}
