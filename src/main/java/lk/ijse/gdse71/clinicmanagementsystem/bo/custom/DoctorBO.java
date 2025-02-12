package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.DoctorDTO;

import java.sql.SQLException;

public interface DoctorBO extends SuperBO{

    boolean add(DoctorDTO doctorDTO) throws SQLException;

    DoctorDTO searchDoctor(String doctorId) throws SQLException;

    boolean update(DoctorDTO doctorDTO ) throws SQLException;

    boolean remove(String doctorId) throws SQLException;
}
