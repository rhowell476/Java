/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package craps;

/**
 *
 * @author rhowe
 */

public class Game {
    public static void main(String[] args){

        int[][] frequency = new int[2][22]; // array of frequency counters
        Craps craps = new Craps();
        
        // play 60,000,000 times use roll number as frequency index
        for (int roll = 1; roll <= 60_000_000; roll++) {
            int results = craps.play(); //0-21 means win; 22-43 means loase
            if (results <= 21){
                ++frequency[0][results]; // index 1 through 21 are WIN
            }
            else {
                results -= 21;
                ++frequency[1][results]; // index 22 through 43 are LOSE
            }
        } 

        // output win elements frequencies
        System.out.println("The frequency of Wins by number of rolls it took to win.:");
        System.out.printf("%s%12s%n", "Rolls", "Frequency");
        
        int sumWins = 0;
        int sumLose = 0;
        for (int rolls = 0; rolls < frequency[0].length; rolls++) {
        sumWins += frequency[0][rolls];
        System.out.printf("%4d%12d%n", rolls, frequency[0][rolls]);
        }
        
        // output lose elements frequencies
        System.out.println("\n\nThe frequency of Losses by number of rolls it took to lose.:");
        System.out.printf("%s%12s%n", "Rolls", "Frequency");
        
        for (int rolls = 0; rolls < frequency[1].length; rolls++) {
        sumLose += frequency[1][rolls];
        System.out.printf("%4d%12d%n", rolls, frequency[1][rolls]);
        }
        
        // What are the chances of winning at craps?
        System.out.println("\n\nWhat are the chances of winning at craps?");
        double sum = sumWins + sumLose;
        double wins = sumWins / sum;
        System.out.printf("The number of wins is %d out of %.0f total games.%n", sumWins, sum);
        System.out.println("Chances of winning are " + wins);
        
        // What are the chances of losing at craps?
        double losses = sumLose / sum;
        System.out.printf("The number of losses is %d out of %.0f total games.%n", sumLose, sum);
        System.out.println("Chances of losing are " + losses);
        System.out.println();
        
        // What is the average length of a game of craps?
        double newsumWins = 0.0;
        double averages[] = new double[22];
        for (int rolls = 1; rolls < frequency[0].length; rolls++) {
            double divider = (double)rolls;
            newsumWins = frequency[0][rolls];
            averages[rolls] = frequency[0][rolls] * (1 / divider);
        }
        double average = 0;
        for(int i=0; i < 22;i++){ 
            average += averages[i];
        }
        System.out.println("\nThe average length of a game of craps is "
                + average / newsumWins);
        System.out.println("\n");
        
        // Do changes of winning improve with the length of the game?
        double freqWin = 0;
        for (int rolls = 0; rolls < frequency[0].length; rolls++) {
        freqWin = (double)frequency[0][rolls] / sumWins;
        System.out.printf("Frequency of wins that take %d rolls is %f%n", rolls, freqWin);
        }
    }
}
