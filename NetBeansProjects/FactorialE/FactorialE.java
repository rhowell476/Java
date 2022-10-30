/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package factorialE;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;
public class FactorialE {

    // calculate factorial
    public static int factorial(int n){
        int factorial = 1;
        for (int counter = n; counter >= 1; counter--)
        {
            factorial *= counter;
        }
        return factorial;
    }
    
    public static void main(String[] args) {
        // read a non-negative integer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number of terms to calculate e. "
                + "\n...The number must be a non-negative integer: ");
        int n = scanner.nextInt();
        // return if the entered number is not positive
        if (n < 0){
            System.out.println("You must enter a number >= 0");
            return;
        }
        
        // calculate e
        double e = 1.0;
        for (int counter = 1; counter <= n; counter++){
            int nFactorial = factorial(counter);
            e += 1.0 / nFactorial;
        }
        
        System.out.printf("Function e(%d) = %f%n",n, e);
        
    }
}
