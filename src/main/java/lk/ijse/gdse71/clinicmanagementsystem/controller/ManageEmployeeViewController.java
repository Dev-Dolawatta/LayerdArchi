package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.EmployeeBO;

import java.io.IOException;
import java.sql.SQLException;

public class ManageEmployeeViewController {
    @FXML
    private TextField txtEmpId;

    @FXML
    private AnchorPane empPane;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOType.EmployeeBO);


    @FXML
    void addEmployee(ActionEvent event) throws IOException {
        empPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddEmployeeView.fxml"));
        empPane.getChildren().add(pane);

    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        empPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        empPane.getChildren().add(pane);
    }

    @FXML
    void removeEmployee(ActionEvent event) throws SQLException {
        String id  = txtEmpId.getText();
//        EmployeeModel employeeModel = new EmployeeModel();
//        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        boolean removed = employeeBO.remove(id);
        if (removed) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("success");
            alert.setHeaderText("Successfully removed Employee");
            alert.showAndWait();

        }
    }

    @FXML
    void updateEmployee(ActionEvent event) throws IOException {
        empPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdateEmployeeView.fxml"));
        empPane.getChildren().add(pane);
    }
}
