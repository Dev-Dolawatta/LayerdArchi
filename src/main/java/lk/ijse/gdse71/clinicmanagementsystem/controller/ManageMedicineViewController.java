package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageMedicineViewController {
    @FXML
    private AnchorPane mainMediPane;

    @FXML
    void AddMedi(ActionEvent event) throws IOException {
        mainMediPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddMedicineView.fxml"));
        mainMediPane.getChildren().add(pane);
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        mainMediPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        mainMediPane.getChildren().add(pane);
    }

    @FXML
    void updateMedi(ActionEvent event) throws IOException {
        mainMediPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdateMedicineView.fxml"));
        mainMediPane.getChildren().add(pane);
    }
    @FXML
    void removeOnClick(ActionEvent event) {

    }
}
