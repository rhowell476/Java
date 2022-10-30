/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package simplecalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Reddogg
 */
public class calculatorController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField firstNumberTextField;
    
    @FXML
    private TextField secondNumberTextField;
    
    @FXML
    private TextArea sumTextArea;
    
    private Double firstNumber;
    private Double secondNumber;
    private Double sum;
    
    @FXML
    private void sum(ActionEvent event) {
        try{
            firstNumber = Double.parseDouble(firstNumberTextField.getText());
        }
        catch (NumberFormatException e){
            firstNumberTextField.setText("Enter number");
            firstNumberTextField.selectAll();
            firstNumberTextField.requestFocus();
        }
        try {
            secondNumber = Double.parseDouble(secondNumberTextField.getText());
            sum = firstNumber + secondNumber;
            sumTextArea.setText(sum.toString());
        }
        catch (NumberFormatException e){
            secondNumberTextField.setText("Enter number");
            secondNumberTextField.selectAll();
            secondNumberTextField.requestFocus();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void diff(ActionEvent event) {
        try{
            firstNumber = Double.parseDouble(firstNumberTextField.getText());
        }
        catch (NumberFormatException e){
            firstNumberTextField.setText("Enter number");
            firstNumberTextField.selectAll();
            firstNumberTextField.requestFocus();
        }
        try {
            secondNumber = Double.parseDouble(secondNumberTextField.getText());
            sum = firstNumber - secondNumber;
            sumTextArea.setText(sum.toString());
        }
        catch (NumberFormatException e){
            secondNumberTextField.setText("Enter number");
            secondNumberTextField.selectAll();
            secondNumberTextField.requestFocus();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void prod(ActionEvent event) {
        try{
            firstNumber = Double.parseDouble(firstNumberTextField.getText());
        }
        catch (NumberFormatException e){
            firstNumberTextField.setText("Enter number");
            firstNumberTextField.selectAll();
            firstNumberTextField.requestFocus();
        }
        try {
            secondNumber = Double.parseDouble(secondNumberTextField.getText());
            sum = firstNumber * secondNumber;
            sumTextArea.setText(sum.toString());
        }
        catch (NumberFormatException e){
            secondNumberTextField.setText("Enter number");
            secondNumberTextField.selectAll();
            secondNumberTextField.requestFocus();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void quot(ActionEvent event) {
        try{
            firstNumber = Double.parseDouble(firstNumberTextField.getText());
        }
        catch (NumberFormatException e){
            firstNumberTextField.setText("Enter number");
            firstNumberTextField.selectAll();
            firstNumberTextField.requestFocus();
        }
        try {
            secondNumber = Double.parseDouble(secondNumberTextField.getText());
            sum = firstNumber / secondNumber;
            sumTextArea.setText(sum.toString());
        }
        catch (NumberFormatException e){
            secondNumberTextField.setText("Enter number");
            secondNumberTextField.selectAll();
            secondNumberTextField.requestFocus();
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void clear(ActionEvent event) {
        firstNumberTextField.setText("Enter number");
        secondNumberTextField.setText("Enter number");
        sumTextArea.setText(null);
        firstNumberTextField.selectAll();
        firstNumberTextField.requestFocus();
    }
    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
