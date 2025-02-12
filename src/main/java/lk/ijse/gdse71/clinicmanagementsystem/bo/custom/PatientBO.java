package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.gdse71.clinicmanagementsystem.dto.*;

import java.sql.SQLException;

public interface PatientBO extends SuperBO {

    boolean add(PatientDTO patientDTO) throws SQLException;

    NewPatientDetailDTO searchPatient(String patientId) throws SQLException;

    boolean remove(String patientId) throws SQLException;

    ObservableList<PatientListDTO> getPatientList() throws SQLException;

    ObservableList<CardiacDTO> getCardiacList() throws SQLException;

    ObservableList<PatientListDTO> getSurgicalList() throws SQLException;

    ObservableList<PatientListDTO> getUroList() throws SQLException;

    ObservableList<PatientListDTO> getGynList() throws SQLException;

    ObservableList<PatientListDTO> getPsyList() throws SQLException;

    ObservableList<PatientListDTO> getDermaList() throws SQLException;

    ObservableList<PatientListDTO> getPreoperList() throws SQLException;

    ObservableList<PatientListDTO> getOrthoList() throws SQLException;

    ObservableList<PatientListDTO> getPeadiacList() throws SQLException;

    ObservableList<PatientListDTO> getNueroList() throws SQLException;

    ObservableList<PatientListDTO> getPainList() throws SQLException;

    boolean updatePatientClinicDetails(PatientCurrentDetailDTO patientCurrentDetailDTO) throws SQLException;

    boolean update(PatientDTO patientDTO) throws SQLException;

    ObservableList<PatientCStatusDTO> searchPatientStatus(String patientId) throws SQLException;

    public boolean retrievePatient(String id, FullDetailDTO fullDetailDTO) throws SQLException;

}
