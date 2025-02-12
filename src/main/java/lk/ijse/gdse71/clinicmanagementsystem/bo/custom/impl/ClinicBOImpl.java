package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ClinicBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.ClinicDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ClinicDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientClinicDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDetailsDTO;

import java.sql.SQLException;

public class ClinicBOImpl implements ClinicBO {

    ClinicDAO clinicDAO = (ClinicDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ClinicDAO);

    public boolean add(ClinicDTO clinicDTO) throws SQLException {
        clinicDAO.add(clinicDTO);
        return true;
    }
    public boolean update(ClinicDTO clinicDTO) throws SQLException {
        clinicDAO.update(clinicDTO);
        return true;
    }
    public String  getClinic() throws SQLException {
        clinicDAO.getClinic();
        return clinicDAO.getClinic();
    }
    public boolean remove(String id) throws SQLException {
        clinicDAO.remove(id);
        return true;
    }
    public PatientDetailsDTO searchPatientDetails(String patientId) throws SQLException {
         return clinicDAO.searchPatientDetails(patientId);


    }
    public boolean medicalClUpdate(PatientClinicDetailDTO patientClinicDetailDTO, String id) throws SQLException {
        return clinicDAO.medicalClUpdate(patientClinicDetailDTO, id);
    }
}
