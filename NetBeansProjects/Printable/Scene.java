/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc272.printable;

/**
 *
 * @author Reddogg
 */
public class Scene implements Printable {
    String city;
    Scene(String city){
        this.city = city;
    }
    
    @Override
    public void Print() {
        System.out.println("The city's name is: " + city);
    }
}
