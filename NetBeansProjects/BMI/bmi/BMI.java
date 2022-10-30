/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package week1.bmi;

/**
 *
 * @author Reddogg
 */
import java.util.Scanner;
public class BMI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // get input height and weight
        System.out.println("Enter your weight in pounds: ");
        double weight = input.nextInt();
        System.out.println("Enter your height in inches: ");
        double height = input.nextInt();
        
        // calculate BMI
        double BMI = weight * 703 / (height * height);
        
        System.out.printf("%n%s %f%n%n","Your body mass index is:", BMI);
        System.out.println("BMI VALUES");
        System.out.print("Underweight: less than 18.5\n"
                + "Normal: between 18.5 and 24.9\n"
                + "Overweight: between 25 and 29.9\n"
                + "Obese: 30 or greater");
    }
}
