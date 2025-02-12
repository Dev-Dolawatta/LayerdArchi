package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dto.FullDetailDTO;

import java.io.IOException;

public class FullPatientDetailViewController {
    @FXML
    private Label lblCId;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDiagnosis;

    @FXML
    private Label lblMedi;

    @FXML
    private Label lblPId;

    @FXML
    private Label lblPlan;

    @FXML
    private Label lblSymp;

    @FXML
    private AnchorPane retrievePane;

    @FXML
    private TextField txtPId;

    @FXML
    private Label lblTDate;

    @FXML
    private Label lblTDesc;

    @FXML
    private Label lblTId;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        retrievePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ClinicDocView.fxml"));
        retrievePane.getChildren().add(pane);
    }

    @FXML
    void searchOnClick(ActionEvent event) {
        String id = txtPId.getText();

        if (id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Insert the Patient ID!");
            alert.showAndWait();
            return;
        }

        try {
//            RetrieveModel retrieveModel = new RetrieveModel();
            FullDetailDTO fullDetailDTO = new FullDetailDTO();

            boolean isRetrieved = patientBO.retrievePatient(id, fullDetailDTO);

            if (isRetrieved) {

                lblPId.setText(fullDetailDTO.getPId());
                lblCId.setText(fullDetailDTO.getCId());
                lblDate.setText(fullDetailDTO.getDate());
                lblPlan.setText(fullDetailDTO.getManagePlan());
                lblMedi.setText(fullDetailDTO.getMedication());
                lblSymp.setText(fullDetailDTO.getSymptoms());
                lblDiagnosis.setText(fullDetailDTO.getDiagnosis());


                lblTId.setText(fullDetailDTO.getPId());
                lblTDesc.setText(fullDetailDTO.getCId());
                lblTDate.setText(fullDetailDTO.getDate());
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("No Data Found");
                alert.setContentText("No data found for the provided Patient ID.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An Error Occurred");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
