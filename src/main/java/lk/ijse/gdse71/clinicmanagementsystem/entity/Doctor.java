package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Doctor {
    private String docId;
    private String name;
    private double salary;
    private String position;
    private String uName;
    private String password;
    private String clinicId;
    public Doctor() {

    }

    public Doctor(String docId, String name, double salary, String position, String uName, String password,String clinicId) {
        this.docId = docId;
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.uName = uName;
        this.password = password;
        this.clinicId = clinicId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }
}
