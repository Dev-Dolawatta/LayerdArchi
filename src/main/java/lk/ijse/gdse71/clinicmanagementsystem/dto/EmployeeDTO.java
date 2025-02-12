package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class EmployeeDTO {
    private String empId;
    private String emplName;
    private String empPosition;
    private String clinicId;
    public EmployeeDTO() {

    }

    public EmployeeDTO(String empId, String emplName, String empPosition, String clinicId) {
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
