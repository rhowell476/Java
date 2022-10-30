/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package exam.cardproblem;

/**
 *
 * @author Reddogg
 */
import java.security.SecureRandom;

public class CardProblem {

    public static int loopCardProblem(Deck deck){
        SecureRandom randomNumbers = new SecureRandom();
        int spadeDraws = 0;
        int clubDraws = 0;
        int diamondDraws = 0;
        int heartDraws = 0;
        int numberOfPicks = 0;
        //Final part A - Problem 1
        
        while(spadeDraws == 0 || clubDraws == 0 || diamondDraws == 0 || heartDraws == 0) { //if any are zero, keep looping
            int pickACard = randomNumbers.nextInt(52);
            //{"Spades", "Clubs", "Diamonds", "Hearts"}, then increment total picks
            switch(deck.cardsInDeck.get(pickACard).suit){ 
                case "Spades":
                    spadeDraws++;
                    break;
                case "Clubs":
                    clubDraws++;
                    break;
                case "Diamonds":
                    diamondDraws++;
                    break;
                case "Hearts":
                    heartDraws++;
                    break;
            }
            numberOfPicks++;
            // print the card draws
            //System.out.println(deck.cardsInDeck.get(pickACard).faceValue + " of " + deck.cardsInDeck.get(pickACard).suit);
        }
        //System.out.println("The total number of picks was: " + numberOfPicks);
        return numberOfPicks;
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        int totalNumberOfPicks = 0;
        for(int i = 0; i < 10000; i++){
            double numberOfPicks = loopCardProblem(deck);
            totalNumberOfPicks += numberOfPicks;
        }
        System.out.println("Of 10,000 pulls, the total number of picks was: " + totalNumberOfPicks);
        System.out.println("The average number of picks is " + (totalNumberOfPicks / 10_000.0));

    }
}
