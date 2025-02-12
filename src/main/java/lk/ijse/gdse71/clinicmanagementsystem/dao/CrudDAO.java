package lk.ijse.gdse71.clinicmanagementsystem.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO{
    boolean add(T dto) throws SQLException;

    boolean update(T dto) throws SQLException;

    boolean remove(String id) throws SQLException;

}