package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.SupplierBO;

import java.io.IOException;
import java.sql.SQLException;

public class ManageSuppliersViewController {
    @FXML
    private AnchorPane supPane;

    @FXML
    private TextField txtSupRemoveId;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOType.SupplierBO);


    @FXML
    void AddSupplier(ActionEvent event) throws IOException {
        supPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AddSupplierView.fxml"));
        supPane.getChildren().add(pane);
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        supPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
        supPane.getChildren().add(pane);
    }

    @FXML
    void removeSupplier(ActionEvent event) throws SQLException {
        if(txtSupRemoveId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Fill the Supplier Id first!");
            alert.showAndWait();
        }
        else {
            String id = txtSupRemoveId.getText();
//            SupplierModel supplierModel = new SupplierModel();
////            SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
//            SupplierDAO supplierDAO = new SupplierDAOImpl();
            boolean removed = supplierBO.remove(id);
            if (removed) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Successfully removed Supplier");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void updateSup(ActionEvent event) throws IOException {
        supPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/UpdateSupplierView.fxml"));
        supPane.getChildren().add(pane);
    }


}
