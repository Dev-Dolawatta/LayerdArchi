package lk.ijse.gdse71.clinicmanagementsystem.entity;

import java.time.LocalDate;

public class AddMedicine {
    private String mediId;
    private String medName;
    private LocalDate expDate;
    private LocalDate mfdDate;
    private String supId;
    private int qty;
    private LocalDate date;

    public AddMedicine() {

    }

    public AddMedicine(String mediId, String medName, LocalDate expDate, LocalDate mfdDate, String supId, int qty, LocalDate date) {
        this.mediId = mediId;
        this.medName = medName;
        this.expDate = expDate;
        this.mfdDate = mfdDate;
        this.supId = supId;
        this.qty = qty;
        this.date = date;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String  getMediId() {
        return mediId;
    }

    public void setMediId(String mediId) {
        this.mediId = mediId;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public LocalDate getMfdDate() {
        return mfdDate;
    }

    public void setMfdDate(LocalDate mfdDate) {
        this.mfdDate = mfdDate;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
