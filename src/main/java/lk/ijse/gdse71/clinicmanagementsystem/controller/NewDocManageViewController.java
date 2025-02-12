package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewDocManageViewController {
    @FXML
    private AnchorPane docManagePane;

    @FXML
    void AddDoctor(ActionEvent event) throws IOException {
        docManagePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddDocView.fxml"));
        docManagePane.getChildren().add(pane);
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        docManagePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        docManagePane.getChildren().add(pane);
    }

    @FXML
    void manageCurrentDoc(ActionEvent event) throws IOException {
        docManagePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewManageDoctorView.fxml"));
        docManagePane.getChildren().add(pane);
    }
}
