package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.DoctorBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.DoctorDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.sql.SQLException;

public class DoctorBOImpl implements DoctorBO {


    DoctorDAO doctorDAO = (DoctorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.DoctorDAO);
    public boolean add(DoctorDTO doctorDTO) throws SQLException {
        return doctorDAO.add(doctorDTO);

    }
    public DoctorDTO searchDoctor(String doctorId) throws SQLException {
//        doctorDAO.searchDoctor(doctorId);
        return doctorDAO.searchDoctor(doctorId);
    }
    public boolean update(DoctorDTO doctorDTO ) throws SQLException {
        return doctorDAO.update(doctorDTO);

    }
    public boolean remove(String doctorId) throws SQLException {
        return doctorDAO.remove(doctorId);
    }
}
