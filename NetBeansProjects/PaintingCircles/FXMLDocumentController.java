/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package paintingcircles;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Reddogg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private RadioButton blueRadioButton;
    
    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private Pane drawingPane;
    
    @FXML
    private Circle newCircle;
    private Color[] COLORS = {Color.GREEN, Color.RED, Color.BLUE};
    private Color SelectedColor = COLORS[1];
    
    ArrayList<Circle> circles = new ArrayList<>();
    
    @FXML
    void createBall(MouseEvent e) {
        newCircle = new Circle(e.getX(), e.getY(), 10); // Create new circle
        newCircle.setFill(SelectedColor); // Set the circle color
        
        circles.add(newCircle); // Add circle to array
        int last = circles.size() -1 ; //Last index of array
        drawingPane.getChildren().add(circles.get(last));
    }
    
    @FXML
    void changeColorToGreen() {
        SelectedColor = COLORS[0];
        for (Circle c : circles){
            c.setFill(SelectedColor);
        }

        greenRadioButton.setSelected(true);
        greenRadioButton.requestFocus();

    }

    @FXML
    void changeColorToRed() {
        SelectedColor = COLORS[1];
        for (Circle c : circles){
            c.setFill(SelectedColor);
        }
        
        redRadioButton.setSelected(true);
        redRadioButton.requestFocus();
    }

    @FXML
    void changeColorToBlue() {
        SelectedColor = COLORS[2];
        for (Circle c : circles){
            c.setFill(SelectedColor);
        }
        
        blueRadioButton.setSelected(true);
        blueRadioButton.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set the radio buttons color
        
        // Green radio button
        greenRadioButton.setUserData(COLORS[0]);
        greenRadioButton.setToggleGroup(toggleGroup);
        
        // Red radio button - selected on startup
        redRadioButton.setUserData(COLORS[1]);
        redRadioButton.setToggleGroup(toggleGroup);
        redRadioButton.setSelected(true);
        redRadioButton.requestFocus();

        // Blue radio button
        blueRadioButton.setUserData(COLORS[2]);
        blueRadioButton.setToggleGroup(toggleGroup);

    }    
    
}
