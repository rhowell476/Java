/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package incdec;

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
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField numberTextField;
    
    private Integer number = 0;
    
    @FXML
    private void increment(ActionEvent event) {
        number = Integer.parseInt(numberTextField.getText());
        number++;
        numberTextField.setText(number.toString());
    }
    @FXML
    private void decrement(ActionEvent event) {
        number = Integer.parseInt(numberTextField.getText());
        number--;
        numberTextField.setText(number.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
