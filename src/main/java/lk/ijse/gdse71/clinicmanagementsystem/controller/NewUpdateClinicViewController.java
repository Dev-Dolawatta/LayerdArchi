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

public class NewUpdateClinicViewController {
    @FXML
    private AnchorPane editPane;

    @FXML
    private TextField ttxtUpdatedCategory;

    @FXML
    private TextField txtUpdatedId;

    ClinicBO clinicBO = (ClinicBO) BOFactory.getInstance().getBO(BOFactory.BOType.ClinicBO);
    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        editPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageClinicView.fxml"));
        editPane.getChildren().add(pane);
    }

    @FXML
    void updateOnClic(ActionEvent event) throws SQLException {
        ClinicDTO clinicDTO = new ClinicDTO();
        if(txtUpdatedId.getText().isEmpty() || ttxtUpdatedCategory.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out all the fields first!");
            alert.showAndWait();
        }
        else {
            clinicDTO.setClinicID(txtUpdatedId.getText());
            clinicDTO.setClinicName(ttxtUpdatedCategory.getText());
        }
//        ClinicModel clinicModel = new ClinicModel();
//        ClinicDAOImpl clinicDAO = new ClinicDAOImpl();
//        ClinicDAO clinicDAO = new ClinicDAOImpl();
        boolean updated = clinicBO.update(clinicDTO);
        if(updated) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully updated clinic");
            alert.showAndWait();
        }
    }
}
