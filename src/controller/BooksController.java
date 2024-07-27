package controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class BooksController {
    
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colCtName;

    @FXML
    private TableColumn<?, ?> colPbYear;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblCtName;

    @FXML
    private Label lblID;

    @FXML
    private Label lblPbYear;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtCtName;

    @FXML
    private TextField txtPbYear;

    @FXML
    private TextField txtTitle;

      @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
