package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class PatientCStatus {
    private int heartRate;
    private double bloodPressure;
    private String status;

    public PatientCStatus() {

    }

    public PatientCStatus(int heartRate, double bloodPressure, String status) {
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
