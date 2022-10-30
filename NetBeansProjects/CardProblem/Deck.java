/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam.cardproblem;

import java.util.ArrayList;

/**
 *
 * @author Reddogg
 */
public class Deck {
    public static int numberOfDecks;
    private String faceValue;
    private String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
    public ArrayList<Card> cardsInDeck = new ArrayList<Card>();
    
    Deck(){
        for (int i = 0; i < 4; i ++){ //Iterate through suits
            for (int j = 1; j <= 13; j ++){
                switch(j){
                    case 1:
                        faceValue = "A";
                        break;
                    case 2:
                        faceValue = "2";
                        break;
                    case 3:
                        faceValue = "3";
                        break;
                    case 4:
                        faceValue = "4";
                        break;
                    case 5:
                        faceValue = "5";
                        break;
                    case 6:
                        faceValue = "6";
                        break;
                    case 7:
                        faceValue = "7";
                        break;
                    case 8:
                        faceValue = "8";
                        break;
                    case 9:
                        faceValue = "9";
                        break;
                    case 10:
                        faceValue = "10";
                        break;
                    case 11:
                        faceValue = "J";
                        break;
                    case 12:
                        faceValue = "Q";
                        break;
                    case 13:
                        faceValue = "K";
                        break;
                    default:
                        System.out.println("INVALID");
                }
                // Add card to the deck
                cardsInDeck.add(new Card(suits[i], faceValue));
            }
        }
        numberOfDecks++;
    }
}
