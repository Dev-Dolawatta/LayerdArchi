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
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientCurrentDetailDTO;

import java.io.IOException;
import java.sql.SQLException;

public class DocUIViewController {

    @FXML
    public ComboBox OPDCombo;
    @FXML
    private TextField txtBloodP;

    @FXML
    private TextField txtHeartR;

    @FXML
    private TextField txtPatientId;

    @FXML
    private TextField txtStatus;

    @FXML
    private AnchorPane OPDPane;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);


    @FXML public void initialize() {
        OPDCombo.getItems().removeAll(OPDCombo.getItems()); OPDCombo.getItems().addAll("Medical", "Surgical","Cardiac","Urology","Gyn&Obs","Psychiatric","Pain Management","Dermatology","PreOperative","Orthopeadiac","Peadiatric","Nuerology");
    }

    @FXML
    void AddClinicOnClick(ActionEvent event) throws SQLException {
        PatientCurrentDetailDTO patientCurrentDetailDTO = new PatientCurrentDetailDTO();
        if(txtPatientId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fill out the fields first!");
            alert.showAndWait();
        }
        else {
            patientCurrentDetailDTO.setPatientId(txtPatientId.getText());
            patientCurrentDetailDTO.setBloodPressure(txtBloodP.getText());
            patientCurrentDetailDTO.setHeartRate(txtHeartR.getText());
            patientCurrentDetailDTO.setStatus(txtStatus.getText());
            patientCurrentDetailDTO.setClinicToBeAssigned(OPDCombo.getValue().toString());
        }


//        UpdatePatientClinicModel updatePatientClinicModel = new UpdatePatientClinicModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        boolean added = patientBO.updatePatientClinicDetails(patientCurrentDetailDTO);
        if(added) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully updated to Patient");
            alert.showAndWait();
        }



    }
    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        OPDPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/newLoginVeiw.fxml"));
        OPDPane.getChildren().add(pane);

    }


}
