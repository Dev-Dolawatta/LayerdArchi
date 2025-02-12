package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.SupplierBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.SupplierDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SupplierDAO);

    public boolean add(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.add(supplierDTO);
    }
    public boolean update(SupplierDTO supplierDTO) throws SQLException {
        return supplierDAO.update(supplierDTO);
    }
    public boolean remove(String supId) throws SQLException {
        return supplierDAO.remove(supId);
    }
    public boolean saveSupplier(AddMedicineDTO addMedicineDTO, Connection connection) throws SQLException {


        PreparedStatement preparedStatement1 = null;

        try {
//            String supplierDetailQuery = "insert into SupplierDetail(SupId,Qty,Date,MedId) values(?,?,?,?)";
//            preparedStatement1 = connection.prepareStatement(supplierDetailQuery);
//            preparedStatement1.setObject(1, addMedicineDTO.getSupId());
//            preparedStatement1.setObject(2, addMedicineDTO.getQty());
//            java.sql.Date sqlDate2 = java.sql.Date.valueOf(addMedicineDTO.getDate());
//            preparedStatement1.setObject(3, sqlDate2);
//            preparedStatement1.setObject(4,addMedicineDTO.getMediId());
//            if (preparedStatement1.executeUpdate() > 0){
            boolean result = new SupplierDAOImpl().saveSupplier(connection, addMedicineDTO);
            if (result) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public boolean updateMedSupplier (AddMedicineDTO addMedicineDTO,Connection connection){

        try{
//            String supplierDetailQuery = "update SupplierDetail set MedId = ?,Qty = ?,Date = ? where SupId = ?";
//            PreparedStatement preparedStatement1 = null ;
//            preparedStatement1 = connection.prepareStatement(supplierDetailQuery);
//            preparedStatement1.setObject(1, addMedicineDTO.getMediId());
//            preparedStatement1.setObject(2, addMedicineDTO.getQty());
//            java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getDate());
//            preparedStatement1.setObject(3,sqlDate);
//            preparedStatement1.setObject(4,addMedicineDTO.getSupId());
//
//            if (preparedStatement1.executeUpdate() > 0) {
            boolean result = new SupplierDAOImpl().updateSupplier(connection,addMedicineDTO);
            if (result) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
