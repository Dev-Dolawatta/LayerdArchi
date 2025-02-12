package lk.ijse.gdse71.clinicmanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainLoginViewController {


    public TextField loginUserName;
    public TextField loginPassword;
    public Button LoginBtn1;
    public AnchorPane loginPanel;

    @FXML
    private Button LoginBtn;

    @FXML
    void LoginOnClick(ActionEvent event) throws IOException, SQLException {



        String role;

        System.out.println(loginUserName.getText());
        System.out.println(loginPassword.getText());

        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select Role from User where UserName = ? && Password = ? ");
        if(loginUserName.getText().isEmpty() || loginPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username or password can't be empty!");
            alert.showAndWait();
            return;

        }

        preparedStatement.setObject(1, loginUserName.getText());
        preparedStatement.setObject(2, loginPassword.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username or password !");
            alert.showAndWait();
            return;
        }
        System.out.println(resultSet.getString("Role"));
        role = resultSet.getString("Role");
            if (role.equals("Receptionist") ) {
                loginPanel.getChildren().clear();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ReceptionistView.fxml"));
                loginPanel.getChildren().add(pane);
            }
            if (role.equals("Admin")) {
                loginPanel.getChildren().clear();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/NewAdminView.fxml"));
                loginPanel.getChildren().add(pane);
            }
            if (role.equals("Doctor")) {
                loginPanel.getChildren().clear();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/DocUIView.fxml"));
                loginPanel.getChildren().add(pane);
            }
            if(role.equals("Clinic Doctor")){
                loginPanel.getChildren().clear();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ClinicDocView.fxml"));
                loginPanel.getChildren().add(pane);
        }



    }


}
