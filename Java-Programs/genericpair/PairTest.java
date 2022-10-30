/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.week3.genericpair;

import java.util.ArrayList;

/**
 *
 * @author Reddogg
 */
public class PairTest {
    
    public static void main(String[] args) {
        ArrayList<Pair> listOfPairs = new ArrayList<>(); // stores all pairs
        // Create pairs
        Pair<Integer, String> Pair = new Pair(4, "four"); // A new pair<Int, Str>
        Pair<Float, Double> secondPair = new Pair(4.87439103123123, 4.444444010101010101); // A new pair<Float, Double>

        // Add each pair to list
        listOfPairs.add(Pair);
        listOfPairs.add(secondPair);

        // Print all pairs in list
        System.out.println("\nList of pairs: ");
        for (int i = 0; i < listOfPairs.size(); i++){
            Pair p = listOfPairs.get(i);
            System.out.printf("Pair %d is: <%.10s, %.10s>.%n", i, p.getFirstElement().toString(), p.getSecondElement().toString());
        }
        
        // Change both elements of pair one
        Integer newFirstPairValue = 14052;
        String newSecondPairValue = "FOUR";
        listOfPairs.get(0).setFirstElement(newFirstPairValue);
        listOfPairs.get(0).setSecondElement(newSecondPairValue);

        // Print all pairs --> After changes above
        System.out.println("\nList of pairs after changing pair 0: ");
        for (int i = 0; i < listOfPairs.size(); i++){
            Pair p = listOfPairs.get(i);
            System.out.printf("Pair %d is: <%.10s, %.10s>.%n", i, p.getFirstElement().toString(), p.getSecondElement().toString());
        }
    }
}
