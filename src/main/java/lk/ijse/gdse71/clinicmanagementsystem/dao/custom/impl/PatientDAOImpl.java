package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.PatientDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class PatientDAOImpl implements PatientDAO {
        public boolean add(PatientDTO patientDTO) throws SQLException {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("insert into Patient(PatientId,Name,Address,Gender,Age,Phone,BloodGroup) values (?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,patientDTO.getPatientID());
            preparedStatement.setObject(2,patientDTO.getPatientName());
            preparedStatement.setObject(3,patientDTO.getAddress());
            preparedStatement.setObject(4,patientDTO.getGender());
            preparedStatement.setObject(5,patientDTO.getAge());
            preparedStatement.setObject(6,patientDTO.getPhone());
            preparedStatement.setObject(7,patientDTO.getBloodGroup());

            boolean value = preparedStatement.executeUpdate()>0;
            return value;

        }

    public NewPatientDetailDTO searchPatient(String patientId) throws SQLException {
        NewPatientDetailDTO newPatientDetailDTO = new NewPatientDetailDTO();

        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Name,Address,Gender,Age,Phone,BloodGroup,HeartRate,BloodPressure,Status from Patient where PatientId = ?");
        preparedStatement.setObject(1,patientId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            newPatientDetailDTO.setPatientId(resultSet.getString("PatientId"));
            newPatientDetailDTO.setName(resultSet.getString("Name"));
            newPatientDetailDTO.setAddress(resultSet.getString("Address"));
            newPatientDetailDTO.setGender(resultSet.getString("Gender"));
            newPatientDetailDTO.setAge(Integer.parseInt(resultSet.getString("Age")));
            newPatientDetailDTO.setPhone(Integer.parseInt((resultSet.getString("Phone"))));
            newPatientDetailDTO.setBloodGroup(resultSet.getString("BloodGroup"));
            newPatientDetailDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
            newPatientDetailDTO.setBloodP(resultSet.getString("BloodPressure"));
            newPatientDetailDTO.setStatus(resultSet.getString("Status"));




        }
        return newPatientDetailDTO;
    }
    public boolean remove(String patientId) throws SQLException {
      PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("delete from Patient where PatientId = ?");
      preparedStatement.setObject(1,patientId);
      boolean value = preparedStatement.executeUpdate()>0;
      return value;
    }

    public ObservableList<PatientListDTO> getPatientList() throws SQLException {
        PatientListDTO patientListDTO = new PatientListDTO();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Medical' ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            patientListDTO.setId((resultSet.getString("PatientID")));
            System.out.println("PatientID: " + resultSet.getString("PatientID"));
            patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
            System.out.println("Age: " + resultSet.getString("Age"));
            patientListDTO.setPGender(resultSet.getString("Gender"));
            patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
            patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
            patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
            patientListDTO.setStatus(resultSet.getString("status"));


        }
        ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
        list.add(patientListDTO);
        System.out.println("ObservableList: " + list);

        return list;
    }
    public  ObservableList<CardiacDTO> getCardiacList() throws SQLException {
            CardiacDTO cardiacDTO = new CardiacDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Cardiac' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                cardiacDTO.setId((resultSet.getString("PatientID")));
                System.out.println("PatientID: " + resultSet.getString("PatientID"));
                cardiacDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                cardiacDTO.setPGender(resultSet.getString("Gender"));
                cardiacDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                cardiacDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                cardiacDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                cardiacDTO.setStatus(resultSet.getString("status"));

            }
            ObservableList<CardiacDTO> list = FXCollections.observableArrayList();
            list.add(cardiacDTO);
            return list;

    }
    public ObservableList<PatientListDTO> getSurgicalList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Surgical' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;


    }
    public ObservableList<PatientListDTO> getUroList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Urology' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getGynList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Gyn&Obs' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getPsyList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Psychiatric' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getDermaList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Dermatology' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getPreoperList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Preoperative' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getOrthoList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'OrthoPediac' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getPeadiacList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Peadiatric' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getNueroList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Nuerology' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public ObservableList<PatientListDTO> getPainList() throws SQLException {
            PatientListDTO patientListDTO = new PatientListDTO();
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select PatientId,Age,Gender,BloodGroup,HeartRate,BloodPressure,Status from Patient where ClinicToBeAssigned = 'Pain Management' ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                patientListDTO.setId((resultSet.getString("PatientID")));
                patientListDTO.setPAge(Integer.parseInt(resultSet.getString("Age")));
                patientListDTO.setPGender(resultSet.getString("Gender"));
                patientListDTO.setBloodGrp(resultSet.getString("BloodGroup"));
                patientListDTO.setHeartRate(Integer.parseInt(resultSet.getString("HeartRate")));
                patientListDTO.setBloodPressure(resultSet.getString("BloodPressure"));
                patientListDTO.setStatus(resultSet.getString("status"));
            }
            ObservableList<PatientListDTO> list = FXCollections.observableArrayList();
            list.add(patientListDTO);
            return list;
    }
    public boolean updatePatientClinicDetails(PatientCurrentDetailDTO patientCurrentDetailDTO) throws SQLException {
            PreparedStatement preparedStatement1 = DBConnection.getInstance().getConnection().prepareStatement("update Patient set BloodPressure = ?,HeartRate =?,Status = ?,ClinicToBeAssigned = ? where PatientId = ?");
            preparedStatement1.setObject(1,patientCurrentDetailDTO.getBloodPressure());
            preparedStatement1.setObject(2,patientCurrentDetailDTO.getHeartRate());
            preparedStatement1.setObject(3,patientCurrentDetailDTO.getStatus());
            preparedStatement1.setObject(4,patientCurrentDetailDTO.getClinicToBeAssigned());
            preparedStatement1.setObject(5,patientCurrentDetailDTO.getPatientId());
            boolean value = preparedStatement1.executeUpdate()>0;
            return value;
    }
    public boolean update(PatientDTO patientDTO) throws SQLException {
            PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("update Patient set Name =  ?,Address = ?,Gender = ?,Age = ?,Phone = ?,BloodGroup = ? where PatientId = ?");

            preparedStatement.setObject(1,patientDTO.getPatientName());
            preparedStatement.setObject(2,patientDTO.getAddress());
            preparedStatement.setObject(3,patientDTO.getGender());
            preparedStatement.setObject(4,patientDTO.getAge());
            preparedStatement.setObject(5,patientDTO.getPhone());
            preparedStatement.setObject(6,patientDTO.getBloodGroup());
            preparedStatement.setObject(7,patientDTO.getPatientID());

            boolean value = preparedStatement.executeUpdate()>0;
            return value;

    }
    public ObservableList<PatientCStatusDTO> searchPatientStatus(String patientId) throws SQLException {
            PatientCStatusDTO patientCStatusDTO = new PatientCStatusDTO();
            PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("select HeartRate,BloodPressure,Status from Patient where PatientId= ?");
            preparedStatement.setObject(1,patientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                patientCStatusDTO.setHeartRate(resultSet.getInt("HeartRate"));
                patientCStatusDTO.setBloodPressure(resultSet.getInt("BloodPressure"));
                patientCStatusDTO.setStatus(resultSet.getString("Status"));
            }
            ObservableList<PatientCStatusDTO> list = FXCollections.observableArrayList();
            list.add(patientCStatusDTO);
            return list;

    }
    public boolean retrievePatient(Connection connection,FullDetailDTO fullDetailDTO,String id) throws SQLException {
        String query1 = "SELECT * FROM ClinicDetail WHERE PatientId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            fullDetailDTO.setPId(resultSet.getString("PatientId"));
            fullDetailDTO.setCId(resultSet.getString("ClinicId"));
            fullDetailDTO.setDate(resultSet.getString("Date"));
            fullDetailDTO.setManagePlan(resultSet.getString("ManagePlan"));
            fullDetailDTO.setMedication(resultSet.getString("Medication"));
            fullDetailDTO.setSymptoms(resultSet.getString("Symptoms"));
            fullDetailDTO.setDiagnosis(resultSet.getString("Diagnosis"));
            return true;

        }
        return false;
    }
}
