package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateClinicViewController {
    @FXML
    private TextField txtUpdatedId;

    @FXML
    private AnchorPane updateClinicPane;

    @FXML
    private ComboBox updatedCombo;



    @FXML
    public void initialize() {
        updatedCombo.getItems().removeAll(updatedCombo.getItems()); updatedCombo.getItems().addAll("Medical", "Surgical","OrthoPediac","Peadiatric","Cardiac","Urology","Nuerology","Psychiatric","Preoperative","Pain Management","GynObs","Dermatology");
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        updateClinicPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageClinicView.fxml"));
        updateClinicPane.getChildren().add(pane);
    }

    @FXML
    void updateOnClick(ActionEvent event) throws SQLException, IOException {
        updateClinicPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewUpdateClinicView.fxml"));
        updateClinicPane.getChildren().add(pane);
    }
}
