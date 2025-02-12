package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Cardiac{
    private String id;
    private int pAge;
    private String pGender;
    private String bloodGrp;
    private int heartRate;
    private String bloodPressure;
    private String status;

    public Cardiac() {

    }

    public Cardiac(String id, int pAge, String pGender, String bloodGrp, int heartRate, String bloodPressure, String status) {
        this.id = id;
        this.pAge = pAge;
        this.pGender = pGender;
        this.bloodGrp = bloodGrp;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPAge() {
        return pAge;
    }

    public void setPAge(int pAge) {
        this.pAge = pAge;
    }

    public String getPGender() {
        return pGender;
    }

    public void setPGender(String pGender) {
        this.pGender = pGender;
    }

    public String getBloodGrp() {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
