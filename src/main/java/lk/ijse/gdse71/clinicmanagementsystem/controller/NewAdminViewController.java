package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewAdminViewController {
    @FXML
    private AnchorPane adminPane;

    @FXML
    void MedicineManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageMedicineView.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void clinicManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageClinicView.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void docManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewDocManageView.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void employeeManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageEmployeeView.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void logoutOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/newLoginVeiw.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void supplierManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageSuppliersView.fxml"));
        adminPane.getChildren().add(pane);
    }

    @FXML
    void testManageOnClick(ActionEvent event) throws IOException {
        adminPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageTestView.fxml"));
        adminPane.getChildren().add(pane);
    }
}
