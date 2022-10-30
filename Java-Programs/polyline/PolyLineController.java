/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package week3.polyline;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;

/**
 *
 * @author Reddogg
 */
public class PolyLineController{
    @FXML
    private Circle circle = new Circle(5.5); // Circle where cursor is
    
    @FXML
    private Pane drawPane;
    
    @FXML
    private Polyline polyline = new Polyline();
    
    @FXML
    void mousePositionStart(MouseEvent event) {
        // Sets the circle as the mouse's position
        circle.setCenterX(event.getX());
        circle.setCenterY(event.getY());
        
        if (polyline.getPoints().size() < 50){ // Polyline of 50 points
            // Add mouse's current to the polyline point
            polyline.getPoints().addAll(event.getX(),event.getY());
        }
        else {
            // Remove the last point
            // this approach does not work without removing >10 elements.
            // the mouse events are firing too fast to remove only 1 at a time
            polyline.getPoints().remove(0, 10);
        }
    }
    
    public void initialize(){
        drawPane.getChildren().add(circle); // Add circle to drawing pane
        drawPane.getChildren().add(polyline); // Polyline following the mouse hover
        polyline.setStrokeWidth(5); // line width
    }
}