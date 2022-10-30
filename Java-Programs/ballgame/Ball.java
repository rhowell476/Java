/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ballgame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Reddogg
 */
public class Ball extends Circle {

    private double x;
    private double y;
    private double radius;
    private double xSpeed;
    private double ySpeed;
    public Circle theBall;
    public Pane pane;

    // Ball constructor
    public Ball(Pane pane, double x, double y, double radius, double speed){
        this.x = x; // x Position
        this.y = y; // y Position
        this.radius = radius;
        this.xSpeed = speed; // Speed in x direction
        this.ySpeed = speed; // Speed in y direction
        this.pane = pane;
        
        theBall = new Circle(x, y, radius*2); // Create a circle
        theBall.setFill(Color.RED); // Circle color
        pane.getChildren().add(theBall); // Add circle to pane
        
        // Circle position in pane
        System.out.println("Pane width: " + theBall.getCenterX() + " Pand height: " + theBall.getCenterY());
    }

    // Ball movement
    public void moveBall(){
        // Checks whether circle is within left/right bounds
        if (theBall.getCenterX() <= 0 || 
            theBall.getCenterX() >= pane.getWidth() - theBall.getRadius()){
            setxSpeed(xSpeed * -1); // invert speed
        }
        // Checks wheter circle is within top/bottom bounds
        if (theBall.getCenterY() <= 0 || 
            theBall.getCenterY() >= pane.getHeight() - theBall.getRadius()){
            setySpeed(ySpeed * -1); // invert speed
        }

        // Move the ball center coordinates
        theBall.setCenterX(theBall.getCenterX() + xSpeed);
        theBall.setCenterY(theBall.getCenterY() + ySpeed);

        System.out.println("CenterX: " + theBall.getCenterX() + " CetnerY: " + theBall.getCenterY()); // Output ball's position
    }

    // Ball velocity in x direction
    public double getxSpeed() {
        return xSpeed;
    }

    // Set x velocity
    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    // Ball velocity in y direction
    public double getySpeed() {
        return ySpeed;
    }

    // Set y velocity
    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    
    
}
