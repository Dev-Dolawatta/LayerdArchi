package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ClinicDocViewController {
    @FXML
    private AnchorPane clinicDocUI;

    @FXML
    private Button medicalBtn;

    @FXML
    private Button btnCardiac;

    @FXML
    private Button btnOrtho;

    @FXML
    private Button btnSurgical;

    @FXML
    private Button btnUro;

    @FXML
    private Button btnGyn;

    @FXML
    private Button btnPsy;

    @FXML
    private Button btnDerma;

    @FXML
    private Button btnPreOper;

    @FXML
    private Button btnPeadiac;

    @FXML
    private Button btnNuero;

    @FXML
    private Button btnPain;


    @FXML
    void medicalUIOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MedicalClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void CardiacOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewCardiacClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void OrthoUIOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewOrthopeadiacClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void surgicalUIOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewSurgicalClView.fxml"));
        clinicDocUI.getChildren().add(pane);


    }
    @FXML
    void uroUIOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewUrologyClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void gynObsViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewGynObsClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void psyUIOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewPsychiatricClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void DermaViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewDermatologyClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void preOperViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewPreOperativeClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void peadiacViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewPeadiatricClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void NueroViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewNuerologyClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void PainMViewOnClick(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewPainManagementClView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }


    public void backOnClick(ActionEvent actionEvent) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/newLoginVeiw.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
    @FXML
    void getDetail(ActionEvent event) throws IOException {
        clinicDocUI.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/FullPatientDetailView.fxml"));
        clinicDocUI.getChildren().add(pane);
    }
}
