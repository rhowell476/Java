
package triangle;

/**
 *
 * @author Reddogg
 */


public class Triangle {

     public static void main(String[] args) {

    // TODO code application logic here

    int row; // the row position
    int column; // the column position
    int space; // number of spaces to print

    // first triangle

    for (row = 1; row <= 10; row++) {
        
        for (column = 10; column >= row; column--) {
            System.out.print(" ");
        }
        for (column = 1; column <= row; column++) {
            System.out.print("*");
        }
        for (column = 2; column <= row; column++) {
            System.out.print("*");
        }
        System.out.println();
    }
    for (row = 10; row >= 0; row--) {
        
        for (column = 10; column >= row; column--) {
            System.out.print(" ");
        }
        for (column = 1; column <= row; column++) {
            System.out.print("*");
        }
        for (column = 2; column <= row; column++) {
            System.out.print("*");
        }
        System.out.println();
    }
    System.out.println();
    }
}
