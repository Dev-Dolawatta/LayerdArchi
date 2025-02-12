package lk.ijse.gdse71.clinicmanagementsystem.dto;

public class ClinicDTO {
    private String ClinicID;
    private String ClinicName;

    public ClinicDTO() {

    }

    public ClinicDTO(String clinicID, String clinicName) {
        ClinicID = clinicID;
        ClinicName = clinicName;
    }

    public String getClinicID() {
        return ClinicID;
    }

    public void setClinicID(String clinicID) {
        ClinicID = clinicID;
    }

    public String getClinicName() {
        return ClinicName;
    }

    public void setClinicName(String clinicName) {
        ClinicName = clinicName;
    }
}
