package lk.ijse.gdse71.clinicmanagementsystem.bo;

import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.SuperBO;
import lk.ijse.gdse71.clinicmanagementsystem.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOType {
        ClinicBO,DoctorBO,PatientBO,EmployeeBO,ReportBo,SupplierBO,TestBO,MedicineBO
    }
    public SuperBO getBO(BOType type) {
        switch (type) {
            case ClinicBO:
                return new ClinicBOImpl();
            case DoctorBO:
                return new DoctorBOImpl();
            case PatientBO:
                return new PatientBOImpl();
            case EmployeeBO:
                return new EmployeeBOImpl();
            case ReportBo:
                return new ReportBOImpl();
            case SupplierBO:
                return  new SupplierBOImpl();
            case TestBO:
                return new TestBOImpl();
            case MedicineBO:
                return new MedicineBOImpl();

            default:
                return null;
        }
    }
}
