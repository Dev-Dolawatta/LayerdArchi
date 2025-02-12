package lk.ijse.gdse71.clinicmanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/MainUIView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage. setResizable(false);
        stage.setTitle("Clinic Management System");
        stage.setScene(scene);
        stage.show(); 
        //074-0338231
    }

    public static void main(String[] args) {
        launch();
    }
}