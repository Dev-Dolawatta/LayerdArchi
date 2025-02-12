package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.SupplierDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierDAOImpl implements SupplierDAO {
    public boolean add(SupplierDTO supplierDTO) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("insert into Supplier(SupId,Company,TelNo,SupplierName) values(?,?,?,?)");
        preparedStatement.setObject(1,supplierDTO.getSupId());
        preparedStatement.setObject(2,supplierDTO.getCompany());
        preparedStatement.setObject(3,supplierDTO.getPhoneNumber());
        preparedStatement.setObject(4,supplierDTO.getSupName());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean update(SupplierDTO supplierDTO) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("update Supplier set Company = ?,TelNo = ?,SupplierName = ? where SupId = ?");

        preparedStatement.setObject(1,supplierDTO.getCompany());
        preparedStatement.setObject(2,supplierDTO.getPhoneNumber());
        preparedStatement.setObject(3,supplierDTO.getSupName());
        preparedStatement.setObject(4,supplierDTO.getSupId());
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean remove(String supId) throws SQLException {
        PreparedStatement preparedStatement =  DBConnection.getInstance().getConnection().prepareStatement("delete from Supplier where SupId = ?");
        preparedStatement.setObject(1,supId);
        boolean value = preparedStatement.executeUpdate()>0;
        return value;
    }
    public boolean saveSupplier(Connection connection, AddMedicineDTO addMedicineDTO) throws SQLException {
        PreparedStatement preparedStatement1 = null;
        String supplierDetailQuery = "insert into SupplierDetail(SupId,Qty,Date,MedId) values(?,?,?,?)";
        preparedStatement1 = connection.prepareStatement(supplierDetailQuery);
        preparedStatement1.setObject(1, addMedicineDTO.getSupId());
        preparedStatement1.setObject(2, addMedicineDTO.getQty());
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(addMedicineDTO.getDate());
        preparedStatement1.setObject(3, sqlDate2);
        preparedStatement1.setObject(4,addMedicineDTO.getMediId());
        if (preparedStatement1.executeUpdate() > 0){
            return true;
        }
        return false;
    }
    public boolean updateSupplier(Connection connection,AddMedicineDTO addMedicineDTO) throws SQLException {
        String supplierDetailQuery = "update SupplierDetail set MedId = ?,Qty = ?,Date = ? where SupId = ?";
        PreparedStatement preparedStatement1 = null ;
        preparedStatement1 = connection.prepareStatement(supplierDetailQuery);
        preparedStatement1.setObject(1, addMedicineDTO.getMediId());
        preparedStatement1.setObject(2, addMedicineDTO.getQty());
        java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getDate());
        preparedStatement1.setObject(3,sqlDate);
        preparedStatement1.setObject(4,addMedicineDTO.getSupId());

        if (preparedStatement1.executeUpdate() > 0) {
            return true;
        }
        return false;
    }
}
