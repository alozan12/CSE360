package phase3;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

public class Nurse extends Application{
	
	public static void main(String[] args) {
	       launch(args);
	   }
	
	public void start(Stage nurseStage1) {
		Parent root;
		try {
			System.out.print("Hello");
			root = FXMLLoader.load(getClass().getResource("Nurse.fxml"));
			
			Scene scene = new Scene(root, 900,600);
			
			nurseStage1.setScene(scene);
			nurseStage1.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
