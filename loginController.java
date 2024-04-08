package phase3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class loginController {
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	boolean login = false;
	
	public void loginNurse(ActionEvent e) {
		System.out.println("Sign In Button pressed");
		String stafloginfile = "staff_login.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(stafloginfile));
			String newLine;
			try {
				login = false;
				while((newLine = br.readLine()) != null) {
					String[] parts = newLine.split("\\$",5);
//					for(String a : parts) {
//						System.out.println(a);
//					}
						String usernameFile = parts[0];
						String passwordFile = parts[1];
						String type = parts[2];
						
						if(usernameFile.equals(username.getText()) && passwordFile.equals(password.getText()) && type.equals("N")) {
							System.out.print("Login Sucsessfull");
							login = true;
							//take to next screen
						}
				}
				if(!login) {
					System.out.println("Invalid Username or Password");
					//print a error label on UI
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void loginDoctor(ActionEvent e) {
		System.out.println("Sign In Button pressed");
		String stafloginfile = "staff_login.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(stafloginfile));
			String newLine;
			try {
				login = false;
				while((newLine = br.readLine()) != null) {
					String[] parts = newLine.split("\\$",5);
//					for(String a : parts) {
//						System.out.println(a);
//					}
						String usernameFile = parts[0];
						String passwordFile = parts[1];
						String type = parts[2];
						
						if(usernameFile.equals(username.getText()) && passwordFile.equals(password.getText()) && type.equals("D")) {
							System.out.print("Login Sucsessfull");
							login = true;
							//take to next screen
						}
				}
				if(!login) {
					System.out.println("Invalid Username or Password");
					//print a error label on UI
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
