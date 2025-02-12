package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.PatientBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.PatientDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.PatientDAOImpl;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PatientDAO);

    public boolean add(PatientDTO patientDTO) throws SQLException {
        patientDAO.add(new PatientDTO(patientDTO.getPatientID(), patientDTO.getPatientName(), patientDTO.getAddress(), patientDTO.getGender(), patientDTO.getAge(), patientDTO.getPhone(), patientDTO.getBloodGroup()));
        return true;
    }
    public NewPatientDetailDTO searchPatient(String patientId) throws SQLException {
        NewPatientDetailDTO patientDTO = patientDAO.searchPatient(patientId);
        return patientDTO;
    }
    public boolean remove(String patientId) throws SQLException {
        return patientDAO.remove(patientId);
    }
    public ObservableList<PatientListDTO> getPatientList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getPatientList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public  ObservableList<CardiacDTO> getCardiacList() throws SQLException {
        ArrayList<CardiacDTO> patientListDTOArrayList = (ArrayList<CardiacDTO>) patientDAO.getCardiacList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getSurgicalList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getSurgicalList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getUroList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getUroList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getGynList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getGynList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getPsyList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getPsyList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getDermaList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getDermaList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getPreoperList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getPreoperList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getOrthoList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getOrthoList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getPeadiacList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getPeadiacList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getNueroList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getNueroList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public ObservableList<PatientListDTO> getPainList() throws SQLException {
        ArrayList<PatientListDTO> patientListDTOArrayList = (ArrayList<PatientListDTO>) patientDAO.getPainList();
        return FXCollections.observableArrayList(patientListDTOArrayList);
    }
    public boolean updatePatientClinicDetails(PatientCurrentDetailDTO patientCurrentDetailDTO) throws SQLException {
        patientDAO.updatePatientClinicDetails(patientCurrentDetailDTO);
        return true;
    }
    public boolean update(PatientDTO patientDTO) throws SQLException {
        patientDAO.update(patientDTO);
        return true;
    }
    public ObservableList<PatientCStatusDTO> searchPatientStatus(String patientId) throws SQLException {
        patientDAO.searchPatientStatus(patientId);
        return FXCollections.observableArrayList(patientDAO.searchPatientStatus(patientId));
    }
    public boolean retrievePatient(String id, FullDetailDTO fullDetailDTO) throws SQLException {

        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

//            String query1 = "SELECT * FROM ClinicDetail WHERE PatientId = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
//                preparedStatement.setString(1, id);
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                if (resultSet.next()) {
//
//                    fullDetailDTO.setPId(resultSet.getString("PatientId"));
//                    fullDetailDTO.setCId(resultSet.getString("ClinicId"));
//                    fullDetailDTO.setDate(resultSet.getString("Date"));
//                    fullDetailDTO.setManagePlan(resultSet.getString("ManagePlan"));
//                    fullDetailDTO.setMedication(resultSet.getString("Medication"));
//                    fullDetailDTO.setSymptoms(resultSet.getString("Symptoms"));
//                    fullDetailDTO.setDiagnosis(resultSet.getString("Diagnosis"));

                    boolean result = new PatientDAOImpl().retrievePatient(connection,fullDetailDTO,id);
                    if(result) {
                        if (new TestBOImpl().retrieveTestDetails(fullDetailDTO, connection, id)) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                            return false;
                    }
//                    connection.rollback();


        }
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }



}
