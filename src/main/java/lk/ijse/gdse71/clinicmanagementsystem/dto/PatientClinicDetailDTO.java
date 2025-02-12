package lk.ijse.gdse71.clinicmanagementsystem.dto;

import java.time.LocalDate;

public class PatientClinicDetailDTO {
    private String patientId;
    private String managePlan;
    private LocalDate date;
    private String medication;
    private String symptoms;
    private String diagnosis;
    public PatientClinicDetailDTO() {

    }

    public PatientClinicDetailDTO(String managePlan, LocalDate date, String medication, String symptoms, String diagnosis,String patientId) {
        this.managePlan = managePlan;
        this.date = date;
        this.medication = medication;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.patientId = patientId;
    }

    public String getManagePlan() {
        return managePlan;
    }

    public void setManagePlan(String managePlan) {
        this.managePlan = managePlan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
