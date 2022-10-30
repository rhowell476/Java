/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package formattest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * @author Reddogg
 */
public class FormatTest {
    public static ArrayList<String> allOutputs= new ArrayList<String>();
    
    public static void main(String[] args) {
        allOutputs.add("Twelve");
        try (Formatter output = new Formatter("output.txt")){
            Scanner input = new Scanner(System.in);
            System.out.printf("%s\n:", "Enter a string of numbers: ");
            try{
                System.out.println();
                System.out.printf("allOutputs is: %s", allOutputs.get(0));
                output.format("%s\n", allOutputs.get(0));
            }
            catch (NoSuchElementException elementException){
                System.err.println("Invalid");
                input.nextLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
