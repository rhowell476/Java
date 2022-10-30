/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.exceptioncatchtest;

/**
 *
 * @author Reddogg
 */
public class ExceptionB extends ExceptionA{
    ExceptionB(){
        super();
        setMessage("Exception B circumstance.");
    }
    ExceptionB(String message){
        super(message);
    }
}
