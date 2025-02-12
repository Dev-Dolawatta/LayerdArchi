module lk.ijse.gdse71.clinicmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens lk.ijse.gdse71.clinicmanagementsystem.controller to javafx.fxml;
    exports lk.ijse.gdse71.clinicmanagementsystem;
    opens lk.ijse.gdse71.clinicmanagementsystem.dto to javafx.base;
}