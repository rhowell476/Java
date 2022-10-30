/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package robotgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static robotgame.Robot.grid;

/**
 *
 * @author Reddogg
 */
public class RobotGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //1. Define 2D array and initialize to blank
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                grid[j][i] = ' ';
            }
        }
        // place charaters on the map
        grid[10][8] = 'B';
        grid[22][4] = 'C';
        Robot.print2D();
        
        //2. Create two robots using two constructors and print location
        FXMLDocumentController robotControl = new FXMLDocumentController();
        Robot R1 = new Robot(20,4,' ');
        robotControl.initData(R1); // new robot initialized
        Robot R2 = new Robot();
        robotControl.initData(R2); // new robot initialized
        // map is printed when robots are initialized
        
        //3. Move method R1 and R2 to locations and print locations
        R1.MoveTo(23, 24);
        R2.MoveTo(15, 3);
        Robot.print2D();
        
        //4. Direct R1 to pick up B and drop at a different location
        R1.MoveTo(10, 8);
        R1.pickup(10, 8);
        R1.MoveTo(20, 20);
        R1.dropOff(20, 20);
        Robot.print2D();
        
        //5. Direct R2 pick up C and drop off at a different location
        R2.MoveTo(22, 4);
        R2.pickup(22, 4);
        R2.MoveTo(0, 0);
        R2.dropOff(0, 0);
        Robot.print2D();

        launch(args);
        
        
    }
    
}
