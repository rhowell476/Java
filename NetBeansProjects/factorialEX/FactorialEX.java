/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package factorialEX;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;
public class FactorialEX {

    // calculate x^n
    public static int xpowerN(int n, int count){
        int value = n;
        if (n == 1)
            return n;
        for (int exponent = 1; exponent < count; exponent++){
            value *= n;
        }
        return value;
    }
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
        System.out.println("Enter the power of e to calculate (ex: e^x): "
                + "\n...The number must be a non-negative integer: ");
        int N = scanner.nextInt();
        // return if the entered number is not positive
        if (N < 0){
            System.out.println("You must enter a number >= 0");
            return;
        }
        System.out.println("Enter a number of terms to calculate e. "
                + "\n...The number must be a non-negative integer: ");
        int n = scanner.nextInt();
        // return if the entered number is not positive
        if (n < 0){
            System.out.println("You must enter a number >= 0");
            return;
        }
        
        // calculate e^x
        double e = 1.0;
        for (int counter = 1; counter <= n; counter++){
            double nFactorial = factorial(counter);
            double xpowern = xpowerN(N, counter);
            e += xpowern / nFactorial;
        }
        // print the result
        System.out.printf("Function e^%d = %f%n",N, e);
    }
}
