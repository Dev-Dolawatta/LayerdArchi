package lk.ijse.gdse71.clinicmanagementsystem.bo.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dto.ReportDTO;

import java.sql.SQLException;

public interface ReportBO extends SuperBO {

    ReportDTO showReport(String id) throws SQLException;

    boolean add(ReportDTO dto) throws SQLException;

    boolean update(ReportDTO dto) throws SQLException;

    boolean remove(String id) throws SQLException;
}
