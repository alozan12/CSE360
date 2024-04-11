package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
//import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SceneController {
	private Stage primaryStage;
	
	void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	@FXML
	private TextField weight;
	@FXML
	private TextField height;
	@FXML
	private TextField bodytemp;
	@FXML
	private TextField bodypressure;
	@FXML
	private TextArea firstname;
	@FXML
	private TextArea lastname;
	@FXML
	private TextArea dob;
	@FXML
	private TextField firstnameN;
	@FXML
	private TextField lastnameN;
	@FXML
	private TextField dobN;
	@FXML
	private TextArea phonenumber;
	@FXML
	private TextArea email;
	@FXML
	private TextField previoushealthissues;
	@FXML
	private TextField previousprescribedmeds;
	@FXML
	private TextField historyofimmunisation;
	@FXML
	private TextField allergies;
	@FXML
	private TextField healthconserns;
	@FXML
	private TextField testFindings;
	@FXML
	private TextField medication;
	@FXML
	private TextArea username;
	@FXML
	private TextArea password;
	@FXML
	private TextArea confirmpass;
	
	
	public void createprofile(ActionEvent e) {
		System.out.print("Create profile is pressed");
		if(firstname.getText().isEmpty()||lastname.getText().isEmpty()||dob.getText().isEmpty()||phonenumber.getText().isEmpty()||email.getText().isEmpty()||username.getText().isEmpty()||password.getText().isEmpty()||confirmpass.getText().isEmpty()) {
			ErrorWindow error = new ErrorWindow("Please make sure all text feilds are filled.");
			error.show();
			return;
		}
		if(!password.getText().equals(confirmpass.getText())) {
			ErrorWindow error = new ErrorWindow("Password and Confirm password do not match.");
			error.show();
			return;
		}
		try {
			FileWriter fw = new FileWriter("patient_login.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(username.getText()+" "+password.getText()+"\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		filewrite.createprofile(username.getText(),firstname.getText(), lastname.getText(), dob.getText(), phonenumber.getText(), email.getText());
	}
	
	public void submit(ActionEvent e) {
		if(firstnameN.getText().isEmpty()||lastnameN.getText().isEmpty()||weight.getText().isEmpty()||height.getText().isEmpty()||bodytemp.getText().isEmpty()||bodypressure.getText().isEmpty()||allergies.getText().isEmpty()||healthconserns.getText().isEmpty()||previoushealthissues.getText().isEmpty()||previousprescribedmeds.getText().isEmpty()||historyofimmunisation.getText().isEmpty()) {
			ErrorWindow error = new ErrorWindow("Please make sure all text feilds are filled.");
			error.show();
			return;
		}
		System.out.print(weight.getText()+"\n"+height.getText()+"\n"+bodytemp.getText()+"\n"+bodypressure.getText()+"\n");
		filewrite.writevitals(firstnameN.getText(), lastnameN.getText(),weight.getText(), height.getText(), bodytemp.getText(), bodypressure.getText());
		
		filewrite.writecurrenthealth(firstnameN.getText(), lastnameN.getText(), allergies.getText(), healthconserns.getText());
		filewrite.writehistory(firstnameN.getText(), lastnameN.getText(), previoushealthissues.getText(), previousprescribedmeds.getText(), historyofimmunisation.getText());
	}
	public void saveinfodoctorsummary(ActionEvent e) {
		if(testFindings.getText().isEmpty()||medication.getText().isEmpty()) {
			ErrorWindow error = new ErrorWindow("Please make sure all text feilds are filled.");
			error.show();
			return;
		}
		filewrite.writesummary(firstnameN.getText(), lastnameN.getText(), testFindings.getText()+"/n"+medication.getText());
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
		System.out.print("Create profile is pressed");
		if(firstname.getText().isEmpty()||lastname.getText().isEmpty()||dob.getText().isEmpty()||phonenumber.getText().isEmpty()||email.getText().isEmpty()||username.getText().isEmpty()||password.getText().isEmpty()||confirmpass.getText().isEmpty()) {
			ErrorWindow error = new ErrorWindow("Please make sure all text feilds are filled.");
			error.show();
			return;
		}
		if(!password.getText().equals(confirmpass.getText())) {
			ErrorWindow error = new ErrorWindow("Password and Confirm password do not match.");
			error.show();
			return;
		}
		try {
			FileWriter fw = new FileWriter("patient_login.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(username.getText()+" "+password.getText()+"\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		filewrite.createprofile(username.getText(),firstname.getText(), lastname.getText(), dob.getText(), phonenumber.getText(), email.getText());
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
