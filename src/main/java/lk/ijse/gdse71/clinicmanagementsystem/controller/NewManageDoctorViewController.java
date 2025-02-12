package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.DoctorBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.io.IOException;
import java.sql.SQLException;

public class NewManageDoctorViewController {

    @FXML
    private AnchorPane managePane;

    @FXML
    private Label lblClinicId;

    @FXML
    private Label lblDId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPosition;

    @FXML
    private Label lblPw;

    @FXML
    private Label lblSalary;

    @FXML
    private Label lblUName;

    @FXML
    private TextField txtDId;

    DoctorBO doctorBO = (DoctorBO) BOFactory.getInstance().getBO(BOFactory.BOType.DoctorBO);

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        managePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewDocManageView.fxml"));
        managePane.getChildren().add(pane);
    }

    @FXML
    void removeDocOnClick(ActionEvent event) throws IOException, SQLException {

//        DoctorModel doctorModel = new DoctorModel();
//        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
//        DoctorDAO doctorDAO = new DoctorDAOImpl();

        String id = txtDId.getText();
        if(id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Insert the Doctor Id first!");
            alert.showAndWait();

        }
        else {
            boolean Value = doctorBO.remove(id);
            if (Value) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");
                alert.setHeaderText("Successfully removed Doctor");
                alert.showAndWait();
            }
        }
    }
    @FXML
    void searchDocOnClick (ActionEvent event) throws SQLException {
//            DoctorModel doctorModel = new DoctorModel();
//        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
//        DoctorDAO doctorDAO = new DoctorDAOImpl();
            if(txtDId.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Insert the Doctor Id first!");
                alert.showAndWait();
            }
            else {
                DoctorDTO doctorDTOS = doctorBO.searchDoctor(txtDId.getText());
                String id = doctorDTOS.getDocId();
                lblDId.setText(id);
                String name = doctorDTOS.getName();
                lblName.setText(name);
                String position = doctorDTOS.getPosition();
                lblPosition.setText(position);
                double salary = doctorDTOS.getSalary();
                lblSalary.setText(salary + "");
                String uName = doctorDTOS.getuName();
                lblUName.setText(uName);
                String pW = doctorDTOS.getPassword();
                lblPw.setText(pW);
                String clinicId = doctorDTOS.getClinicId();
                lblClinicId.setText(clinicId);
            }

    }

    @FXML
    void updateDocOnClick (ActionEvent event) throws IOException {
         managePane.getChildren().clear();
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdateDoctorView.fxml"));
         managePane.getChildren().add(pane);
    }
}
