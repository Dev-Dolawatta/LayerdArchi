package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.MedicineBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.MedicineDAOImpl;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.AddMedicineDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicineBOImpl implements MedicineBO {
    public boolean addMedicine(AddMedicineDTO addMedicineDTO) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
//            String mediQuery = "insert into Medicine(MedId,Name,ExpDate,MfdDate) values(?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(mediQuery);
//            preparedStatement.setObject(1, addMedicineDTO.getMediId());
//            preparedStatement.setObject(2, addMedicineDTO.getMedName());
//            java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
//            preparedStatement.setObject(3, sqlDate);
//            java.sql.Date sqlDate1 = java.sql.Date.valueOf(addMedicineDTO.getMfdDate());
//            preparedStatement.setObject(4, sqlDate1);
//            if (preparedStatement.executeUpdate() > 0) {
            boolean result = new MedicineDAOImpl().save(connection,addMedicineDTO);
            if(result){
                if (new SupplierBOImpl().saveSupplier(addMedicineDTO,connection)){
                    connection.commit();
                    return true;
                }else {
                    connection.rollback();
                    return false;
                }
            }else{
                connection.rollback();
            }
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();//rollBack the transaction in case of failure
            }
            throw e;//re-throwing the exception
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }
        public boolean updateMedicine(AddMedicineDTO addMedicineDTO) throws SQLException {
        Connection connection = null;

        try{
            connection =  DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
//            String mediQuery = "update Medicine set Name = ?,ExpDate = ?,MfdDate = ? where MedId = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(mediQuery);
//            preparedStatement.setObject(1,addMedicineDTO.getMedName());
//            java.sql.Date sqlDate = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
//            preparedStatement.setObject(2,sqlDate);
//            java.sql.Date sqlDate1 = java.sql.Date.valueOf(addMedicineDTO.getExpDate());
//            preparedStatement.setObject(3,sqlDate1);
//            preparedStatement.setObject(4,addMedicineDTO.getMediId());
//            if (preparedStatement.executeUpdate() > 0) {
            boolean result =  new MedicineDAOImpl().updateMedicine(connection,addMedicineDTO);
            if(result){
                if(new SupplierBOImpl().updateMedSupplier(addMedicineDTO,connection)){
                    connection.commit();
                    return true;
                }
                else{
                    connection.rollback();
                    return false ;

                }
            }else{
                connection.rollback();
            }
        }
        catch (SQLException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }
        finally {
        connection.setAutoCommit(true);
        }

        return false;
    }



}
