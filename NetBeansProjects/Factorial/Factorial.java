/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package factorial;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;

public class Factorial {
    
    public static void main(String[] args) {
        // read a non-negative integer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        if (n < 0){
            System.out.println("You must enter a number >= 0");
            return;
        }
        
        // calculate factorial
        int factorial = 1;
        for (int counter = n; counter >= 1; counter--)
        {
            factorial *= counter;
        }
        System.out.printf("%d! = %d%n",n, factorial);
        
    }
}
