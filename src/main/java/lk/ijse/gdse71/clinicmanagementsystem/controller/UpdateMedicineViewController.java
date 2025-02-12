package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.MedicineBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class UpdateMedicineViewController {
    @FXML
    private AnchorPane editMediPane;


    @FXML
    private DatePicker txtExp;

    @FXML
    private TextField txtMedId;

    @FXML
    private DatePicker txtMfd;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQty;

    @FXML
    private DatePicker txtDate;

//    @FXML
//    private TextField txtSupId;

    @FXML
    private ComboBox txtSupIdCombo;

    MedicineBO medicineBO = (MedicineBO) BOFactory.getInstance().getBO(BOFactory.BOType.MedicineBO);



    @FXML
    public void initialize() {
        txtSupIdCombo.getItems().removeAll(txtSupIdCombo.getItems()); txtSupIdCombo.getItems().addAll("S001", "S002","S003");
    }


    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        editMediPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageMedicineView.fxml"));
        editMediPane.getChildren().add(pane);
    }

    @FXML
    void updateOnClick(ActionEvent event) throws SQLException {
        AddMedicineDTO addMedicineDTO = new AddMedicineDTO();
//        MedicineModel medicineModel = new MedicineModel();
        LocalDate expDate = txtExp.getValue();
        LocalDate date = txtDate.getValue();
        if(txtMedId.getText().isEmpty() || txtName.getText().isEmpty() || txtExp.getValue() == null || txtMfd.getValue()==null || txtSupIdCombo.getValue().toString() == null || txtQty.getText().isEmpty() || txtDate.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all the fields first!");
            alert.showAndWait();
        }else{
            if(date.isAfter(expDate)) {
                Alert alert  = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Medicine is alredy expired");
                alert.showAndWait();
            }
            else {

                addMedicineDTO.setMediId(txtMedId.getText());
                addMedicineDTO.setMedName(txtName.getText());
                addMedicineDTO.setExpDate(txtExp.getValue());
                addMedicineDTO.setMfdDate(txtMfd.getValue());
                addMedicineDTO.setSupId(txtSupIdCombo.getValue().toString());
                addMedicineDTO.setQty(Integer.parseInt(txtQty.getText()));
                addMedicineDTO.setDate(txtDate.getValue());

        }
            boolean added =  medicineBO.updateMedicine(addMedicineDTO);
            if (added) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");
                alert.setHeaderText(" Successfully updated Medicine ");
                alert.showAndWait();
            }

        }
    }

}
