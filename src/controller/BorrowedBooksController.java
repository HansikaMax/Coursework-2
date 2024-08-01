package controller;

import com.jfoenix.controls.JFXButton;

import dto.BorrowedBooksDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BorrowedBooksController {
    
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableColumn<BorrowedBooksDto, String> colActualReturnDate;

    @FXML
    private TableColumn<BorrowedBooksDto, Integer> colBookID;

    @FXML
    private TableColumn<BorrowedBooksDto, String> colBookName;

    @FXML
    private TableColumn<BorrowedBooksDto, String> colBorrowDate;

    @FXML
    private TableColumn<BorrowedBooksDto, Integer> colBorrowID;

    @FXML
    private TableColumn<BorrowedBooksDto, Double> colLateFee;

    @FXML
    private TableColumn<BorrowedBooksDto, Integer> colMemberID;

    @FXML
    private TableColumn<BorrowedBooksDto, String> colReturnDate;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblBorrowID;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblReturnDate;

    @FXML
    private TableView<?> tblBorrowedBooks;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtBorrowDate;

    @FXML
    private TextField txtBorrowID;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtReturnDate;

    @FXML
    void addOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }
}
