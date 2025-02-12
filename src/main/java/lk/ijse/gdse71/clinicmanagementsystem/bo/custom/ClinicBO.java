package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.ClinicDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientClinicDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDetailsDTO;

import java.sql.SQLException;

public interface ClinicBO extends SuperBO {
    boolean add(ClinicDTO clinicDTO) throws SQLException;

    boolean update(ClinicDTO clinicDTO) throws SQLException;

    String  getClinic() throws SQLException;

    boolean remove(String id) throws SQLException;

    PatientDetailsDTO searchPatientDetails(String patientId) throws SQLException;

    boolean medicalClUpdate(PatientClinicDetailDTO patientClinicDetailDTO, String id) throws SQLException;
}
