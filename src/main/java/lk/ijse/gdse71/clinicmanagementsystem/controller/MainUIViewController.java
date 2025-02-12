package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUIViewController {

    @FXML
    private AnchorPane loadPanel;

    @FXML
    private Button startBtn;

    @FXML
    void OnClickStart(ActionEvent event) throws IOException {
        loadPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/newLoginVeiw.fxml"));
        loadPanel.getChildren().add(pane);


    }

}
