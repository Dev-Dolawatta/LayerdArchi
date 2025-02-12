package lk.ijse.gdse71.clinicmanagementsystem.dao.custom;

import lk.ijse.gdse71.clinicmanagementsystem.dao.CrudDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ReportDTO;

import java.sql.SQLException;

public interface ReportDAO extends CrudDAO<ReportDTO> {
    ReportDTO showReport(String id) throws SQLException;
}
