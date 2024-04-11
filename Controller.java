package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class Controller {
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
	@FXML
	private Text myLabel;
	
	
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
		myLabel.setText("My text is here");
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
}
