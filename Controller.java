package phase3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	
	public void createprofile(ActionEvent e) {
		System.out.print("Create volume");
		filewrite.createprofile(firstname.getText(), lastname.getText(), dob.getText(), phonenumber.getText(), email.getText());
	}
	
	public void submit(ActionEvent e) {
		System.out.print(weight.getText()+"\n"+height.getText()+"\n"+bodytemp.getText()+"\n"+bodypressure.getText()+"\n");
		filewrite.writevitals(firstnameN.getText(), lastnameN.getText(),weight.getText(), height.getText(), bodytemp.getText(), bodypressure.getText());
		
		filewrite.writecurrenthealth(firstnameN.getText(), lastnameN.getText(), allergies.getText(), healthconserns.getText());
		filewrite.writehistory(firstnameN.getText(), lastnameN.getText(), previoushealthissues.getText(), previousprescribedmeds.getText(), historyofimmunisation.getText());
	}
	public void saveinfodoctorsummary(ActionEvent e) {
		filewrite.writesummary(firstnameN.getText(), lastnameN.getText(), testFindings.getText()+"/n"+medication.getText());
	}
}
