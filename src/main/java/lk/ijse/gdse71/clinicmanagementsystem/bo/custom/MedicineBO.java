package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.sql.SQLException;

public interface MedicineBO extends SuperBO {
    boolean addMedicine(AddMedicineDTO addMedicineDTO) throws SQLException;

    boolean updateMedicine(AddMedicineDTO addMedicineDTO) throws SQLException;
}
