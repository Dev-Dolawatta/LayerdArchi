package lk.ijse.gdse71.clinicmanagementsystem.dao.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dao.CrudDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.sql.SQLException;

public interface DoctorDAO extends CrudDAO<DoctorDTO> {
//    boolean addDoctor(DoctorDTO doctorDTO) throws SQLException;
    DoctorDTO searchDoctor(String doctorId) throws SQLException;
//    boolean updateDoctor(DoctorDTO doctorDTO ) throws SQLException;
//    boolean removeDoctor(String doctorId) throws SQLException;
}
