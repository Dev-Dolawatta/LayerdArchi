package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class PatientCStatusDTO {
    private int heartRate;
    private double bloodPressure;
    private String status;

    public PatientCStatusDTO() {

    }

    public PatientCStatusDTO(int heartRate, double bloodPressure, String status) {
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.status = status;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
