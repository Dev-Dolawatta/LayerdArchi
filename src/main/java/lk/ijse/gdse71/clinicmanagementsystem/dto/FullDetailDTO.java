package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class FullDetailDTO {
    private String PId;
    private String CId;
    private String Date;
    private String ManagePlan;
    private String Medication;
    private String Symptoms;
    private String Diagnosis;
    private String TestId;
    private String TestDesc;
    private String TestDate;

    public FullDetailDTO() {

    }

    public FullDetailDTO(String PId, String CId, String date, String managePlan, String medication, String symptoms, String diagnosis, String testId, String testDesc, String testDate) {
        this.PId = PId;
        this.CId = CId;
        Date = date;
        ManagePlan = managePlan;
        Medication = medication;
        Symptoms = symptoms;
        Diagnosis = diagnosis;
        TestId = testId;
        TestDesc = testDesc;
        TestDate = testDate;
    }

    public String getPId() {
        return PId;
    }

    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getManagePlan() {
        return ManagePlan;
    }

    public void setManagePlan(String managePlan) {
        ManagePlan = managePlan;
    }

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String medication) {
        Medication = medication;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String symptoms) {
        Symptoms = symptoms;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }

    public String getTestId() {
        return TestId;
    }

    public void setTestId(String testId) {
        TestId = testId;
    }

    public String getTestDesc() {
        return TestDesc;
    }

    public void setTestDesc(String testDesc) {
        TestDesc = testDesc;
    }

    public String getTestDate() {
        return TestDate;
    }

    public void setTestDate(String testDate) {
        TestDate = testDate;
    }
}
