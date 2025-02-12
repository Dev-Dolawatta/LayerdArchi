package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.ClinicDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ClinicDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientClinicDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.PatientDetailsDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicDAOImpl implements ClinicDAO {
    public boolean add(ClinicDTO clinicDTO) throws SQLException {
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("insert into Clinic(ClinicId,Category)values(?,?)");
        preparedStatement.setObject(1,clinicDTO.getClinicID());
        preparedStatement.setObject(2,clinicDTO.getClinicName());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean update(ClinicDTO clinicDTO) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("update  Clinic set Category = ? where ClinicId = ?");

        preparedStatement.setObject(1,clinicDTO.getClinicName());
        preparedStatement.setObject(2,clinicDTO.getClinicID());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public String  getClinic() throws SQLException {
        String id  = "null";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select ClinicId from Clinic where Category  = 'Medical' ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            id = resultSet.getString("ClinicId");
        }
        return id;
    }
    public boolean remove(String id) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("delete from Clinic where ClinicId = ?");
        preparedStatement.setObject(1,id);
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public PatientDetailsDTO searchPatientDetails(String patientId) throws SQLException {
        PatientDetailsDTO patientDetailsDTO = new PatientDetailsDTO();
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("select Name,BloodGroup from Patient where PatientId = ?");
        preparedStatement.setObject(1,patientId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            patientDetailsDTO.setBloodGroup(resultSet.getString("BloodGroup"));
            patientDetailsDTO.setName(resultSet.getString("Name"));

        }
        return patientDetailsDTO;
    }
    public boolean medicalClUpdate(PatientClinicDetailDTO patientClinicDetailDTO, String id) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("insert into ClinicDetail(PatientId,ClinicId,Date,ManagePlan,Medication,Symptoms,Diagnosis) values(?,?,?,?,?,?,?)");
        preparedStatement.setObject(1, patientClinicDetailDTO.getPatientId());
        preparedStatement.setObject(2,id);
        java.sql.Date sqlDate = java.sql.Date.valueOf(patientClinicDetailDTO.getDate());
        preparedStatement.setObject(3,sqlDate);
        preparedStatement.setObject(4,patientClinicDetailDTO.getManagePlan());
        preparedStatement.setObject(5,patientClinicDetailDTO.getMedication());
        preparedStatement.setObject(6,patientClinicDetailDTO.getSymptoms());
        preparedStatement.setObject(7,patientClinicDetailDTO.getDiagnosis());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
}
