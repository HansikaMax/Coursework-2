package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.BookCategoriesDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ServiceFactory;
import service.custom.BookCategoriesService;

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
    void deleteOnAction(ActionEvent event) throws Exception {

       try {
       Integer categoryID=Integer.parseInt(txtCategoryID.getText());
       delete(categoryID);
       new Alert(Alert.AlertType.CONFIRMATION,"Book Category Deleted Successfully!!!").show();
       clearForm();
       loadTable();

       } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"Error While Deleting Book Category").show();
       }

    }

    @FXML
    void saveOnAction(ActionEvent event) {
     try {
        BookCategoriesDto bcDto=new BookCategoriesDto(Integer.parseInt(txtCategoryID.getText()),txtCategoryName.getText(),txtDescription.getText());
        save(bcDto);
         new Alert(Alert.AlertType.CONFIRMATION,"Book Category Saved Successfully!!!").show();
         clearForm();
         loadTable();
     } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"Error While Saving Book Category").show();
     }


    }

    @FXML
    void updateOnAction(ActionEvent event) {

       try {
            BookCategoriesDto bcDto=new BookCategoriesDto(Integer.parseInt(txtCategoryID.getText()),txtCategoryName.getText(),txtDescription.getText());
            update(bcDto);
             new Alert(Alert.AlertType.CONFIRMATION,"Book Category Updated Successfully!!!").show();
             clearForm();
             loadTable();
         } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Error While Updating Book Category").show();
         }
    
    }


    @FXML
    void selectOnMouseClicked(MouseEvent event) {
   BookCategoriesDto selectBCDto=tblBookCategories.getSelectionModel().getSelectedItem();
   txtCategoryID.setText(Integer.toString(selectBCDto.getCategoryID()));
   txtCategoryName.setText(selectBCDto.getCategoryName());
   txtDescription.setText(selectBCDto.getDescription());
    }


///////////
    private BookCategoriesService bcService = (BookCategoriesService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BookCategories);
    
    public String save(BookCategoriesDto bcDto) throws Exception{
       return bcService.save(bcDto);
    }

    public String update(BookCategoriesDto bcDto) throws Exception{
       return bcService.update(bcDto);
    }

    public String delete(Integer categoryID) throws Exception{
       return bcService.delete(categoryID);
    }

    public ArrayList<BookCategoriesDto> getAll() throws Exception{
       return bcService.getAll();
    }

    public BookCategoriesDto get(String categoryID) throws Exception{
        return null;
    }


////////////

 private void loadTable() throws Exception {
       
       ArrayList<BookCategoriesDto> bookCategoriesList=getAll();
      ObservableList<BookCategoriesDto> bcObservableList = FXCollections.observableArrayList();
      
      for(BookCategoriesDto bcDto: bookCategoriesList){
        bcObservableList.add(bcDto);
      }
      tblBookCategories.setItems(bcObservableList);
    }
     
    public void initialize() throws Exception {
           colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
      colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        loadTable();
    }

    private void clearForm(){
        txtCategoryID.setText("");
        txtCategoryName.setText("");
        txtDescription.setText("");
    }
}
