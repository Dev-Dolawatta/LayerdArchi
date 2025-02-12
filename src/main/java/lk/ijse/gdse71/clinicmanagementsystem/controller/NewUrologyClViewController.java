package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ClinicBO;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ReportBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientClinicDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDetailsDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ReportDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class NewUrologyClViewController {
    @FXML
    private Label lblBloodG;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDiagnosis;

    @FXML
    private Label lblMedi;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPlan;

    @FXML
    private Label lblSymp;

    @FXML
    private TextField txtPId;

    @FXML
    private AnchorPane uroPane;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtDiagnosis;

    @FXML
    private TextField txtMedi;



    @FXML
    private TextArea txtPlan;

    @FXML
    private TextArea txtSymp;

//    ClinicDAO clinicDAO = new ClinicDAOImpl();

    ClinicBO clinicBO = (ClinicBO) BOFactory.getInstance().getBO(BOFactory.BOType.ClinicBO);

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        uroPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ClinicDocView.fxml"));
        uroPane.getChildren().add(pane);
    }

    @FXML
    void uroPSearch(ActionEvent event) throws SQLException {
//        ClinicModel clinicModel = new ClinicModel();
        if (txtPId.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fill the Patient Id first!");
            alert.showAndWait();
        } else {
            PatientDetailsDTO patientDetailsDTOS = clinicBO.searchPatientDetails(txtPId.getText());
            String name = patientDetailsDTOS.getName();
            lblName.setText(name);
            String bloodGroup = patientDetailsDTOS.getBloodGroup();
            lblBloodG.setText(bloodGroup);
        }
    }
    @FXML
    void updateOnClick(ActionEvent event) throws SQLException {
        PatientClinicDetailDTO patientClinicDetailDTO = new PatientClinicDetailDTO();
            if(txtPId.getText().isEmpty() || txtPlan.getText().isEmpty() || txtDate.getValue() == null|| txtMedi.getText().isEmpty() || txtSymp.getText().isEmpty() || txtDiagnosis.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Fill all the fields first!");
                alert.showAndWait();
            }else {
                patientClinicDetailDTO.setPatientId(txtPId.getText());
                patientClinicDetailDTO.setManagePlan(txtPlan.getText());
                patientClinicDetailDTO.setDate(txtDate.getValue());
                patientClinicDetailDTO.setMedication(txtMedi.getText());
                patientClinicDetailDTO.setSymptoms(txtSymp.getText());
                patientClinicDetailDTO.setDiagnosis(txtDiagnosis.getText());
//                SubClinicModel subClinicModel = new SubClinicModel();
//                ClinicModel clinicModel = new ClinicModel();
                String id = clinicBO.getClinic();
                boolean updated = clinicBO.medicalClUpdate(patientClinicDetailDTO, id);
                if (updated) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Patient Details Updated!");
                    alert.showAndWait();
                }
            }

    }

    @FXML
    void generateReport(ActionEvent event) throws SQLException {
//        ReportModel reportModel = new ReportModel();
//        ReportDAO reportDAO = new ReportDAOImpl();
        ReportBO reportBO = (ReportBO) BOFactory.getInstance().getBO(BOFactory.BOType.ReportBo);
        ReportDTO object = reportBO.showReport(txtPId.getText());
        JasperDesign design = null;

        HashMap hashMap = new HashMap();
        hashMap.put("PatientName",object.getName());
        hashMap.put("ClinicId",object.getClinicId());
        hashMap.put("ManagePlan",object.getManagePlan());
        hashMap.put("Medication",object.getMedication());
        hashMap.put("Symptoms",object.getSymptoms());
        hashMap.put("Diagnosis",object.getDiagnosis());
        hashMap.put("TestId",object.getTestId());
        hashMap.put("Description",object.getDescription());
        hashMap.put("Date",object.getDate());

        try {
            design = JRXmlLoader.load("C:\\Users\\Admin\\Documents\\firstSemProject\\currentUsingP\\ClinicManagementSystem\\src\\main\\resources\\Report\\PatientReport.jrxml");
            JasperReport report = JasperCompileManager.compileReport(design);
            JasperPrint print = JasperFillManager.fillReport(report,hashMap,new JREmptyDataSource(1));
            JasperViewer.viewReport(print);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void showList(ActionEvent event) throws IOException {
        uroPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UrologyListView.fxml"));
        uroPane.getChildren().add(pane);
    }



}
