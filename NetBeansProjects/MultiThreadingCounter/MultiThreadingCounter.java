/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.multithreadingcounter;

/**
 *
 * @author Reddogg
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThreadingCounter {
    public static int calls;
    
    static class Counter implements Runnable{
        int count;
        void inc(){
            count = count + 1;
        }
        int getCount() {
            return count;
        }
        @Override
        public void run(){
            for (int i = 0; i < calls; i++){
                inc();
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Input scanner
        ExecutorService executorService = Executors.newCachedThreadPool(); // Create a thread pool
        ArrayList<Counter> counters = new ArrayList<Counter>(); // Array of counters
        ArrayList<Thread> allThreads = new ArrayList<Thread>(); // Array of threads
        int threads; // store number of threads to create
        
        // Get input number of threads
        System.out.println("Enter number of threads: ");
        threads = input.nextInt();
        
        // Create counter objects
        for (int i = 0; i < threads; i++){
            Counter counter = new Counter();
            counters.add(counter);
        }
        
        // How many times to increment inc() method?
        System.out.println("Enter number of iterations: ");
        calls = input.nextInt();
        
        // Create threads
        int number = 1;
        for (Counter c : counters){
            executorService.execute(c);
            number++;
        }

        executorService.shutdown(); // terminate threads
        try { 
            // Main method --> wait for threads to finish
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.out.println("Thread Interrupted!");
        }
        
        // Output the counter count
        int count = 0;
        for (Counter c : counters){
            System.out.printf("Count%d: %d%n", count, c.count);
            count++;
        }
    }
}