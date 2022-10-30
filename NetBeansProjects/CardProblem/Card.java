/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam.cardproblem;

/**
 *
 * @author Reddogg
 */
public class Card {
    public String suit;
    public String faceValue;
    public static int numberOfCards; 
    
    Card(String suit, String faceValue){
        this.faceValue = faceValue;
        this.suit = suit;
        numberOfCards++;
    }
}