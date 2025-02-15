package lk.ijse.gdse71.clinicmanagementsystem.dao.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dao.CrudDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ClinicDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientClinicDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDetailsDTO;

import java.sql.SQLException;

public interface    ClinicDAO extends CrudDAO<ClinicDTO> {
//    boolean addClinic(ClinicDTO clinicDTO) throws SQLException;
//    boolean updateClinic(ClinicDTO clinicDTO) throws SQLException;
//boolean removeClinic(String id) throws SQLException;
    String  getClinic() throws SQLException;
    PatientDetailsDTO searchPatientDetails(String patientId) throws SQLException;
    boolean medicalClUpdate(PatientClinicDetailDTO patientClinicDetailDTO, String id) throws SQLException;

}
