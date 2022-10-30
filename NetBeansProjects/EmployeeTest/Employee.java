/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1.employeetest;

/**
 *
 * @author Reddogg
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    
    Employee(String firstName, String lastName, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    
    // get and set functions
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public double getSalary(){
        return salary;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setSalary(double salary){
        if (salary > 0)
            this.salary = salary;
    }
    
    // yearly salary and raise functions
    public double yearlySalary() {
        return salary * 12;
    }
            
    public void giveRaise() {
        salary += salary * 10/100;
    }
}
