package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.SupplierBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.SupplierDTO;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateSupplierViewController {
    @FXML
    private AnchorPane editPane;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtSupId;

    @FXML
    private TextField txtSupName;

    @FXML
    private TextField txtTelNo;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOType.SupplierBO);

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        editPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageSuppliersView.fxml"));
        editPane.getChildren().add(pane);
    }

    @FXML
    void updateOnAction(ActionEvent event) throws SQLException {
        SupplierDTO supplierDTO = new SupplierDTO();
        if(txtSupId.getText().isEmpty() || txtSupName.getText().isEmpty() || txtCompany.getText().isEmpty() || txtTelNo.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill out all the fields!");
            alert.showAndWait();
        }
        else {
            supplierDTO.setSupId(txtSupId.getText());
            supplierDTO.setSupName(txtSupName.getText());
            supplierDTO.setCompany(txtCompany.getText());
            supplierDTO.setPhoneNumber(Integer.parseInt(txtTelNo.getText()));
        }
//        SupplierModel supplierModel = new SupplierModel();
//        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
//        SupplierDAO supplierDAO = new SupplierDAOImpl();
        boolean updated = supplierBO.update(supplierDTO);
        if(updated){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Supplier");
            alert.setHeaderText("Successfully updated supplier");
            alert.showAndWait();


        }
    }

}
