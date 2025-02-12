package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ClinicBO;

import java.io.IOException;
import java.sql.SQLException;

public class ManageClinicViewController {
    @FXML
    private AnchorPane clinicPane;

    @FXML
    private Pane clinicSubPane;

    @FXML
    private TextField txtClinicId;

    ClinicBO clinicBO = (ClinicBO) BOFactory.getInstance().getBO(BOFactory.BOType.ClinicBO);
    @FXML
    void addClinicOnClick(ActionEvent event) throws IOException {
        clinicPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddClinicView.fxml"));
        clinicPane.getChildren().add(pane);


    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        clinicPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        clinicPane.getChildren().add(pane);
    }

    @FXML
    void removeClinicOnClick(ActionEvent event) throws SQLException {
//        ClinicModel clinicModel = new ClinicModel();
//        ClinicDAOImpl clinicDAO = new ClinicDAOImpl();
//        ClinicDAO clinicDAO = new ClinicDAOImpl();
        if(txtClinicId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Give the Clinic ID first!");
            alert.showAndWait();
        }else {
            boolean removed = clinicBO.remove(txtClinicId.getText());
            if (removed) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Clinic has been removed successfully");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void updateClinicOnClick(ActionEvent event) throws IOException {
        clinicPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewUpdateClinicView.fxml"));
        clinicPane.getChildren().add(pane);
    }
}
