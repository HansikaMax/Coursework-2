package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;


import dto.BorrowedBooksDto;
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
import service.ServiceFactory;

import service.custom.BorrowedBooksService;

public class BorrowedBooksController {
    
    @FXML
    private JFXButton btnUpdate;

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
    private Label txtacrDay;

    @FXML
    private Label txtacrDay1;

    @FXML
    private TableView<BorrowedBooksDto> tblBorrowedBooks;

    @FXML
    private TextField txtLatefee;

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
    private TextField txtActualReturnDay;

    @FXML
    void saveOnAction(ActionEvent event) {
try {
    BorrowedBooksDto dto=new BorrowedBooksDto(Integer.parseInt(txtBorrowID.getText()), Integer.parseInt(txtBookID.getText()), txtBookName.getText(),Integer.parseInt(txtMemberID.getText()),txtBorrowDate.getText(),txtReturnDate.getText(),txtActualReturnDay.getText(),Double.parseDouble(txtLatefee.getSelectedText()));
     save(dto);
     new Alert(Alert.AlertType.CONFIRMATION,"Borrowed Book Saved Successfully!!!").show();
    clearForm();
    loadTable();
} catch (Exception ex) {
    ex.printStackTrace();
    new Alert(Alert.AlertType.ERROR,"Error While Saving Borrowed Book").show();
}

    }

    @FXML
    void deleteOnAction(ActionEvent event) {
try {
    Integer borrowID=Integer.parseInt(txtBorrowID.getText());
delete(borrowID);
new Alert(Alert.AlertType.CONFIRMATION,"Borrowed Book deleted Successfully!!!").show();
    clearForm();
    loadTable();

} catch (Exception e) {
    e.printStackTrace();
    new Alert(Alert.AlertType.ERROR,"Error While deleting Borrowed Book").show();
}
    }

    @FXML
    void updateOnAction(ActionEvent event) {

        try {
            BorrowedBooksDto dto=new BorrowedBooksDto(Integer.parseInt(txtBorrowID.getText()), Integer.parseInt(txtBookID.getText()), txtBookName.getText(),Integer.parseInt(txtMemberID.getText()),txtBorrowDate.getText(),txtReturnDate.getText(),txtActualReturnDay.getText(),Double.parseDouble(txtLatefee.getSelectedText()));
             update(dto);
             new Alert(Alert.AlertType.CONFIRMATION,"Borrowed Book updated Successfully!!!").show();
            clearForm();
            loadTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Error While updating Borrowed Book").show();
        }
    }


///////////
    private BorrowedBooksService borrowedbooksService = (BorrowedBooksService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BorrowedBooks);
    
    public String save(BorrowedBooksDto borrowedbooksDto) throws Exception{
       return borrowedbooksService.save(borrowedbooksDto);
    }

    public String update(BorrowedBooksDto borrowedbooksDto) throws Exception{
       return borrowedbooksService.update(borrowedbooksDto);
    }

    public String delete(Integer borrowID) throws Exception{
       return borrowedbooksService.delete(borrowID);
    }

    public ArrayList<BorrowedBooksDto> getAll() throws Exception{
       return borrowedbooksService.getAll();
    }

    public BorrowedBooksDto get(Integer borrowID) throws Exception{
        return null;
    }

////////////
 private void loadTable() throws Exception {
       
       ArrayList<BorrowedBooksDto> booksList=getAll();
      ObservableList<BorrowedBooksDto> booksObservableList = FXCollections.observableArrayList();
      
      for(BorrowedBooksDto booksDto: booksList){
        booksObservableList.add(booksDto);
      }
        tblBorrowedBooks.setItems(booksObservableList);
    }
        

        public void initialize() throws Exception {
        colBorrowID .setCellValueFactory(new PropertyValueFactory<>("borrowID"));
        colBookID .setCellValueFactory(new PropertyValueFactory<>("bookID"));
        colBookName .setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colMemberID .setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colBorrowDate .setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colActualReturnDate.setCellValueFactory(new PropertyValueFactory<>("actualReturnDate"));
        colLateFee.setCellValueFactory(new PropertyValueFactory<>("lateFee"));

        loadTable();
    }
    
    private void clearForm(){
        txtBorrowID.setText("");
       txtBookID .setText("");
       txtBookName.setText("");
        txtMemberID.setText("");
        txtBorrowDate.setText("");
        txtReturnDate.setText("");
        txtActualReturnDay.setText("");
        txtLatefee.setText("");
    }


}


