package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.TestBO;

import java.io.IOException;
import java.sql.SQLException;

public class ManageTestViewController {
    @FXML
    private AnchorPane testPane;

    @FXML
    private TextField txtTestId;

    TestBO testBO = (TestBO) BOFactory.getInstance().getBO(BOFactory.BOType.TestBO);

    @FXML
    void addTest(ActionEvent event) throws IOException {
        testPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddTestView.fxml"));
        testPane.getChildren().add(pane);
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        testPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        testPane.getChildren().add(pane);
    }

    @FXML
    void removeTest(ActionEvent event) throws SQLException {
//        TestModel testModel = new TestModel();
//        TestDAOImpl testDAO = new TestDAOImpl();
//        TestDAO testDAO = new TestDAOImpl();
        String id = txtTestId.getText();
        boolean deleted = testBO.remove(id);
        if(deleted){
            Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Test");
            alert.setHeaderText("Test has been successfully removed");
            alert.showAndWait();
        }
    }

    @FXML
    void updateTest(ActionEvent event) throws IOException {
        testPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdateTestView.fxml"));
        testPane.getChildren().add(pane);
    }

}
