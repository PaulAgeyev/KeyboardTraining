package DAO;

import Domain.Assigment;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
public interface AssigmentDAO {

    ArrayList<Assigment> findByID();

    void insertAssigment(Assigment assigment);
    boolean updateAssigment(Assigment assigment);
    boolean deleteAssigment(Assigment assigment);

}
