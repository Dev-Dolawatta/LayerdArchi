package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class PatientDetails {
    private String name ;
    private String bloodGroup;

    public PatientDetails(){

    }

    public PatientDetails(String name, String bloodGroup) {
        this.name = name;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
