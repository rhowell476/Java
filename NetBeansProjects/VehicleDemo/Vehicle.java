/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.vehicledemo;

/**
 *
 * @author Reddogg
 */
public class Vehicle implements Comparable{
    private String name;
    private double max_speed;
    
    Vehicle(){
        name = "Vehicle";
        max_speed = 0;
    }
    Vehicle(String name) {
        this.name = name;
        max_speed = 0;
    }
    Vehicle(String name, double speed) {
        this.name = name;
        max_speed = speed;
    }
    public String getName(){
        return name;
    }
    public double getSpeed(){
        return max_speed;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMaxSpeed(int speed){
        max_speed = speed;
    }
    @Override
    public int compareTo(Object a){
        Vehicle vehicle = (Vehicle)a;
        double speed1 = this.max_speed;
        double speed2 = vehicle.max_speed;
        //return 1 if the speed is faster
        if (speed1 > speed2)
            return 1;
        //return -1 if the speed is slower
        else if (speed1 < speed2)
            return -1;
        //return 0 if speed is the same
        else
            return 0;
        
    }
    
    @Override
    public String toString(){
        String out = name + " has a max speed of " + max_speed;
        return out;
    }
}
