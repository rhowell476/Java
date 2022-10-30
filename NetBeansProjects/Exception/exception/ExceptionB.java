/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3.exception;

/**
 *
 * @author Reddogg
 */
public class ExceptionB extends Throwable {
    private String message;
    
    ExceptionB(){
        message = "This is exception B.";
    }
    ExceptionB(String message){
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
