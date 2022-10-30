/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package triangles;

/**
 *
 * @author Reddogg
 */
public class Triangles {

    public static void main(String[] args) {

        int row;
        int column;

        // first triangle
        for (row = 1; row <= 10; row++) {
            for (column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        //second triangle
        for (row = 1; row <= 10; row++) {
            for (column = 10; column >= row; column--) {
                System.out.print("*");
            }
            System.out.println();
        }

        //third triangle
        for (row = 1; row <= 10; row++) {
            //introduce spaces for first row. Start with 0 spaces
            for (int spaces = 0; spaces <= row-2; spaces++) {
                System.out.print(' ');
            }
            //loop for stars
            for (column = 10; column >= row; column--) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        //fourth triangle
        for (row = 1; row <= 10; row++) {
            //introduce spaces for first row. Start with 9 spaces
            for (int spaces = 9; spaces >= row; spaces--) {
                System.out.print(' ');
            }
            //loop for stars
            for (column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
