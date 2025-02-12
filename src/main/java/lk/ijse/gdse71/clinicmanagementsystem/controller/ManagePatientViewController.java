package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientCStatusDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDTO;

import java.sql.SQLException;

public class ManagePatientViewController {

    public TableColumn colAddress;
    public TableColumn colPatientId;

    public TableColumn colGender;
    public TableColumn colAge;
    public TableColumn colPhone;
    public TableColumn colBloodGrp;
    public TableColumn colPatientName;
    public TableView patientDetailtbl;


    public TextField txtPatientId;
    public Button btnSearch;
    public TableView tblStatus;
    public TableColumn colHeart;
    public TableColumn colBloodp;
    public TableColumn colStatus;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);

    public void initialize(){

        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colBloodGrp.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        colPatientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colHeart.setCellValueFactory(new PropertyValueFactory<>("heartRate"));
        colBloodp.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }


    public void searchOnClick(ActionEvent actionEvent) throws SQLException {
//        AddPatientModel addPatientModel = new AddPatientModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        String Nic = txtPatientId.getText();
        ObservableList<PatientDTO> patientDTOS = (ObservableList<PatientDTO>) patientBO.searchPatient(Nic);
        patientDetailtbl.setItems(patientDTOS);
        ObservableList<PatientCStatusDTO> patientStatusDTOS = patientBO.searchPatientStatus(Nic);
        tblStatus.setItems(patientStatusDTOS);

    }
}
