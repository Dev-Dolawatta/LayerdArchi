package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.EmployeeBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.EmployeeDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.EmployeeDTO;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.EmployeeDAO);

    public boolean  add(EmployeeDTO employeeDTO) throws SQLException {
        employeeDAO.add(employeeDTO);
        return true;
    }
    public boolean update(EmployeeDTO employeeDTO) throws SQLException {
        employeeDAO.update(employeeDTO);
        return true;
    }
    public boolean remove(String empId) throws SQLException {
        employeeDAO.remove(empId);
        return true;
    }
}
