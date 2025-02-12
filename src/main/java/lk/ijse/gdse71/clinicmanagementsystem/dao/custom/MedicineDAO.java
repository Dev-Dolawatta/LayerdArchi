package lk.ijse.gdse71.clinicmanagementsystem.dao.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dao.SuperDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface MedicineDAO extends SuperDAO {
    boolean save(Connection connection, AddMedicineDTO addMedicineDTO) throws SQLException;
}
