/*
 * 
 * THIS IS THE CONTROLLER FOR THE PATIENT MESSAGING
 * 
 */

package application;
import javafx.scene.effect.DropShadow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane; // Import the Pane class
import javafx.scene.layout.StackPane;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Controller2 {
    String patientN = "";
    String fName = "Abraham";
    String flName = "Abraham Lozano";
    CurrentUser global = new CurrentUser();
    public String currentUser = global.getCurrentPatient();

    @FXML
    private VBox messageDisplayArea;
    @FXML
    private Text patientName;
    @FXML
    private Button btnSendMessage;
    @FXML
    private TextField messageText;
    
    @FXML
    public void initialize() {
    	
    	  
    	  try {
    		  patientName.setText("Messages from my Doctor and Nurse");
    		   Path filePath = Paths.get("/Users/abe/git/spring2023Proj/phase3/src/application/" + fName + "_messages.txt");
    		   List<String> lines = Files.readAllLines(filePath);
               List<Message> messages = MessageService.parseMessagesFromText(lines);
               displayMessages(messages);
          } catch (IOException e) {
              e.printStackTrace();
          }
    
   } 

  
    private void displayMessages(List<Message> messages) {

        messageDisplayArea.getChildren().clear();
        for (Message message : messages) {
            VBox messageBox = new VBox();
            Label senderLabel = new Label("" + message.getSender());
            
            //)------
            Label contentLabel = new Label("" + message.getContent());
            contentLabel.setWrapText(true); // Allows the label to wrap text if it's too long

            // Create a StackPane and add the label to it
            StackPane contentPane = new StackPane();
            contentPane.getChildren().add(contentLabel);

            
            //-_____
            Label timestampLabel = new Label("" + message.getTimestamp().format(DateTimeFormatter.ISO_DATE_TIME));
       
            contentLabel.setWrapText(true);
            timestampLabel.setStyle("-fx-text-fill:#909090");
            messageBox.getChildren().addAll(senderLabel,  contentPane, timestampLabel);
            if(currentUser.equals("Staff")) {
	            // Adjust the alignment based on the sender
	            if (message.getSender().equals("Staff")) { // Make sure staffId is accessible here
	           	 	contentLabel.setStyle("-fx-text-fill:white ");
	            	 contentPane.setStyle("-fx-background-color:  #39447E; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-padding: 10;-fx-text-fill:white ");

	            	 contentPane.setMaxWidth(250); // Set the maximum width to 200 pixels
	            	 
	            	contentPane.setAlignment(Pos.CENTER_RIGHT);
	                messageBox.setAlignment(Pos.CENTER_RIGHT);
	            } else {
	                contentPane.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-padding: 10;");

	                contentPane.setMaxWidth(250); // Set the maximum width to 200 pixels

	            	contentPane.setAlignment(Pos.CENTER_LEFT);
	
	                messageBox.setAlignment(Pos.CENTER_LEFT);
	            }
            }
            else {
	            	
	            if (message.getSender().equals("Patient")) { // Make sure staffId is accessible here
	           	 	contentLabel.setStyle("-fx-text-fill:white ");
	            	 contentPane.setStyle("-fx-background-color:  #39447E; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-padding: 10;-fx-text-fill:white ");
	                 contentPane.setMaxWidth(300); // Set the maximum width to 200 pixels
	            	contentPane.setAlignment(Pos.CENTER_RIGHT);
	                messageBox.setAlignment(Pos.CENTER_RIGHT);
	            } else {
	                contentPane.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-padding: 10;");
	                contentPane.setMaxWidth(300); // Set the maximum width to 200 pixels
	
	            	contentPane.setAlignment(Pos.CENTER_LEFT);
	
	                messageBox.setAlignment(Pos.CENTER_LEFT);
	            }
            }
            
            messageDisplayArea.getChildren().add(messageBox);
        }
    }

    @FXML
    private void sendMessage() {
        // Assuming the owner's ID is 'owner' and it's correctly set
        // Assuming 'patientName' Text control contains the receiver's ID in "Patient ID: {ID}" format
        
       String theSender ="";
       String theReceiver = "";
       
       
       if(currentUser.equals("Nurse") || currentUser.equals("Doctor")) {
    	   theSender = "Staff";
    	   theReceiver = "Patient";
       }
       else {
    	   
    	   theSender = "Patient";
    	   theReceiver = "Staff";
       }
        
        
        
        // Create a Message object
        LocalDateTime now = LocalDateTime.now();
        String content = messageText.getText();
        Message message = new Message(theSender, theReceiver, now, content);
        
        // Determine the file name based on sender and receiver
        String filename = fName + "_messages.txt";
        Path filePath = Paths.get("/Users/abe/git/spring2023Proj/phase3/src/application/", filename);
        
        try {
            // Append the new message to the file
            Files.writeString(filePath, message.toString() + "\n\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Message sent and saved.");
            
            // Reread the updated message file
            List<String> lines = Files.readAllLines(filePath);
            // Call MessageService to parse these lines into messages
            List<Message> messages = MessageService.parseMessagesFromText(lines);
            // Update the display with the new list of messages
            displayMessages(messages);
            messageText.clear();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to save the message.");
        }
    
    }
    

}

