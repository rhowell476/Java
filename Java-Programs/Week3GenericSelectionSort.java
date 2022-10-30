/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.week3.genericselectionsort;

import java.util.Arrays;

/**
 *
 * @author Reddogg
 */
public class Week3GenericSelectionSort {

    // sort array using selection sort
    public static <T extends Comparable> void selectionSort(T[] data) {
        // loop over data.length - 1 elements
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i; // first index of remaining array

            // loop to find index of smallest element
            for (int index = i + 1; index < data.length; index++) {
                if (data[smallest].compareTo(data[index]) > 0) {
                    smallest = index;
                }                                              
            }

            swap(data, i, smallest); // swap smallest element into position
            printPass(data, i + 1, smallest); // output pass of algorithm
       }
    }
    
    // helper method to swap values in two elements
    private static <T> void swap(T[] data, int first, int second) {
        T temporary = data[first]; // store first in temporary
        data[first] = data[second]; // replace first with second
        data[second] = temporary; // put temporary in second
    }
    
       // print a pass of the algorithm
    private static <T> void printPass(T[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);

        // output elements till selected item
        for (int i = 0; i < index; i++) {
            System.out.printf("%s  ", data[i]);
        }

        System.out.printf("%s* ", data[index]); // indicate swap

        // finish outputting array
        for (int i = index + 1; i < data.length; i++) {
            System.out.printf("%s  ", data[i]);
        }

        System.out.printf("%n               "); // for alignment

        // indicate amount of array that�s sorted
        for (int j = 0; j < pass; j++) {
            System.out.print("--  ");
        }
        System.out.println(); 
    }
    
    public static void main(String[] args) {
        Integer[] data = {4, 18, 91, 84, 12, 4, 3};
        selectionSort(data);
        System.out.printf("\nArray after selection sort: %s\n", Arrays.toString(data));
        
        Float[] dataFloats = {4.14F, 18.18F, 91.91F, 84.48F, 12.12F, 4.64F, 3.46F};
        selectionSort(dataFloats);
        System.out.printf("%nArray after selection sort: %s%n", Arrays.toString(dataFloats));
    }
}
