package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.SQLUtil;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.DoctorDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAOImpl implements DoctorDAO {
    public boolean add(DoctorDTO doctorDTO) throws SQLException {
        return SQLUtil.execute("insert into Doctor(DocId,Name,Salary,Position,UName,Pw,ClinicId)values(?,?,?,?,?,?,?)",doctorDTO.getDocId(),doctorDTO.getName(),doctorDTO.getSalary(),doctorDTO.getPosition(),doctorDTO.getuName(),doctorDTO.getPassword(),doctorDTO.getClinicId());
//        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("insert into Doctor(DocId,Name,Salary,Position,UName,Pw,ClinicId)values(?,?,?,?,?,?,?)");
//        preparedStatement.setObject(1, doctorDTO.getDocId());
//        preparedStatement.setObject(2, doctorDTO.getName());
//        preparedStatement.setObject(3, doctorDTO.getSalary());
//        preparedStatement.setObject(4, doctorDTO.getPosition());
//        preparedStatement.setObject(5,doctorDTO.getuName());
//        preparedStatement.setObject(6,doctorDTO.getPassword());
//        preparedStatement.setObject(7,doctorDTO.getClinicId());
//        boolean value = preparedStatement.executeUpdate()>0;
//        return value;

    }
    public DoctorDTO searchDoctor(String doctorId) throws SQLException {
        DoctorDTO doctorDTO = new DoctorDTO();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select DocId,Name,Salary,Position,UName,Pw,ClinicId from Doctor where DocId = ?");
        preparedStatement.setObject(1,doctorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            doctorDTO.setDocId(resultSet.getString("DocId"));
            doctorDTO.setName(resultSet.getString("Name"));
            doctorDTO.setSalary(Double.parseDouble(resultSet.getString("Salary")));
            doctorDTO.setPosition(resultSet.getString("Position"));
            doctorDTO.setuName(resultSet.getString("UName"));
            doctorDTO.setPassword(resultSet.getString("Pw"));
            doctorDTO.setClinicId(resultSet.getString("ClinicId"));
        }
        return doctorDTO;

    }
    public boolean update(DoctorDTO doctorDTO ) throws SQLException {

        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("update Doctor set Name = ?,Salary = ?,Position = ?,UName = ?,Pw = ?,ClinicId = ? where DocId = ?");

        preparedStatement.setObject(1,doctorDTO.getName());
        preparedStatement.setObject(2,doctorDTO.getSalary());
        preparedStatement.setObject(3,doctorDTO.getPosition());
        preparedStatement.setObject(4,doctorDTO.getuName());
        preparedStatement.setObject(5,doctorDTO.getPassword());
        preparedStatement.setObject(6,doctorDTO.getClinicId());
        preparedStatement.setObject(7,doctorDTO.getDocId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean remove(String doctorId) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("delete from Doctor where DocId = ?");
        preparedStatement.setObject(1,doctorId);
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
}
