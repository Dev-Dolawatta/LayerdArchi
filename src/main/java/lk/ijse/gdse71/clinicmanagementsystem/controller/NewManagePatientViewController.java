package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.NewPatientDetailDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;

public class NewManagePatientViewController {
    @FXML
    private Button btnSearch;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblBloodG;

    @FXML
    private Label lblBloodP;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblHeart;

    @FXML
    private Label lblPatientName;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblStatus;

    @FXML
    private AnchorPane managePane;

    @FXML
    private TextField txtPatientId;

    @FXML
    private Label lblPatientId;

//    PatientDAO patientDAO = new PatientDAOImpl();

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);


    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        managePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ReceptionistView.fxml"));
        managePane.getChildren().add(pane);
    }

    @FXML
    void searchOnClick(ActionEvent event) throws SQLException {
//        SearchPatientModel searchPatientModel = new SearchPatientModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();

        if(txtPatientId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Insert the Patient Id first!");
            alert.showAndWait();
        }else {
            String Nic = txtPatientId.getText();
            NewPatientDetailDTO newPatientDetailDTOS = patientBO.searchPatient(Nic);
            String id = newPatientDetailDTOS.getPatientId();
            String name = newPatientDetailDTOS.getName();
            String gender = newPatientDetailDTOS.getGender();
            String address = newPatientDetailDTOS.getAddress();
            int age = newPatientDetailDTOS.getAge();
            int phone = newPatientDetailDTOS.getPhone();
            String bloodGroup = newPatientDetailDTOS.getBloodGroup();
            int heartRate = newPatientDetailDTOS.getHeartRate();
            String bloodP = newPatientDetailDTOS.getBloodP();
            String status = newPatientDetailDTOS.getStatus();

            lblPatientId.setText(id);
            lblPatientName.setText(name);
            lblGender.setText(gender);
            lblAddress.setText(address);
            lblAge.setText(String.valueOf(age));
            lblPhone.setText(String.valueOf(phone));
            lblBloodG.setText(bloodGroup);
            lblHeart.setText(String.valueOf(heartRate));
            lblBloodP.setText(bloodP);
            lblStatus.setText(status);
        }


    }
    @FXML
    void updateOnClick(ActionEvent event) throws IOException {
        managePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdatePatientView.fxml"));
        managePane.getChildren().add(pane);
    }
    @FXML
    void removeOnClick(ActionEvent event) throws SQLException {
//        RemovePatientModel removePatientModel = new RemovePatientModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
        if(txtPatientId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Insert the Patient Id first!");
            alert.showAndWait();
        }else {
            String Nic = txtPatientId.getText();
            boolean Value = patientBO.remove(Nic);
            if (Value) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");
                alert.setHeaderText("Successfully removed patient");
                alert.showAndWait();

            }
        }

    }
    @FXML
    void showReport(ActionEvent event) {
        try {
            JasperDesign design = JRXmlLoader.load("C:\\Users\\Admin\\Documents\\firstSemProject\\currentUsingP\\ClinicManagementSystem\\src\\main\\resources\\Report\\firstReport.jrxml");
            JasperReport report = JasperCompileManager.compileReport(design);
            JasperPrint print = JasperFillManager.fillReport(report,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(print);
        } catch (JRException e) {
            e.printStackTrace();
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Failed");
//            alert.setHeaderText("Failed to generate report!");
//            alert.showAndWait();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
