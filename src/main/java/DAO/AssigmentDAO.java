package DAO;

import Domain.Assigment;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
interface AssigmentDAO {

    ArrayList<Assigment> findByID();

    boolean insertAssigment(Assigment assigment);
    boolean updateAssigment(Assigment assigment);
    boolean deleteAssigment(Assigment assigment);

}
