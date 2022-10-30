/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.vehicledemo;

/**
 *
 * @author Reddogg
 */
public class Car extends Vehicle {
    private int number_of_cylinders;
    Car(){
        super("Car");
    }
    Car(String name) {
        super(name);
    }
    Car(String name, int cylinders) {
        super(name);
        number_of_cylinders = cylinders;
    }
    Car(String name, double speed, int cylinders) {
        super(name, speed);
        number_of_cylinders = cylinders;
    }
    public int getCylinders(){
        return number_of_cylinders;
    }
    public void setCylinders(int engines){
        number_of_cylinders = engines;
    }
    @Override
    public String toString(){
        String out = "Car, named " + this.getName() + ", has a max speed of " 
                + this.getSpeed() + " and has " + number_of_cylinders + " cylinders.";
        return out;
    }
}
