/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.primenumbers;

/**
 *
 * @author Reddogg
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class PrimeNumbers {

    //Entry point - Calculates the prime factors of a number
    public static void main(String[] args) {
        //Create linked list of prime factors
        LinkedList<Long> factors= new LinkedList<>(); // contains all prime factors
        Map<Long, Long> primeFactors= new HashMap<>(); //key-value pairs <Key:primenumber, value:multiple>
        Scanner scan = new Scanner(System.in);
        long number = 0;
        boolean inputValid = false;
        
        //User input
        while (!inputValid){
            try {
                System.out.println("Enter a number: ");
                number = scan.nextLong();
                if (number < 2){
                    System.out.println("Invalid number.");
                    throw new InputMismatchException();
                }
                else {
                    inputValid = true;
                }
            }
            catch (InputMismatchException e) { //Outside of range or is not a Long
                System.out.println("Outside of number range: 2 - 9223372036854775807.");
                scan.nextLine();
            }
        }
        long isPrime = number; // Used through calculation
        if (isPrime == 2){  //Special case for the number 2
            factors.add(isPrime);
        }
        else{
            //Calculate prime factors
            for(long i = 2; i< isPrime; i++) {
                while(isPrime%i == 0) {
                   factors.add(i);
                   isPrime = isPrime/i;
                }
            }
            if (isPrime > 2)
                factors.add(isPrime);
        }
        // Iterates all the prime factors. Adds to a Map
        Iterator<Long> itr = factors.iterator();
        while (itr.hasNext()){
            long factor = itr.next();
            if (primeFactors.containsKey(factor)){ // Increment key value
                long count = primeFactors.get(factor);
                primeFactors.put(factor, count+1);
            }
            else {
                primeFactors.put(factor, 1L); // Build map key; value = 1
            }
        }
        
        // Populate set with numbers from map keys
        Set<Long> primes = primeFactors.keySet(); // The set is the map's keys
        if (factors.get(0) == number){ // Prime number if only one key exists
                System.out.printf("%n%d is a prime number.", factors.get(0));
            }
        else { // Print the prime factors and the count
            System.out.println("%nThe primes map is: \nPrime\tCount");
            for (long key : primes){
                System.out.printf("%d\t%d\n", key, primeFactors.get(key));
            }
        }
        
    }
}
