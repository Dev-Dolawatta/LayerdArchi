package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.TestDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.FullDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAOImpl implements TestDAO {
    public boolean add(TestDTO testDTO) throws SQLException {
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("insert into Test(TestId,Description,Date,PatientId) values(?,?,?,?)");
        preparedStatement.setObject(1, testDTO.getTestId());
        preparedStatement.setObject(2,testDTO.getDesc());
        java.sql.Date sqlDate = java.sql.Date.valueOf(testDTO.getTestDate());
        preparedStatement.setObject(3,sqlDate);
        preparedStatement.setObject(4,testDTO.getPatientId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean update(TestDTO testDTO) throws SQLException {
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("update Test set Description = ?,Date = ?,PatientId = ? where TestId = ?");

        preparedStatement.setObject(1,testDTO.getDesc());
        java.sql.Date sqlDate = java.sql.Date.valueOf(testDTO.getTestDate());
        preparedStatement.setObject(2,sqlDate);
        preparedStatement.setObject(3,testDTO.getPatientId());
        preparedStatement.setObject(4, testDTO.getTestId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;

    }
    public boolean remove(String id) throws SQLException {
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("delete from Test where TestId = ?");
        preparedStatement.setObject(1, id);
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean retrieveTest(Connection connection, FullDetailDTO fullDetailDTO,String id) throws SQLException {
        String query2 = "SELECT TestId, Description, Date FROM Test WHERE PatientId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query2);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            fullDetailDTO.setPId(resultSet.getString("TestId"));
            fullDetailDTO.setCId(resultSet.getString("Description"));
            fullDetailDTO.setDate(resultSet.getString("Date"));
            return true;
        }
        return false;

    }
}
