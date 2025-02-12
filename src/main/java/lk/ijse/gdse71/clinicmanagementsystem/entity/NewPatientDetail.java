package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class NewPatientDetail {
    String patientId;
    String name;
    String address;
    String gender;
    int age;
    int phone;
    String bloodGroup;
    int heartRate;
    String bloodP;
    String status;

    public NewPatientDetail() {

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodP() {
        return bloodP;
    }

    public void setBloodP(String bloodP) {
        this.bloodP = bloodP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NewPatientDetail(String patientId, String name, String address, String gender, int age, int phone, String bloodGroup, int heartRate, String bloodP, String status) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
        this.heartRate = heartRate;
        this.bloodP = bloodP;
        this.status = status;


    }
}
