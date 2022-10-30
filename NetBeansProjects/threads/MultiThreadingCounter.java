/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.threads;

/**
 *
 * @author Reddogg
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingCounter {
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
            System.out.println("The counter is " + count);
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        Counter count1 = new Counter();
        Counter count2 = new Counter();
        Counter count3 = new Counter();
        
        executorService.execute(count1);
        executorService.execute(count2);
        executorService.execute(count3);

        executorService.shutdown();
        
    }
}
