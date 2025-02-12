package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class PatientCurrentDetailDTO {
    private String patientId;
    private String bloodPressure;
    private String heartRate;
    private String status;
    private String clinicToBeAssigned;

    public PatientCurrentDetailDTO() {

    }

    public PatientCurrentDetailDTO(String patientId, String bloodPressure, String heartRate, String status,String clinicToBeAssigned) {
        this.patientId = patientId;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.status = status;
        this.clinicToBeAssigned = clinicToBeAssigned;

    }

    public String getClinicToBeAssigned() {
        return clinicToBeAssigned;
    }

    public void setClinicToBeAssigned(String clinicToBeAssigned) {
        this.clinicToBeAssigned = clinicToBeAssigned;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
