/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Reddogg
 */
public class CalculatorController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField numberTextField;
    // numbers
    private final Integer one = 1;
    private final Integer two = 2;
    private final Integer three = 3;
    private final Integer four = 4;
    private final Integer five = 5;
    private final Integer six = 6;
    private final Integer seven = 7;
    private final Integer eight = 8;
    private final Integer nine = 9;
    private final Integer zero = 0;
    private final Character decimal = '.';
    
    // variables needed for calulating
    private static Double rightOperand = 0.0;
    private static Double result = 0.0;
    private static String operation = "";


    @FXML
    private void addOneToField(ActionEvent event) {
        numberTextField.appendText(one.toString());
        numberTextField.selectEnd();
    }
    @FXML
    private void addTwoToField(ActionEvent event) {
        numberTextField.appendText(two.toString());
    }
    @FXML
    private void addThreeToField(ActionEvent event) {
        numberTextField.appendText(three.toString());
    }
    @FXML
    private void addFourToField(ActionEvent event) {
        numberTextField.appendText(four.toString());
    }
    @FXML
    private void addFiveToField(ActionEvent event) {
        numberTextField.appendText(five.toString());
    }
    @FXML
    private void addSixToField(ActionEvent event) {
        numberTextField.appendText(six.toString());
    }
    @FXML
    private void addSevenToField(ActionEvent event) {
        numberTextField.appendText(seven.toString());
    }
    @FXML
    private void addEightToField(ActionEvent event) {
        numberTextField.appendText(eight.toString());
    }
    @FXML
    private void addNineToField(ActionEvent event) {
        numberTextField.appendText(nine.toString());
    }
    @FXML
    private void addZeroToField(ActionEvent event) {
        numberTextField.appendText(zero.toString());
    }
    @FXML
    private void addDecimalToField(ActionEvent event) {
        CharSequence s = ".";
        if (numberTextField.getText().contains(s)){
            return;
        }
        numberTextField.appendText(decimal.toString());
    }
    @FXML
    private void add(ActionEvent event) {
        rightOperand = Double.parseDouble(numberTextField.getText());
        numberTextField.setText("");
        operation = "add";
    }
    @FXML
    private void subtract(ActionEvent event) {
        rightOperand = Double.parseDouble(numberTextField.getText());
        numberTextField.setText("");
        operation = "subtract";
    }
    @FXML
    private void multiply(ActionEvent event) {
        rightOperand = Double.parseDouble(numberTextField.getText());
        numberTextField.setText("");
        operation = "multiply";
    }
    @FXML
    private void divide(ActionEvent event) {
        rightOperand = Double.parseDouble(numberTextField.getText());
        numberTextField.setText("");
        operation = "divide";
    }
    @FXML
    private void equals(ActionEvent event) {
        switch(operation){
            case "add":
                result = Double.parseDouble(numberTextField.getText()) + rightOperand;
                numberTextField.setText(result.toString());
                return;
            case "subtract":
                result = rightOperand - Double.parseDouble(numberTextField.getText()); //right operand is first for subtraction
                numberTextField.setText(result.toString());
                return;
            case "multiply":
                result = Double.parseDouble(numberTextField.getText()) * rightOperand;
                numberTextField.setText(result.toString());
                return;
            case "divide":
                result = rightOperand / Double.parseDouble(numberTextField.getText()); //right operand is first for division
                numberTextField.setText(result.toString());
                return;
            default:
                result = Double.parseDouble(numberTextField.getText());
                numberTextField.setText(result.toString());
        }
    }
    @FXML
    private void clear(ActionEvent event) {
        rightOperand = 0.0;
        result = 0.0;
        operation = "";
        numberTextField.setText("");
        numberTextField.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
