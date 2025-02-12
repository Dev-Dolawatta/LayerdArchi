package lk.ijse.gdse71.clinicmanagementsystem.dao;

import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.ClinicDAO;
import lk.ijse.gdse71.clinicmanagementsystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {

    }
   public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();

        }
        return daoFactory;
   }
   public enum DAOType {
        ClinicDAO,DoctorDAO,PatientDAO,EmployeeDAO,ReportDAO,SupplierDAO,TestDAO,MedicineDAO
   }
   public SuperDAO getDAO(DAOType type) {
        switch (type) {
            case ClinicDAO:
                return new ClinicDAOImpl();
            case DoctorDAO:
                return new DoctorDAOImpl();
            case PatientDAO:
                return new PatientDAOImpl();
            case EmployeeDAO:
                return new EmployeeDAOImpl();
            case ReportDAO:
                return new ReportDAOImpl();
            case SupplierDAO:
                return new SupplierDAOImpl();
            case TestDAO:
                return new TestDAOImpl();
            case MedicineDAO:
                return new MedicineDAOImpl();
            default:
                return null;
        }
   }
}
