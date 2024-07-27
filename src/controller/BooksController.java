package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.jfoenix.controls.JFXButton;

import dto.BooksDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

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

}
