/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package week3.exception;

import java.io.IOException;

/**
 *
 * @author Reddogg
 */
public class Exception {
    public static void tryNullPointerException(String MESSAGE){
        try{
            if (MESSAGE.length() != 0) {
                System.out.println(MESSAGE);
            }
            else {
                System.out.print("Exception 3: ");
                throw (new NullPointerException());
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    public static void tryIOException(String Hive){
        try{
            if (Hive.equals("C:\\NU")) {
                System.out.print("Exception 4: ");
                throw (new IOException("Check NU folder location."));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String string = "This message is correct.";
        String exceptionTest = "This test is not an exception";
        String hive = "C:\\NU";
        try {
            if (string.length() > 5) {
                System.out.print("Exception 1: ");
                throw (new ExceptionA("The message is too long."));
            }
        }
        catch (ExceptionA a) {
            System.out.println(a.getMessage());
        }
       
        try{
              if (string.length() > 10) {
                  System.out.print("Exception 2: ");
                throw (new ExceptionB("The message is still too long."));
            }          
        }
        catch (ExceptionB b) {
            System.out.println(b.getMessage());
        }
        
        tryNullPointerException(exceptionTest);
        tryIOException(hive);
    }
}
