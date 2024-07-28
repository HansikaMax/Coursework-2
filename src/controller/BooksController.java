package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.BooksDto;
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
import service.custom.BooksService;

public class BooksController {
    
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;


    @FXML
    private TableView<BooksDto> tblBooks;


    @FXML
    private TableColumn<BooksDto, String> colAuthor;

    @FXML
    private TableColumn<BooksDto, Integer> colBookID;

    @FXML
    private TableColumn<BooksDto, String> colCtName;

    @FXML
    private TableColumn<BooksDto, String> colPbYear;

    @FXML
    private TableColumn<BooksDto, String> colTitle;

    @FXML
    private TableColumn<BooksDto, String> colStatus;

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
    try {
        Integer bookID= Integer.parseInt(txtBookID.getText());
        delete(bookID);
        new Alert(Alert.AlertType.CONFIRMATION,"Book Deleted Successfully!!!").show();
        clearForm();
        loadTable();
    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"Error While Deleting Book").show();
    }

    }

    @FXML
    void saveOnAction(ActionEvent event) throws Exception {
    try{
     BooksDto booksDto=new BooksDto(Integer.parseInt(txtBookID.getText()), txtTitle.getText(), txtAuthor.getText(), Integer.parseInt(txtPbYear.getText()),txtCtName.getText(),null);
     save(booksDto);
     new Alert(Alert.AlertType.CONFIRMATION,"Book Saved Successfully!!!").show();
    clearForm();
    loadTable();

    }   catch(Exception ex){
        ex.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"Error While Saving Book").show();
    }

    }

    @FXML
    void updateOnAction(ActionEvent event) {
try {
    BooksDto booksDto=new BooksDto(Integer.parseInt(txtBookID.getText()), txtTitle.getText(), txtAuthor.getText(), Integer.parseInt(txtPbYear.getText()),txtCtName.getText(),null);
    update(booksDto);
    new Alert(Alert.AlertType.CONFIRMATION,"Book Updated Successfully!!!").show();
    clearForm();
    loadTable();
} catch (Exception e) {
    e.printStackTrace();
     new Alert(Alert.AlertType.ERROR,"Error While Updating Book").show();
}

    }


    @FXML
    void selectOnMouseClicked(MouseEvent event) {
        BooksDto selectBooksDto=tblBooks.getSelectionModel().getSelectedItem();
        txtBookID.setText(Integer.toString(selectBooksDto.getBookID()));
        txtTitle.setText(selectBooksDto.getTitle());
        txtAuthor.setText(selectBooksDto.getAuthor());
        txtPbYear.setText(Integer.toString(selectBooksDto.getPublicationYear()));
        txtCtName.setText(selectBooksDto.getCategoryName());
        
    }

///////////
    private BooksService booksService = (BooksService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Books);
    
    public String save(BooksDto booksDto) throws Exception{
       return booksService.save(booksDto);
    }

    public String update(BooksDto booksDto) throws Exception{
       return booksService.update(booksDto);
    }

    public String delete(Integer bookID) throws Exception{
       return booksService.delete(bookID);
    }

    public ArrayList<BooksDto> getAll() throws Exception{
       return booksService.getAll();
    }

    public BooksDto get(String itemCode) throws Exception{
        return null;
    }

////////////
    private void loadTable() throws Exception {
       
       ArrayList<BooksDto> booksList=getAll();
      ObservableList<BooksDto> booksObservableList = FXCollections.observableArrayList();
      
      for(BooksDto booksDto: booksList){
        booksObservableList.add(booksDto);
      }
        tblBooks.setItems(booksObservableList);
    }
        

        public void initialize() throws Exception {
            colBookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor .setCellValueFactory(new PropertyValueFactory<>("author"));
        colPbYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
        colCtName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadTable();
    }

    private void clearForm(){
        txtBookID.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtPbYear.setText("");
        txtCtName.setText("");
    }
}
