package com.teaminternational.dao;

import java.util.ArrayList;

import com.teaminternational.domain.Assigment;

/**
 * Created by pavel on 05.07.16.
 */
public interface AssigmentDAO {

    ArrayList<Assigment> findByID();

    void insertAssigment(Assigment assigment);
    boolean updateAssigment(Assigment assigment);
    boolean deleteAssigment(Assigment assigment);

}
