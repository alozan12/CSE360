package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {
	private Stage primaryStage;
	
	void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	//Handling Scene transitions from Java file to FXML file
	EventHandler<ActionEvent> enterDUI(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Portal");
        primaryStage.show();
		return null;
	}
	
	//Scene Transition for Profile Creation currently not working
	EventHandler<ActionEvent> enterProfileCreation(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profileCreation.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Profile Creator");
        primaryStage.show();
		return null;
	}
	
	//Handling Scene Transitions from FXML file to FXML file
	
	//Patient Related Scene Changes
	@FXML
    private void switchToProfileTab(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profileTab.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Profile");
        primaryStage.show();
    }
	@FXML
    private void switchToPMsg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("patientMessage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Messaging");
        primaryStage.show();
    }
	@FXML
    private void switchToPVS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("visitSummary.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Visit Summary");
        primaryStage.show();
    }
	//Nurse Related Scene Changes
	@FXML
    private void switchToNCP(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NurseCurrentPatient.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Information");
        primaryStage.show();
    }
	@FXML 
	void switchToNUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Portal");
        primaryStage.show();
    }
	@FXML
    private void switchToNVS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Nursevisitsummary.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Visit Summary");
        primaryStage.show();
    }
	@FXML
	private void switchToNMsg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("messageNurse.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Messaging");
        primaryStage.show();
    }
	@FXML
    private void switchToNursePatientHistory(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NursePatientHistory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient History");
        primaryStage.show();
    }
	//Doctor Related Scene Changes
	@FXML
    private void switchToDCP(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorCurrPatient.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Information");
        primaryStage.show();
    }
	@FXML 
	void switchToDUI(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Doctor UI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Medical Portal");
        primaryStage.show();
    }
	@FXML
    private void switchToDVS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorVisitSummary.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Visit Summary");
        primaryStage.show();
    }
	@FXML
	private void switchToDMsg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("messageDoctor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Messaging");
        primaryStage.show();
    }
	@FXML
    private void switchToPatientHistory(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientHistory.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient History");
        primaryStage.show();
    }
}
