package lk.ijse.gdse71.clinicmanagementsystem.dto;

import java.time.LocalDate;

public class ReportDTO {
    private String name;
    private String clinicId;
    private String managePlan;
    private String medication;
    private String symptoms;
    private String diagnosis;
    private String testId;
    private String description;
    private String date;

    public ReportDTO(){

    }

    public ReportDTO(String name, String clinicId, String managePlan, String medication, String symptoms, String diagnosis, String testId, String description, String date) {
        this.name = name;
        this.clinicId = clinicId;
        this.managePlan = managePlan;
        this.medication = medication;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.testId = testId;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getManagePlan() {
        return managePlan;
    }

    public void setManagePlan(String managePlan) {
        this.managePlan = managePlan;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
