package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface SupplierBO extends SuperBO{

    boolean add(SupplierDTO supplierDTO) throws SQLException;

    boolean update(SupplierDTO supplierDTO) throws SQLException;

    boolean remove(String supId) throws SQLException;

    boolean saveSupplier(AddMedicineDTO addMedicineDTO, Connection connection) throws SQLException;
}
