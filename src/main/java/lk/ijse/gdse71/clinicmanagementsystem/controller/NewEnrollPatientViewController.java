package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDTO;

import java.io.IOException;
import java.sql.SQLException;

public class NewEnrollPatientViewController {
    @FXML
    public ComboBox comboBox;

    @FXML
    public TextField patientNic;
    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField bloodGroup;

    @FXML
    private TextField patientId;

    @FXML
    private TextField patientName;

    @FXML
    private TextField phone;

    @FXML
    private Button AddPatient;

    @FXML
    private AnchorPane AddPatientPane;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);



    @FXML public void initialize() { comboBox.getItems().removeAll(comboBox.getItems()); comboBox.getItems().addAll("Male", "Female");

    }


    @FXML
    void AddOnClick(ActionEvent event) throws SQLException {
        PatientDTO patientDTO = new PatientDTO();

        if(patientNic.getText().isEmpty() || address.getText().isEmpty() || age.getText().isEmpty() || bloodGroup.getText().isEmpty() || patientName.getText().isEmpty() || phone.getText().isEmpty()|| comboBox.getValue() == null ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all the fields first!");
            alert.showAndWait();
            return;
        }
        else {
            try {
                patientDTO.setPatientID(patientNic.getText());
                patientDTO.setAddress(address.getText());
                patientDTO.setAge(Integer.parseInt(age.getText()));
                patientDTO.setBloodGroup(bloodGroup.getText());
                patientDTO.setGender(comboBox.getValue().toString());
                patientDTO.setPatientName(patientName.getText());
                patientDTO.setPhone(Integer.parseInt(phone.getText()));
            }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong Input!");
                alert.showAndWait();
                return;
            }
        }

//        AddPatientModel addPatientModel = new AddPatientModel();
//      boolean added = addPatientModel.addPatient(patientDTO);
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        boolean added = patientBO.add(patientDTO);
        if (added) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully added to Patient");
            alert.showAndWait();

        }



    }
    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        AddPatientPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ReceptionistView.fxml"));
        AddPatientPane.getChildren().add(pane);
    }



}
