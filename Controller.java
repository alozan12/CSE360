
/*
 * 
 * THIS IS THE CONTROLLER FOR THE STAFF  MESSAGING
 * 
 */

package application;

import javafx.scene.effect.DropShadow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;


public class Controller {
    String fName = ""; // first Name of patient global 
    
    public String currentUser = SceneController.global.getCurrentPatient();



    @FXML
    private VBox patientList; // This matches the fx:id of the VBox in the FXML
    @FXML
    private VBox messageDisplayArea;
    @FXML
    private Text patientName;
    @FXML
    private Button btnSendMessage;
    @FXML
    private TextField messageText;
    
    
    /*
     * These functions are used in the messaging system of Nurse and Doctor
     */
    
    @FXML
    public void initialize() {
        try {
            patientList.getChildren().clear();
            System.out.println("Initialize");
            List<String> allNames = Files.readAllLines(Paths.get("/Users/abe/git/spring2023Proj/phase3/src/application/patientNames.txt"));
            for (String fullName : allNames) {
                String firstName = fullName.split(" ")[0]; // Extracting the first name 	
                HBox hBox = new HBox(10);
                VBox vbox = new VBox(5);

                StackPane imageContainer = new StackPane();
                ImageView imageView = new ImageView(new Image("file:/Users/abe/git/spring2023Proj/phase3/src/application/user.png"));
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                imageContainer.getChildren().add(imageView);

                VBox.setMargin(imageContainer, new Insets(1, 5, 20, 5));
                HBox.setMargin(imageContainer, new Insets(15, 0, 0, 5));

                Label nameLabel = new Label(fullName);
                nameLabel.setStyle("-fx-font-size: 14px; -fx-font-family: \"Verdana\"; -fx-font-weight:bold; ");

                vbox.getChildren().add(nameLabel);

                VBox.setMargin(nameLabel, new Insets(15, 5, 5, 5));

                hBox.getChildren().addAll(imageContainer, vbox);

                Pane pane = new Pane(hBox);
                pane.setStyle("-fx-background-color: #e1eefa; -fx-background-radius: 10; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 10; -fx-padding: 10;");

                DropShadow dropShadow = new DropShadow();
                dropShadow.setColor(Color.GRAY);
                dropShadow.setRadius(10.0);
                dropShadow.setOffsetX(5.0);
                dropShadow.setOffsetY(5.0);

                pane.setUserData(firstName); // Attaching the first name as user data to the pane

                // Handling mouse events
                pane.setOnMouseClicked(event -> {
                    fName = firstName;

                    Pane clickedPane = (Pane) event.getSource();
                    String clickedPatientFirstName = (String) clickedPane.getUserData();
                    patientName.setText("Patient: " + fullName);

                    String filename = clickedPatientFirstName + "_messages.txt"; // Using first name in the file path
                    Path filePath = Paths.get("/Users/abe/git/spring2023Proj/phase3/src/application/", filename);

                    try {
                        List<String> lines = Files.readAllLines(filePath);
                        List<Message> messages = MessageService.parseMessagesFromText(lines);
                       displayMessages(messages);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                

                pane.setOnMouseEntered(event -> pane.setEffect(dropShadow));
                pane.setOnMouseExited(event -> pane.setEffect(null));

                patientList.getChildren().add(pane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void displayMessages(List<Message> messages) {
        System.out.println("IN HERE B");

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
            if( currentUser.equals("Nurse") ||  currentUser.equals("Doctor")) {
	            // Adjust the alignment based on the sender
	            if (message.getSender().equals("Nurse") || message.getSender().equals("Doctor")|| message.getSender().equals("Staff")) { // Make sure staffId is accessible here
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
            
            System.out.println("END");

            messageDisplayArea.getChildren().add(messageBox);
        }
    }

    @FXML
    private void sendMessage() {
        // Assuming the owner's ID is 'owner' and it's correctly set
        // Assuming 'patientName' Text control contains the receiver's ID in "Patient ID: {ID}" format
        
       String theSender ="";
       String theReceiver = "";
       
       
       if(currentUser.equals("Nurse")) {
    	   theSender = "Nurse";
    	   theReceiver = "Patient";
       }
       else if(currentUser.equals("Doctor")) {
    	   theSender = "Doctor";
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
    
    
  //Handling Scene transitions from Java file to FXML file
  	EventHandler<ActionEvent> enterDUI2(Stage primaryStage) throws IOException {
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
  	
  
  	
  	//Handling Scene Transitions from FXML file to FXML file
  	//Misc Scene Changes
  	@FXML
      private void switchToPatientHistory2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientHistory.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Patient History");
          SceneController.primaryStage.show();
      }
  	//Patient Related Scene Changes
  	@FXML
      private void switchToProfileTab2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("profileTab.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Patient Profile");
          SceneController.primaryStage.show();
      }

  	@FXML
      private void switchToPVS2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("visitSummary.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Visit Summary");
          SceneController.primaryStage.show();
      }
  	//Nurse Related Scene Changes
  	@FXML
      private void switchToNCP2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("NurseCurrentPatient.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Patient Information");
          SceneController.primaryStage.show();
      }
  	@FXML 
  	void switchToNUI2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Medical Portal");
          SceneController.primaryStage.show();
      }
  	@FXML
      private void switchToNVS2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Nursevisitsummary.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Visit Summary");
          SceneController.primaryStage.show();
      }
  	
  	
  	//Doctor Related Scene Changes
  	@FXML
      private void switchToDCP2(ActionEvent event) throws IOException {
  		
  		//second name is 
          FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorCurrPatient.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Patient Information");
          SceneController.primaryStage.show();
      }
  	@FXML 
  	void switchToDUI2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Doctor UI.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Medical Portal");
          SceneController.primaryStage.show();
      }
  	@FXML
      private void switchToDVS2(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorVisitSummary.fxml"));
          Parent root = loader.load();
          Scene scene = new Scene(root);
          SceneController controller = loader.getController();
          controller.setPrimaryStage(SceneController.primaryStage);
          SceneController.primaryStage.setScene(scene);
          SceneController.primaryStage.setTitle("Visit Summary");
          SceneController.primaryStage.show();
      }
  	

}

