/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ballgame;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Reddogg
 */
public class BallGameController implements Initializable {
    
    @FXML
    private Pane ballpitPane;
    
    @FXML
    private Button button;
    
    private Ball ballOne;
    
    private ArrayList<Ball> balls = new ArrayList<Ball>(); // Store all balls

    // Create a new ball with each mouse click
    @FXML
    private void newBall(MouseEvent e) {
        ballOne = new Ball(ballpitPane, e.getX(), e.getY(), 5, 10); // Call ball constructor
        int last = balls.size() - 1; // Last ball index
        balls.add(ballOne); // Add ball to list
        try {
            startBall(); // Function for ball movement
        } catch (InterruptedException ex) {
        }
    }
    
    // Create a thread breaking every 40 ms to show coordinate movement
    @FXML
    private void startBall() throws InterruptedException{
        
        // Thread containing ball movement
        Runnable moveTheBall = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++){
                    Platform.runLater(new Runnable() { // Anonymous inner class
                        @Override
                        public void run() {
                            // Begin ball movement
                            balls.get(balls.size() - 1).moveBall();
                        }
                    });
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        System.out.println("Thread interrupted!");
                        ex.printStackTrace();
                    }
                }
            }
        };

        // Create a thread utilizing Runnable
        Thread currentBallThread = new Thread(moveTheBall);
        currentBallThread.setDaemon(true); // Daemon thread -- runs as long as application is open
        currentBallThread.start(); // Begin thread
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
