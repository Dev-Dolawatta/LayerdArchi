package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.EmployeeBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.EmployeeDTO;

import java.io.IOException;
import java.sql.SQLException;

public class AddEmployeeViewController {
    @FXML
    private AnchorPane empRegisPane;

    @FXML
    private TextField txtClinicId;

    @FXML
    private ComboBox txtCombo;

    @FXML
    public void initialize() {
        txtCombo.getItems().removeAll(txtCombo.getItems()); txtCombo.getItems().addAll("Nurse", "Attendant");
    }

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOType.EmployeeBO);

    @FXML
    void addOnClick(ActionEvent event) throws SQLException {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if(txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtCombo.getValue().toString().isEmpty() || txtClinicId.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out all fields first!");
            alert.showAndWait();

        }
        else {
            employeeDTO.setEmpId(txtId.getText());
            employeeDTO.setEmplName(txtName.getText());
            employeeDTO.setEmpPosition(txtCombo.getValue().toString());
            employeeDTO.setClinicId(txtClinicId.getText());
        }

//        EmployeeModel employeeModel = new EmployeeModel();
//        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        EmployeeBO employeeBO = new EmployeeDAOImpl();//BEFORE MAKING BO FACTORY

        boolean added = employeeBO.add(employeeDTO);
        if(added){
            Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully added employee");
            alert.showAndWait();
        }
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        empRegisPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageEmployeeView.fxml"));
        empRegisPane.getChildren().add(pane);
    }
}
