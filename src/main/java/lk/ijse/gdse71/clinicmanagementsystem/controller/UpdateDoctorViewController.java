package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.DoctorBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateDoctorViewController {
    @FXML
    private TextField txtClinicId;

    @FXML
    private TextField txtDId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPw;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtUName;

    @FXML
    private ComboBox updateDocCombo;

    @FXML
    private AnchorPane updatedDocPane;

    DoctorBO doctorBO = (DoctorBO) BOFactory.getInstance().getBO(BOFactory.BOType.DoctorBO);

    @FXML
    public void initialize() {
        updateDocCombo.getItems().removeAll(updateDocCombo.getItems()); updateDocCombo.getItems().addAll("Consultant","Senior Registrar", "Registrar","RHO","SHO","HO");
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        updatedDocPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewDocManageView.fxml"));
        updatedDocPane.getChildren().add(pane);
    }

    @FXML
    void updateOnClick(ActionEvent event) throws SQLException {
        DoctorDTO doctorDTO = new DoctorDTO();
        if(txtDId.getText().isEmpty() || txtName.getText().isEmpty() || txtSalary.getText().isEmpty() || updateDocCombo.getValue().toString().isEmpty() || txtUName.getText().isEmpty() || txtPw.getText().isEmpty() || txtClinicId.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out all the fields first!");
            alert.showAndWait();
        }
        else {
            doctorDTO.setDocId(txtDId.getText());
            doctorDTO.setName(txtName.getText());
            doctorDTO.setSalary(Double.parseDouble(txtSalary.getText()));
            doctorDTO.setPosition(updateDocCombo.getValue().toString());
            doctorDTO.setuName(txtUName.getText());
            doctorDTO.setPassword(txtPw.getText());
            doctorDTO.setClinicId(txtClinicId.getText());
        }

//        DoctorModel doctorModel = new DoctorModel();
//        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
//        DoctorDAO doctorDAO = new DoctorDAOImpl();
        boolean added = doctorBO.update(doctorDTO);
        if(added) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully updated Doctor");
            alert.showAndWait();
        }
    }
}
