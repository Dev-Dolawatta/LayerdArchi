package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDTO;

import java.io.IOException;
import java.sql.SQLException;

public class UpdatePatientViewController {
    @FXML
    private TextField lblPId;

    @FXML
    private TextField txtUpdatedName;

    @FXML
    private TextField txtUpdatedAddress;

    @FXML
    private AnchorPane updatePane;

    @FXML
    private TextField updatedAge;

    @FXML
    private TextField updatedBloodG;

    @FXML
    private ComboBox updatedCombo;

    @FXML
    private TextField updatedPhone;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);

    @FXML
    public void initialize() { updatedCombo.getItems().removeAll(updatedCombo.getItems()); updatedCombo.getItems().addAll("Male", "Female");


    }


    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        updatePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewManagePatientView.fxml"));
        updatePane.getChildren().add(pane);
    }

    @FXML
    void updatePatientOnClick(ActionEvent event) throws SQLException {
        PatientDTO patientDTO = new PatientDTO();
//        UpdatePatientModel updatePatientModel = new UpdatePatientModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        if(lblPId.getText().isEmpty() || txtUpdatedName.getText().isEmpty() || txtUpdatedAddress.getText().isEmpty()|| updatedCombo.getValue().toString() == null || updatedAge.getText().isEmpty() || updatedPhone.getText().isEmpty() || updatedBloodG.getText().isEmpty() ||updatedCombo.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all the fields first!");
            alert.showAndWait();
        }else {
            try {
                int age = Integer.parseInt(updatedAge.getText());
                int phone = Integer.parseInt(updatedPhone.getText());
                patientDTO.setPatientID(lblPId.getText());
                patientDTO.setPatientName(txtUpdatedName.getText());
                patientDTO.setAddress(txtUpdatedAddress.getText());
                patientDTO.setGender(updatedCombo.getValue().toString());
                patientDTO.setAge(Integer.parseInt(updatedAge.getText()));
                patientDTO.setPhone(Integer.parseInt(updatedPhone.getText()));
                patientDTO.setBloodGroup(updatedBloodG.getText());
            }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong Input!");
                alert.showAndWait();
            }
        }


        boolean value = patientBO.update(patientDTO);
        if(value){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully Updated");
            alert.showAndWait();
        }

    }



}
