/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.vehicledemo;

/**
 *
 * @author Reddogg
 */
public class Airplane extends Vehicle {
    private int number_of_engines;
    Airplane(){
        super("Airplane");
    }
    Airplane(String name) {
        super(name);
    }
    Airplane(String name, int engines) {
        super(name);
        number_of_engines = engines;
    }
    Airplane(String name, double speed, int engines) {
        super(name, speed);
        number_of_engines = engines;
    }
    public int getEngines(){
        return number_of_engines;
    }
    public void setEngines(int engines){
        number_of_engines = engines;
    }
    @Override
    public String toString(){
        String out = "Airplane, named " + this.getName() + ", has a max speed of " 
                + this.getSpeed() + " and has " + number_of_engines + " engines.";
        return out;
    }
}
