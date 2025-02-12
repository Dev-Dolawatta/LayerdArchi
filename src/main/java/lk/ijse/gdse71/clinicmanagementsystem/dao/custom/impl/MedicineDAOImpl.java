package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.MedicineDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicineDAOImpl implements MedicineDAO {
    public boolean save(Connection connection, AddMedicineDTO addMedicineDTO) throws SQLException {
        String mediQuery = "insert into Medicine(MedId,Name,ExpDate,MfdDate) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(mediQuery);
        preparedStatement.setObject(1, addMedicineDTO.getMediId());
        preparedStatement.setObject(2, addMedicineDTO.getMedName());
        java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
        preparedStatement.setObject(3, sqlDate);
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(addMedicineDTO.getMfdDate());
        preparedStatement.setObject(4, sqlDate1);
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }
    public boolean updateMedicine(Connection connection,AddMedicineDTO addMedicineDTO) throws SQLException {
        String mediQuery = "update Medicine set Name = ?,ExpDate = ?,MfdDate = ? where MedId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(mediQuery);
        preparedStatement.setObject(1,addMedicineDTO.getMedName());
        java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
        preparedStatement.setObject(2,sqlDate);
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
        preparedStatement.setObject(3,sqlDate1);
        preparedStatement.setObject(4,addMedicineDTO.getMediId());
        if (preparedStatement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

}
