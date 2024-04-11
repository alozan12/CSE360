package application;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.stage.Stage;
//import application.SceneController;

public class Main extends Application {

	private Stage primaryStage;
	
	public void start(Stage primaryStage) throws Exception {
		SceneController sceneController = new SceneController();
		WelcomeScreen init = new WelcomeScreen(primaryStage, sceneController);
		init.start(primaryStage);
		
		//Below is if an FXML file were used for initial scene instead of java file
		/*this.primaryStage = primaryStage;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Doctor UI.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Medical Portal");
		primaryStage.show();
		
		SceneController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);*/
	}
	public static void main(String[] args) {
		launch(args);
	}
}