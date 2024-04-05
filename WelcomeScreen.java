package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the primary stage
        primaryStage.setTitle("Login Screen");

        // Create a GridPane and set its properties
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: lightgrey;");
        gridPane.setVgap(20);

        // Create and set properties of the welcome Text
        Text welcomeText = new Text("Welcome!");
        welcomeText.setFont(new Font(30));
        welcomeText.setFill(Color.PURPLE);

        // Create and set properties of the username TextField
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setPrefWidth(200);

        // Create and set properties of the password PasswordField
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefWidth(200);

        // Create and set properties of the sign in Button
        Button signInButton = new Button("Sign In");
        signInButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        signInButton.setPrefWidth(200);

        // Create and set properties of the create account Hyperlink
        Hyperlink createAccountLink = new Hyperlink("New? Create Account");
        createAccountLink.setTextFill(Color.BLUE);
        createAccountLink.setOnAction(event -> openAccountTypeWindow());

        // Add the nodes to the gridPane
        gridPane.add(welcomeText, 0, 0);
        gridPane.add(usernameField, 0, 1);
        gridPane.add(passwordField, 0, 2);
        gridPane.add(signInButton, 0, 3);
        gridPane.add(createAccountLink, 0, 4);

        // Center the nodes horizontally in the gridPane
        GridPane.setHalignment(welcomeText, HPos.CENTER);
        GridPane.setHalignment(usernameField, HPos.CENTER);
        GridPane.setHalignment(passwordField, HPos.CENTER);
        GridPane.setHalignment(signInButton, HPos.CENTER);
        GridPane.setHalignment(createAccountLink, HPos.CENTER);

        // Create a Scene with the gridPane and set it on the primaryStage
        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openAccountTypeWindow() {
        // Create a new Stage
        Stage accountTypeStage = new Stage();
        accountTypeStage.setTitle("Create Account");

        // Create a GridPane and set its properties
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(30);
        gridPane.setStyle("-fx-background-color: lightgrey;");

        // Create and set properties of the title Text
        Text title = new Text("Choose Role");
        title.setFont(new Font(30));
        title.setFill(Color.PURPLE);
        GridPane.setHalignment(title, HPos.CENTER);

        // Create and set properties of the doctor Button
        Button doctorButton = new Button("Create Doctor Account");
        doctorButton.setPrefWidth(200);
        doctorButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        // Create and set properties of the nurse Button
        Button nurseButton = new Button("Create Nurse Account");
        nurseButton.setPrefWidth(200);
        nurseButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        // Create and set properties of the patient Button
        Button patientButton = new Button("Create Patient Account");
        patientButton.setPrefWidth(200);
        patientButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        // Add the nodes to the gridPane
        gridPane.add(title, 1, 0);
        gridPane.add(doctorButton, 0, 2);
        gridPane.add(nurseButton, 1, 2);
        gridPane.add(patientButton, 2, 2);

        // Create a Scene with the gridPane and set it on the accountTypeStage
        Scene scene = new Scene(gridPane, 500, 400);
        accountTypeStage.setScene(scene);
        accountTypeStage.show();
    }

    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}