/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.exceptioncatchtest;

/**
 *
 * @author Reddogg
 */
public class ExceptionA extends Throwable{
    private String message;
    
    ExceptionA(){
        message = "This is superclass exception A.";
    }
    ExceptionA(String message){
        this.message = message;
    }
    @Override
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
