package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	boolean login = false;
	
	public void loginNurse(ActionEvent e) {
		System.out.println("Sign In Button pressed");
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			String msg = "Please make sure all feilds are filled.";
			ErrorWindow error = new ErrorWindow(msg);
			error.show();
			return;
		}
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
					//String invalidpass = "Invalid Username or Password";
					ErrorWindow error = new ErrorWindow("Invalid Username or Password");
					error.show();
					br.close();
					return;
					
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
        Parent root;
		try {
//			primaryStage.close();
			Parent root2;
			root2 = loader.load();
	        Scene scene = new Scene(root2);
	        Stage primaryStage = new Stage();
	        SceneController controller = loader.getController();
	        controller.setPrimaryStage(primaryStage);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Medical Portal");
	        primaryStage.show();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void loginDoctor(ActionEvent e) {
		System.out.println("Sign In Button pressed");
		if(username.getText().isEmpty() || password.getText().isEmpty()) {
			String msg = "Please make sure all feilds are filled.";
			ErrorWindow error = new ErrorWindow(msg);
			error.show();
			return;
		}
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
					ErrorWindow error = new ErrorWindow("Invalid Username or Password");
					error.show();
					br.close();
					return;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Doctor UI.fxml"));
		try {
			Parent root1;
			root1 = loader.load();
	        Scene scene = new Scene(root1);
	        SceneController controller = loader.getController();
	        Stage primaryStage = new Stage();
	        controller.setPrimaryStage(primaryStage);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Medical Portal");
	        primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
