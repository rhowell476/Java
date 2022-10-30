/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package week3.vehicledemo;

/**
 *
 * @author Reddogg
 */
public class VehicleDemo {

    public static void main(String[] args) {
        Car ned = new Car("ned", 184, 6);
        Airplane aria = new Airplane("aria", 1567.4, 4);
        
        // compare vehicle's speed
        int fastest = ned.compareTo(aria);
        switch(fastest){
            case 1:
                System.out.println("Ned is faster.");
                break;
            case -1:
                System.out.println("Ned is slower.");
                break;
            case 0:
                System.out.println("The speeds are equal.");
        }
        System.out.println(ned.toString());
        System.out.println(aria.toString());
    }
}
