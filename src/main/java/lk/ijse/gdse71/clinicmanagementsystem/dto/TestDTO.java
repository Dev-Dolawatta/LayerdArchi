package lk.ijse.gdse71.clinicmanagementsystem.dto;

import java.time.LocalDate;

public class TestDTO {
    private String testId;
    private String Desc;
    private LocalDate testDate;
    private String PatientId;

    public TestDTO() {

    }

    public TestDTO(String testId, String desc, LocalDate testDate, String patientId) {
        this.testId = testId;
        Desc = desc;
        this.testDate = testDate;
        PatientId = patientId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }
}
