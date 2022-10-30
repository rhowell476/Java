/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc272.palindromes;

import java.util.Scanner;


/**
 *
 * @author Reddogg
 */
//For loop checking if palindrome
//    for (int i = 0; i <= (str.length())/2; i++){
//        if (str.charAt(i) == str.charAt(str.length() - i - 1)){
//        System.out.printf("Char " + i + " is : " + str.charAt(i) + "\nChar " + (str.length() - i - 1) + " is: " + str.charAt(str.length() - i - 1) + "\n");
//        }
//    }

public class Palindromes {
    //DEBUG: public static int counter = 0;
    
    // Recursive function if a string is a palindrome
    public static boolean recursivePalindromeCheck(String s){
        // DEBUG: System.out.println("Check: " + counter + " is: " + s);
        
        // Invalid if string length is not 2 or greater
        if (s.length() <= 1){
            return true;
        }
        // Check first and last character
        if (s.charAt(0) == s.charAt(s.length() - 1)){
            s = s.substring(1, (s.length() - 1));
            //DEBUG: counter++;
            return recursivePalindromeCheck(s);
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a palindrome: ");
        String OriginalEntry = input.nextLine();
        String palindrome = OriginalEntry;
        palindrome = palindrome.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        boolean isPalindrome;
        isPalindrome = recursivePalindromeCheck(palindrome);
        // Print results of the palindrome check function
        System.out.printf("\nPalindrome check result: \n%s", 
            isPalindrome ? "String \"" + OriginalEntry + "\" is a palindrome": 
            "Not a palindrome.");
    }
}
