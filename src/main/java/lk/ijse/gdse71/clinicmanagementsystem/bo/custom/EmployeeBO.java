package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.EmployeeDTO;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {

    boolean  add(EmployeeDTO employeeDTO) throws SQLException;

    boolean update(EmployeeDTO employeeDTO) throws SQLException;

    boolean remove(String empId) throws SQLException;
}
