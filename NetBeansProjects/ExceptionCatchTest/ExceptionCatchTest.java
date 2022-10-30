/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package week3.exceptioncatchtest;

/**
 *
 * @author Reddogg
 */
public class ExceptionCatchTest {
    public static void catchExceptionBwithA(String sentence){
        try{
            if (sentence.contains("test")){
                throw (new ExceptionB());
            }
        }
        catch (ExceptionA A){
            System.out.println(A.getMessage());
        }
    }
    public static void catchExceptionCwithA(String sentence){
        try{
            if (sentence.contains("is a ")){
                throw (new ExceptionC());
            }
        }
        catch (ExceptionA A){
            System.out.println(A.getMessage());
        }
    }
    public static void main(String[] args) {
        String sentence = "this is a test.";
        catchExceptionBwithA(sentence);
        catchExceptionCwithA(sentence);
    }
}
