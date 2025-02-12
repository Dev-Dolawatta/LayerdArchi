package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class PatientDetailsDTO {
    private String name ;
    private String bloodGroup;

    public PatientDetailsDTO(){

    }

    public PatientDetailsDTO(String name, String bloodGroup) {
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
