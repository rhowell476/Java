/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package robotgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.Vector;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
/**
 *
 * @author Reddogg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField whichRobot;

    @FXML
    private Button selectRobotButton;
    
    private Integer robotPicked = 0;
    public static Vector<Robot> robots = new Vector<Robot>();
    
    @FXML
    private void print2D(ActionEvent event) {
        Robot.print2D();
        label.setText("Hello World!");
    }
    public void pickup(ActionEvent event) {
        robots.elementAt(robotPicked).pickup(robots.elementAt(robotPicked).getXLocation(),robots.elementAt(robotPicked).getYLocation());
        Robot.print2D();
    }
    public void dropOff(ActionEvent event) {
        robots.elementAt(robotPicked).dropOff(robots.elementAt(robotPicked).getXLocation(),robots.elementAt(robotPicked).getYLocation());
        Robot.print2D();
    }
    public void moveRight(ActionEvent event) {
        robots.elementAt(robotPicked).moveRight();
        Robot.print2D();
    }
    public void moveLeft(ActionEvent event) {
        robots.elementAt(robotPicked).moveLeft();
        Robot.print2D();
    }
    public void moveUp(ActionEvent event) {
        robots.elementAt(robotPicked).moveUp();
        Robot.print2D();
    }
    public void moveDown(ActionEvent event) {
        robots.elementAt(robotPicked).moveDown();
        Robot.print2D();
    }
    
    public void robotSelection(ActionEvent event){
        robotPicked = Integer.parseInt(whichRobot.getText());
        if (robotPicked == 2)
            robotPicked = 1;
        else if (robotPicked == 1)
            robotPicked = 0;
        else{
            whichRobot.setText("1 or 2");
            whichRobot.selectAll();
            whichRobot.requestFocus();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void initData(Robot robot){
        robots.add(robot);
        Robot.print2D();
        
    }
}
