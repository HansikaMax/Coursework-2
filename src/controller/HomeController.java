package controller;



import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {
    
      @FXML
    private JFXButton btnBookType;

    @FXML
    private JFXButton btnBooks;

    @FXML
    private JFXButton btnBorrowBooks;

    @FXML
    private JFXButton btnMembers;

    @FXML
    private JFXButton btnOverdueMembers;

    @FXML
    private Label lblTitle;

    @FXML
    void bookTypesOnAction(ActionEvent event) {

    }

    @FXML
    void booksOnAction(ActionEvent event) throws IOException {
      URL resource = this.getClass().getResource("/view/Books.fxml");
      Parent root = FXMLLoader.load(resource);
      Stage stage=new Stage();
      stage.setScene(new Scene(root));
      stage.show();
      stage.setTitle("Books Form");

    }

    @FXML
    void borrowBooksOnAction(ActionEvent event) {

    }

    @FXML
    void membersOnAction(ActionEvent event) throws IOException {
      URL resource = this.getClass().getResource("/view/Members.fxml");
      Parent root = FXMLLoader.load(resource);
      Stage stage=new Stage();
      stage.setScene(new Scene(root));
      stage.show();
      stage.setTitle("Members Form");
    }

    @FXML
    void overdueMembersOnAction(ActionEvent event) {

    }

}
