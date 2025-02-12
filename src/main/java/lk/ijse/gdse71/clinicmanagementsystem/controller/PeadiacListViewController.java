package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientListDTO;

import java.io.IOException;
import java.sql.SQLException;

public class PeadiacListViewController {

    public TableView tblPatientList;
    public TableColumn clmId;
    public TableColumn clmAge;
    public TableColumn clmGender;
    public TableColumn clmBloodGrp;
    public TableColumn clmHeartRate;
    public TableColumn clmPressure;
    public TableColumn clmStatus;

    @FXML
    private AnchorPane peadiacListPane;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);


    public void initialize() throws SQLException {
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmAge.setCellValueFactory(new PropertyValueFactory<>("pAge"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("pGender"));
        clmBloodGrp.setCellValueFactory(new PropertyValueFactory<>("bloodGrp"));
        clmHeartRate.setCellValueFactory(new PropertyValueFactory<>("heartRate"));
        clmPressure.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
        clmStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

//        PatientListModel patientListModel = new PatientListModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        ObservableList<PatientListDTO> patientListDTOS = patientBO.getPeadiacList();
        System.out.println("Data passed to TableView: " + patientListDTOS);
        tblPatientList.setItems(patientListDTOS);

    }

    @FXML
    void BackOnClick(ActionEvent event) throws IOException {
        peadiacListPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewPeadiatricClView.fxml"));
        peadiacListPane.getChildren().add(pane);
    }
}
