package phase3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class filewrite {
	
	private String firstname;
	private String lastname;
	private String data;
	private static String filename;
	
	public filewrite() {
	}
	
	public static void createprofile(String firstname,String lastname, String dob,String phonenumber, String email) {
		filename = firstname + lastname + "profiledata.txt";
		firstname = firstname.trim();
		lastname = lastname.trim();
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
}
