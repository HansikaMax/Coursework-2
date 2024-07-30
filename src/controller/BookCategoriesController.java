package controller;

import com.jfoenix.controls.JFXButton;

import dto.BookCategoriesDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BookCategoriesController {
    
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<BookCategoriesDto> tblBookCategories;

    @FXML
    private TableColumn<BookCategoriesDto, Integer> colCategoryID;

    @FXML
    private TableColumn<BookCategoriesDto, String> colCategoryName;

    @FXML
    private TableColumn<BookCategoriesDto, String> colDescription;

    @FXML
    private Label lblCategoryID;

    @FXML
    private Label lblCategoryName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtCategoryID;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextField txtDescription;

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
