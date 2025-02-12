package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Patient {
    private String patientID;
    private String patientName;
    private String address;
    private String gender;
    private int age;
    private int phone;
    private String bloodGroup;

    public Patient() {
    }


    public Patient(String patientID, String patientName, String address, String gender, int age, int phone, String bloodGroup) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.bloodGroup = bloodGroup;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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
}
