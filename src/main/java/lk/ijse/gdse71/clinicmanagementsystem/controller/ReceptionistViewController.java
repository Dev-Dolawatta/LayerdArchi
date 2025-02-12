package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class ReceptionistViewController {
    @FXML
    private AnchorPane RecepPane;

//    @FXML
//    private Pane mainPane;

//    @FXML
//    private ImageView imgPane;


    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
        RecepPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/newLoginveiw.fxml"));
        RecepPane.getChildren().add(pane);
    }
    @FXML
    void EnrollOnClick(ActionEvent event) throws IOException {
        RecepPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewEnrollPatientView.fxml"));
        RecepPane.getChildren().add(pane);
    }

    @FXML
    void managePatientOnClick(ActionEvent event) throws IOException {

//        RecepPane.getChildren().clear();
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("NewManagePatientView.fxml"));
//        RecepPane.getChildren().add(pane);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NewManagePatientView.fxml"));
            AnchorPane pane = loader.load();
            RecepPane.getChildren().clear();
            RecepPane.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging
        }
    }
}
