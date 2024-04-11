package application;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ErrorWindow extends Stage{
	public ErrorWindow(String label){
		setTitle("Warning");
		Label error = new Label(label);
		error.setTextFill(Color.RED);

		StackPane root = new StackPane(error);

        // Center the label within the StackPane
        StackPane.setAlignment(error, javafx.geometry.Pos.CENTER);

		
		setScene(new Scene(root, 500, 200));
		show();
	}
}
