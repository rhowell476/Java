/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package square;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;
public class Square {
    
    public static void squareOfAsterisks(int side) {
        // loop to create the row length
        String stars = "";
        for(int starsLength = 0; starsLength < side; starsLength++){
            stars += "*";
        }
        
        // loop to create the square
        for(int row = 1; row <= side; row++) {
            System.out.println(stars);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // get input of square dimensions
        System.out.println("Enter the side length of a square: ");
        int side = input.nextInt();
        if (side < 0){
            System.out.println("You must enter a number >= 0");
            return;
        }
        
        // call function
        squareOfAsterisks(side);
        
    }
}
