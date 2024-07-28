package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class LoginController {
    
     @FXML
    private AnchorPane root;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Label titleLabel;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void enterOnAction(ActionEvent event) throws IOException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        if (isValidCredentials(username, password)) {
           new Alert(Alert.AlertType.CONFIRMATION,"Login successful!").show();

           this.root.getChildren().clear();
           Parent node = FXMLLoader.load(this.getClass().getResource("/view/Home.fxml"));
           this.root.getChildren().add(node);
        } else {
            new Alert(Alert.AlertType.ERROR,"Wrong username or password").show();
        }
    }
    private boolean isValidCredentials(String username, String password) {
        // Hardcoded credentials for demonstration purposes
        String validUsername = "admin";
        String validPassword = "password";

        return username.equals(validUsername) && password.equals(validPassword);
    }
}
