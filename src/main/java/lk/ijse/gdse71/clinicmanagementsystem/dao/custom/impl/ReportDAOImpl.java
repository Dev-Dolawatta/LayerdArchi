package lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.ReportDAO;
import lk.ijse.gdse71.clinicmanagementsystem.db.DBConnection;
import lk.ijse.gdse71.clinicmanagementsystem.dto.ReportDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportDAOImpl implements ReportDAO {
    public ReportDTO showReport(String id) throws SQLException {
        ReportDTO reportDTO = new ReportDTO();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("select distinct p.Name,cd.ClinicId,cd.ManagePlan,cd.Medication,cd.Symptoms,cd.Diagnosis,t.TestId,t.Description,t.Date as TestDate from Patient p join ClinicDetail cd on p.PatientId = cd.PatientId join Test t on cd.PatientId = t.PatientId where p.PatientId = ? ");
        preparedStatement.setObject(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            reportDTO.setName(resultSet.getString("Name"));
            reportDTO.setClinicId(resultSet.getString("ClinicId"));
            reportDTO.setManagePlan(resultSet.getString("ManagePlan"));
            reportDTO.setMedication(resultSet.getString("Medication"));
            reportDTO.setSymptoms(resultSet.getString("Symptoms"));
            reportDTO.setDiagnosis(resultSet.getString("Diagnosis"));
            reportDTO.setTestId(resultSet.getString("TestId"));
            reportDTO.setDescription(resultSet.getString("Description"));
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String text = date.format(formatter);
            reportDTO.setDate(text);
        }

        return reportDTO;
    }

    @Override
    public boolean add(ReportDTO dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ReportDTO dto) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(String id) throws SQLException {
        return false;
    }
}
