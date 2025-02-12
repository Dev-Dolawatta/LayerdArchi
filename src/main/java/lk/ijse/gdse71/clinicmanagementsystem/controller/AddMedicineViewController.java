package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.MedicineBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddMedicineViewController {
    @FXML
    private AnchorPane medRegisPane;

    @FXML
    private DatePicker txtDate;

    @FXML
    private DatePicker txtExpDate;

    @FXML
    private TextField txtMedId;

    @FXML
    private DatePicker txtMfdDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQty;

    @FXML
    private ComboBox txtSupId;

    MedicineBO medicineBO = (MedicineBO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.MedicineDAO);

    @FXML
    public void initialize() {
        txtSupId.getItems().removeAll(txtSupId.getItems()); txtSupId.getItems().addAll("S002", "S003","S004");

    }



    @FXML
    void AddMedOnClick(ActionEvent event) throws SQLException {

        LocalDate expDate = txtExpDate.getValue();
        LocalDate date = txtDate.getValue();
//        MedicineModel medicineModel = new MedicineModel();
//        MedicineDAOImpl medDao = new MedicineDAOImpl();
        AddMedicineDTO addMedicineDTO = new AddMedicineDTO();
        if(txtMedId.getText().isEmpty() || txtName.getText().isEmpty() || txtExpDate.getValue() == null || txtMfdDate.getValue() == null|| (txtSupId.getValue().toString() == null ||txtQty.getText().isEmpty()) || txtDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out all the fields first! ");
            alert.showAndWait();

        }else{
            if (date.isAfter(expDate)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(" Already expired ");
                alert.showAndWait();

            }else {
                addMedicineDTO.setMediId(txtMedId.getText());
                addMedicineDTO.setMedName(txtName.getText());
                addMedicineDTO.setExpDate(txtExpDate.getValue());
                addMedicineDTO.setMfdDate(txtMfdDate.getValue());
                addMedicineDTO.setSupId(txtSupId.getValue().toString());
                addMedicineDTO.setQty(Integer.parseInt(txtQty.getText()));
                addMedicineDTO.setDate(txtDate.getValue());

        }

            boolean added =  medicineBO.addMedicine(addMedicineDTO);//send addMedicineDTO
            if (added) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success");
                alert.setHeaderText(" Successfully added Medicine ");
                alert.showAndWait();
            }
        }


    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        medRegisPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageMedicineView.fxml"));
        medRegisPane.getChildren().add(pane);
    }
}
