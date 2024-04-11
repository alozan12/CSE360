package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileRead {
	
	private String firstname;
	private String lastname;
	private String data;
	private static String filename;
	
	public FileRead() {}
	
	public static void updateChooseAVisit(String patientName, ListView<String> visits) {
		File file = new File("./src/" + patientName + "1.txt");
		
		int i = 1;
		while (file.exists()) {
			//visits.getItems().add("Visit 1");
			file = new File("./src/" + patientName + i);
		}
	}
	
	public String nurseChoosePatient(String uName) {
		String fullLine;
		String username;
		boolean found = false;
		File userNames = new File("./src/patient_login.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			while ((bReader.hasNextLine()) && (!found)) {
				fullLine = bReader.nextLine();
				int end = fullLine.indexOf(" ");
				username = fullLine.substring(0, end);
				System.out.println(username);
				if (username.equals(uName))
					found = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (found)
			return "This user exits. \n Please see the Current Patient tab for more information\n";
		else 
			return "This user does not exist. Please enter a valid username\n";
	
	}
	
	public String getFirstName(String username) {
		String firstName = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			bReader.nextLine();
			firstName = bReader.nextLine();	
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(firstName);
		return firstName;
	}
	
	public String getLastName(String username) {
		String lastName = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			bReader.nextLine();
			bReader.nextLine();
			lastName = bReader.nextLine();	
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lastName;
	}
	
	public String getDOB(String username) {
		String DOB = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			bReader.nextLine();
			bReader.nextLine();
			bReader.nextLine();
			DOB = bReader.nextLine();
			System.out.println(DOB);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DOB;
	}
	
	public String getEmail(String username) {
		String email = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			bReader.nextLine();
			bReader.nextLine();
			bReader.nextLine();
			bReader.nextLine();
			email = bReader.nextLine();	
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
	public String getHealthIssues(String username) {
		String healthHistory = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			for (int i = 0; i < 15; i++) {
				bReader.nextLine();
			}
			
			healthHistory = bReader.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return healthHistory;		
	}
	
	public String getImmun(String username) {
		String imun = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			for (int i = 0; i < 19; i++) {
				bReader.nextLine();
			}
			
			imun = bReader.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imun;	
	}
	
	public String getMedications(String username) {
		String meds = "";
		File userNames = new File("./src/" + username + "profiledata1.txt");
		
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (Scanner bReader = new Scanner(new FileReader(userNames))) {
		    //read each line, and then update the corresponding textFields
			for (int i = 0; i < 17; i++) {
				bReader.nextLine();
			}
			
			meds = bReader.nextLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(meds);
		return meds;	
	}
	/*
	//this method reads the patient information from the appropriate file and updates the profile view
	public static void readProfile(String firstname, String lastname) {
		filename = firstname + lastname + "profiledata.txt";
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write("Perseonal Data\n");
			writer.write(firstname+"\n"+lastname+"\n"+dob+"\n"+phonenumber+"\n"+email+"\n");
			writer.close();
			System.out.println("Data entered into file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//open the xxxxx_ScanInfo.txt file to get update scan info
		try (BufferedReader bReader = new BufferedReader(new FileReader(scanInfo))) {
		    //read each line, and then update the corresponding textFields
		    information = bReader.readLine();
		    totalAgaTF.setText(information);
		    information = bReader.readLine();
		    lmTF.appendText(information);
		    information = bReader.readLine();
		    ladTF.appendText(information);
		    information = bReader.readLine();
		    lcxTF.appendText(information);
		    information = bReader.readLine();
		    rcaTF.appendText(information);
		    information = bReader.readLine();
		    pdaTF.appendText(information); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writevitals(String firstname,String lastname, String weight, String height,String bodytemp,String bodypressure) {
		filename = firstname + lastname + "profiledata.txt";
		
		File file = new File(filename);
		if(file.exists()) {
			System.out.println("File found.");
		}
		else {
			System.out.print("No file found.");
			return;
		}
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write("Vitals\n");
			writer.write(weight+"\n"+height+"\n"+bodytemp+"\n"+bodypressure+"\n");
			writer.close();
			System.out.println("Vitals entered into file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writesummary(String firstname,String lastname, String summary) {
		filename = firstname + lastname + "profiledata.txt";
		
		File file = new File(filename);
		if(file.exists()) {
			System.out.println("File found.");
		}
		else {
			System.out.print("No file found.");
			return;
		}
		
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write("Visit Summary\n");
			writer.write(summary+"\n");
			writer.close();
			System.out.println("Summary entered into file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writecurrenthealth(String firstname,String lastname,String allergies,String healthconserns) {
		filename = firstname + lastname + "profiledata.txt";
		File file = new File(filename);
		if(file.exists()) {
			System.out.println("File found.");
		}
		else {
			System.out.print("No file found.");
			return;
		}
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write("Current Health\n");
			writer.write(allergies+"\n"+healthconserns+"\n");
			writer.close();
			System.out.println("current health entered into file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writehistory(String firstname,String lastname, String previoushealthissues,String previousprescribedmeds, String historyofimmunisation) {
		filename = firstname + lastname + "profiledata.txt";
		
		File file = new File(filename);
		if(file.exists()) {
			System.out.println("File found.");
		}
		else {
			System.out.print("No file found.");
			return;
		}
		
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.write("History\n");
			writer.write(previoushealthissues+"\n"+previousprescribedmeds+"\n"+historyofimmunisation+"\n");
			writer.close();
			System.out.println("History entered into file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
