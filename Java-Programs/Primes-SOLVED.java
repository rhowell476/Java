/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package primes;

/**
 *
 * @author Reddogg
 */
public class Primes {

    public static void main(String[] args) {
        
        // create boolean array of 1000 elements. Initialize all elements to true
        boolean[] isPrime = new boolean[1000];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        
        int counter;
        int whichNumber;
        for (int i = 2; i <= 500; i++){
        counter = 2;
            if (isPrime[i] == true) {
                whichNumber = i;
                while (whichNumber*counter <= 999){
                    isPrime[whichNumber*counter]=false; // calculate which numbers are multiples of counter; prime numbers remain true
                    counter++; //increment counter
                }
            }
        }

        // show if number is prime 9true/false)
        for (int i = 2; i < 1000;i++){
            System.out.print("is " + i + " prime? ");
            System.out.print(isPrime[i] ? "PRIME\n" : "not prime\n");
        }
    }
}
