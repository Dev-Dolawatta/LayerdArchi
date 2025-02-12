package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.bo.BOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.TestBO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.TestDTO;

import java.io.IOException;
import java.sql.SQLException;

public class AddTestViewController {
    @FXML
    private DatePicker txtDate;
    @FXML
    private TextArea txtDesc;

    @FXML
    private ComboBox txtPCombo;

    @FXML
    public void initialize() {
        txtPCombo.getItems().removeAll(txtPCombo.getItems()); txtPCombo.getItems().addAll("200256502679", "200256453412","200256572679");
    }

    @FXML
    private TextField txtTestId;

    @FXML
    private AnchorPane testAddPane;

    TestBO testBO = (TestBO) BOFactory.getInstance().getBO(BOFactory.BOType.TestBO);

    @FXML
    void addTestOnClick(ActionEvent event) throws SQLException {
        TestDTO testDTO = new TestDTO();
        testDTO.setTestId(txtTestId.getText());
        testDTO.setDesc(txtDesc.getText());
        testDTO.setTestDate(txtDate.getValue());
        testDTO.setPatientId(txtPCombo.getValue().toString());

//        TestModel testModel = new TestModel();
//        TestDAOImpl testDAO = new TestDAOImpl();
//        TestDAO testDAO = new TestDAOImpl();
        boolean added = testBO.add(testDTO);
            if(added) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Successfully added Test");
                alert.showAndWait();
            }
    }

    @FXML
    void backOnClick(ActionEvent event) throws IOException {
        testAddPane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ManageTestView.fxml"));
        testAddPane.getChildren().add(pane);
    }
}
