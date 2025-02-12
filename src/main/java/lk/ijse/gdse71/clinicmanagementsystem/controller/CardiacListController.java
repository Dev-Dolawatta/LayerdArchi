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
import lk.ijse.gdse71.clinicmanagementsystem.dto.CardiacDTO;

import java.io.IOException;
import java.sql.SQLException;

public class CardiacListController  {
    @FXML
    private AnchorPane cardiacListPane;
    public TableView tblCardiac;
    public TableColumn clmId;
    public TableColumn clmAge;
    public TableColumn clmGender;
    public TableColumn clmBlGrp;
    public TableColumn clmHRate;
    public TableColumn clmPressure;
    public TableColumn clmStatus;

    PatientBO patientBO = (PatientBO) BOFactory.getInstance().getBO(BOFactory.BOType.PatientBO);

    @FXML
    void BackOnClick(ActionEvent event) throws IOException {
        cardiacListPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ClinicDocView.fxml"));
        cardiacListPane.getChildren().add(pane);
    }

    public void initialize() throws SQLException {
        clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmAge.setCellValueFactory(new PropertyValueFactory<>("pAge"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("pGender"));
        clmBlGrp.setCellValueFactory(new PropertyValueFactory<>("bloodGrp"));
        clmHRate.setCellValueFactory(new PropertyValueFactory<>("heartRate"));
        clmPressure.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
        clmStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));

//        PatientListModel patientListModel = new PatientListModel();
//        PatientDAOImpl patientDAO = new PatientDAOImpl();
//        PatientDAO patientDAO = new PatientDAOImpl();
        ObservableList<CardiacDTO> CardiacDTOS = patientBO.getCardiacList();
        System.out.println("list got data");
        tblCardiac.setItems(CardiacDTOS);


    }

}
