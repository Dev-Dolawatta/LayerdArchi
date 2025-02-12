package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ClinicBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ClinicDTO;

import java.io.IOException;
import java.sql.SQLException;

public class AddClinicViewController {

//    @FXML
//    private ComboBox clinicCombo;
//
//    @FXML
//    public void initialize() {
//        clinicCombo.getItems().removeAll(clinicCombo.getItems()); clinicCombo.getItems().addAll("Medical", "Surgical","OrthoPediac","Peadiatric","Cardiac","Urology","Nuerology","Psychiatric","Preoperative","Pain Management","GynObs","Dermatology");
//    }

    @FXML
    private AnchorPane clinicRegisterPane;

    @FXML
    private TextField txtClinicId;

    @FXML
    private TextField txtCategory;

    ClinicBO clinicBO = (ClinicBO) BOFactory.getInstance().getBO(BOFactory.BOType.ClinicBO);


    @FXML
    void addOnClick(ActionEvent event) throws SQLException {
        ClinicDTO clinicDTO = new ClinicDTO();
        if(txtClinicId.getText().isEmpty() || txtCategory.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out the  fields first!");
            alert.showAndWait();
        }
        else{
        clinicDTO.setClinicID((txtClinicId.getText()));
        clinicDTO.setClinicName(txtCategory.getText());
        }
//        ClinicModel clinicModel = new ClinicModel();
//        ClinicDAOImpl clinicDAO = new ClinicDAOImpl();
//        ClinicDAO clinicDAO = new ClinicDAOImpl();
        boolean added = clinicBO.add(clinicDTO);
        if (added) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully added to Clinic");
            alert.showAndWait();
        }
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        clinicRegisterPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageClinicView.fxml"));
        clinicRegisterPane.getChildren().add(pane);
    }



}
