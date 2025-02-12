package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.EmployeeDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.EmployeeDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean  add(EmployeeDTO employeeDTO) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("insert into Employee(EmployeeId,Name,Position,ClinicId) values(?,?,?,?) ");
        preparedStatement.setObject(1,employeeDTO.getEmpId());
        preparedStatement.setObject(2,employeeDTO.getEmplName());
        preparedStatement.setObject(3,employeeDTO.getEmpPosition());
        preparedStatement.setObject(4,employeeDTO.getClinicId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean update(EmployeeDTO employeeDTO) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("update Employee set Name = ?,Position = ?,ClinicId = ? where EmployeeId = ?");

        preparedStatement.setObject(1,employeeDTO.getEmplName());
        preparedStatement.setObject(2,employeeDTO.getEmpPosition());
        preparedStatement.setObject(3,employeeDTO.getClinicId());
        preparedStatement.setObject(4,employeeDTO.getEmpId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean remove(String empId) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("delete from Employee where EmployeeId = ?");
        preparedStatement.setObject(1,empId);
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
}
