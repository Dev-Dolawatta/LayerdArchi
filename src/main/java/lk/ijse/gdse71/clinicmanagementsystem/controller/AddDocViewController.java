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

public class AddDocViewController {
    @FXML
    public ComboBox docCombo;

    @FXML
    public void initialize() { docCombo.getItems().removeAll(docCombo.getItems()); docCombo.getItems().addAll("Consultant", "Senior Registrar","Registrar","SHO","RHO","HO");

    }

    @FXML
    private TextField txtDocClinicId;

    @FXML
    private TextField txtDocId;

    @FXML
    private TextField txtDocPw;

    @FXML
    private TextField txtDocUName;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;


    @FXML
    private AnchorPane docRegisterPane;

    DoctorBO doctorBO = (DoctorBO) BOFactory.getInstance().getBO(BOFactory.BOType.DoctorBO);


    @FXML
    void AddDocOnClick(ActionEvent event) throws SQLException, IOException {
//        DoctorModel doctorModel = new DoctorModel();
//        DoctorDAOImpl doctorDAO = new DoctorDAOImpl();
//        DoctorDAO doctorDAO = new DoctorDAOImpl();
        if (txtDocId.getText().isEmpty() || txtName.getText().isEmpty() || txtSalary.getText().isEmpty() || docCombo.getValue().toString().isEmpty() || txtDocUName.getText().isEmpty() || txtDocPw.getText().isEmpty() || txtDocClinicId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out the fields first!");
            alert.showAndWait();
        } else {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDocId(txtDocId.getText());
            doctorDTO.setName(txtName.getText());
            doctorDTO.setSalary(Double.parseDouble(txtSalary.getText()));
            doctorDTO.setPosition(docCombo.getValue().toString());
            doctorDTO.setuName(txtDocUName.getText());
            doctorDTO.setPassword(txtDocPw.getText());
            doctorDTO.setClinicId(txtDocClinicId.getText());
            boolean added = doctorBO.add(doctorDTO);
            if (added) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Successfully added to Doctor");
                alert.showAndWait();
            }


        }
    }

        @FXML
        void backOnClick (ActionEvent event) throws IOException {
            docRegisterPane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewDocManageView.fxml"));
            docRegisterPane.getChildren().add(pane);
        }
}
