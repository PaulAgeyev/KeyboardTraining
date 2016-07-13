package com.teaminternational.dao;

import com.teaminternational.domain.Assignment;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
public interface AssigmentDAO {

    ArrayList<Assignment> findByID();

    void insertAssigment(Assignment assigment);
    boolean updateAssigment(Assignment assigment);
    boolean deleteAssigment(Assignment assigment);

}
