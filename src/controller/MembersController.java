package controller;

import java.util.ArrayList;

import dto.MembersDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.ServiceFactory;
import service.custom.MembersService;

public class MembersController {
    
     @FXML
    private Button btnAddMember;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnUpdateMember;

    @FXML
    private TableView<MembersDto> tableViewMembers;

    @FXML
    private TableColumn<MembersDto, String> colAddress;

    @FXML
    private TableColumn<MembersDto, String> colBirthDate;

    @FXML
    private TableColumn<MembersDto, String> colEmail;

    @FXML
    private TableColumn<MembersDto, String> colFirstName;

    @FXML
    private TableColumn<MembersDto, String> colGender;

    @FXML
    private TableColumn<MembersDto, String> colLastName;

    @FXML
    private TableColumn<MembersDto, Integer> colMemberID;

    @FXML
    private TableColumn<MembersDto, String> colNumber;

    @FXML
    private Label lblMemberID;


    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBirthDate;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtMemberID;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBirthDate;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void addOnAction(ActionEvent event) {
    try{
     MembersDto membersDto=new MembersDto(Integer.parseInt(txtMemberID.getText()),txtFirstName.getText(),txtLastName.getText(),txtGender.getText(),txtBirthDate.getText(),txtAddress.getText(),txtPhoneNumber.getText(),txtEmail.getText());
     save(membersDto);
     new Alert(Alert.AlertType.CONFIRMATION,"Member Saved Successfully!!!").show();
    clearForm();
    loadTable();

    }   catch(Exception ex){
        ex.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"Error While Saving Member").show();
    }

    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        try {
            Integer memberID= Integer.parseInt(txtMemberID.getText());
            delete(memberID);
            new Alert(Alert.AlertType.CONFIRMATION,"Member Deleted Successfully!!!").show();
            clearForm();
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Error While Deleting Member").show();
        }
    
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        try{
            MembersDto membersDto=new MembersDto(Integer.parseInt(txtMemberID.getText()),txtFirstName.getText(),txtLastName.getText(),txtGender.getText(),txtBirthDate.getText(),txtAddress.getText(),txtPhoneNumber.getText(),txtEmail.getText());
            update(membersDto);
            new Alert(Alert.AlertType.CONFIRMATION,"Member Updated Successfully!!!").show();
           clearForm();
           loadTable();
       
           }   catch(Exception ex){
               ex.printStackTrace();
               new Alert(Alert.AlertType.ERROR,"Error While Updating Member").show();
           }    
    }

    @FXML
    void selectOnMouseClicked(MouseEvent event) {
         MembersDto selectMembersDto=tableViewMembers.getSelectionModel().getSelectedItem();
         txtMemberID.setText(Integer.toString(selectMembersDto.getMemberID()));
         txtFirstName.setText(selectMembersDto.getFirstName());
         txtLastName.setText(selectMembersDto.getLastName());
         txtGender.setText(selectMembersDto.getGender());
         txtBirthDate.setText(selectMembersDto.getBirthDate());
         txtAddress.setText(selectMembersDto.getAddress());
         txtPhoneNumber.setText(selectMembersDto.getPhoneNumber());
         txtEmail.setText(selectMembersDto.getEmail());
    }


    ///////////
    private MembersService membersService = (MembersService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Members);
    
    public String save(MembersDto membersDto) throws Exception{
       return membersService.save(membersDto);
    }

    public String update(MembersDto membersDto) throws Exception{
       return membersService.update(membersDto);
    }

    public String delete(Integer memberID) throws Exception{
       return membersService.delete(memberID);
    }

    public ArrayList<MembersDto> getAll() throws Exception{
       return membersService.getAll();
    }

    public MembersDto get(Integer memberID) throws Exception{
        return null;
    }

////////////

   private void loadTable() throws Exception {
       
       ArrayList<MembersDto> membersList=getAll();
      ObservableList<MembersDto> membersObservableList = FXCollections.observableArrayList();
      
      for(MembersDto membersDto: membersList){
        membersObservableList.add(membersDto);
      }
      tableViewMembers.setItems(membersObservableList);
    }
   
     public void initialize() throws Exception {
        colMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colFirstName .setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName .setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadTable();
    }

    private void clearForm(){
        txtMemberID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtGender.setText("");
        txtBirthDate.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
        txtEmail.setText("");
    }
}
