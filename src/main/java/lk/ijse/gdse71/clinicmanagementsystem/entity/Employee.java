package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Employee {
    private String empId;
    private String emplName;
    private String empPosition;
    private String clinicId;
    public Employee() {

    }

    public Employee(String empId, String emplName, String empPosition, String clinicId) {
        this.empId = empId;
        this.emplName = emplName;
        this.empPosition = empPosition;
        this.clinicId = clinicId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }
}
