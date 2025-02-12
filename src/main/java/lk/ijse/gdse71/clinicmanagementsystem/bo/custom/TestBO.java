package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.TestDTO;

import java.sql.SQLException;

public interface TestBO extends SuperBO {

    boolean add(TestDTO testDTO) throws SQLException;

    boolean update(TestDTO testDTO) throws SQLException;

    boolean remove(String id) throws SQLException;
}
