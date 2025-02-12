package lk.ijse.gdse71.clinicmanagementsystem.entity;

public class Supplier {
    private String supId;
    private String supName;
    private String company;
    private int phoneNumber;
    public Supplier() {

    }

    public Supplier(String supId, String company, int phoneNumber, String supName) {
        this.supId = supId;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.supName = supName;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
