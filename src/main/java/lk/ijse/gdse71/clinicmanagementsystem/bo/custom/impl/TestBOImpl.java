package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.TestBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.TestDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.TestDAOImpl;
import lk.ijse.gdse71.clinicmanagementsystem.dto.FullDetailDTO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBOImpl implements TestBO {

    TestDAO testDAO = (TestDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.TestDAO);

    public boolean add(TestDTO testDTO) throws SQLException {
        return testDAO.add(testDTO);
    }
    public boolean update(TestDTO testDTO) throws SQLException {
        return testDAO.update(testDTO);
    }
    public boolean remove(String id) throws SQLException {
        return testDAO.remove(id);
    }
    public boolean retrieveTestDetails(FullDetailDTO fullDetailDTO, Connection connection, String id) throws SQLException {
//        String query2 = "SELECT TestId, Description, Date FROM Test WHERE PatientId = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query2)
//            preparedStatement.setString(1, id);
//             ResultSet resultSet = preparedStatement.executeQuery();
//                if (resultSet.next()) {
//
//                    fullDetailDTO.setPId(resultSet.getString("TestId"));
//                    fullDetailDTO.setCId(resultSet.getString("Description"));
//                    fullDetailDTO.setDate(resultSet.getString("Date"));
        boolean result = new TestDAOImpl().retrieveTest(connection,fullDetailDTO,id);
        if(result){
          return true;
        }
        return false;



    }
}
