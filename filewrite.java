package phase3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class filewrite {
	
	private String firstname;
	private String lastname;
	private String data;
	private static String filename;
	private static int numVisit = 1;
	
	public filewrite() {
	}
	
	public static void checkforvisit(String firstname,String lastname) {
		String vfilename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
		try (BufferedReader br = new BufferedReader(new FileReader(vfilename))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                // Check if the line contains the target word
                if (line.contains("Visit Summary")) {
                    numVisit++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
	}
	
	public static void createprofile(String firstname,String lastname, String dob,String phonenumber, String email) {
		numVisit = 0;
		filename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
		String patientlistfile = "patientNames.txt";
		String messagefile = firstname+"_message.txt";
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
		try {
			FileWriter writer = new FileWriter(patientlistfile,true);
			writer.write(firstname+" "+lastname+"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File(messagefile);
		try {
			if(file.createNewFile()) {
				System.out.print("New File Created with name :"+messagefile);
			}else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writevitals(String firstname,String lastname, String weight, String height,String bodytemp,String bodypressure) {
		checkforvisit(firstname,lastname);
		filename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
		if(numVisit !=1) {
			File file = new File(filename);

            try {
				if (file.createNewFile()) {
				    System.out.println("File created: " + file.getName());
				} else {
				    System.out.println("File already exists.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
		checkforvisit(firstname,lastname);
		filename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
		
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
		checkforvisit(firstname,lastname);
		filename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
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
		checkforvisit(firstname,lastname);
		filename = firstname + lastname + "profiledata"+String.valueOf(numVisit)+".txt";
		
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
