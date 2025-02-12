package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Clinic {
    private String ClinicID;
    private String ClinicName;

    public Clinic() {

    }

    public Clinic(String clinicID, String clinicName) {
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
