package lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.ReportBO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.DAOFactory;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.ReportDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ReportDTO;

import java.sql.SQLException;

public class ReportBOImpl implements ReportBO {

    ReportDAO reportDAO = (ReportDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ReportDAO);
    public ReportDTO showReport(String id) throws SQLException {
//        reportDAO.showReport();
        return reportDAO.showReport(id);
    }
    public boolean add(ReportDTO dto) throws SQLException {
        return reportDAO.add(dto);
    }
    public boolean update(ReportDTO dto) throws SQLException {
        return reportDAO.update(dto);
    }
    public boolean remove(String id) throws SQLException {
        return reportDAO.remove(id);
    }
}
