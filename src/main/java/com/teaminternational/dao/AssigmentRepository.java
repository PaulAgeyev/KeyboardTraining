package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
/**
 * Created by pavel on 07.07.16.
 */
public interface AssigmentRepository extends JpaRepository <Assignment, Long> {

    @Query(value = "SELECT * FROM Progress p INNER JOIN Assignment a ON p.assignment_id = a.assignment_id WHERE p.user_id=?1 "
            ,  nativeQuery = true)
    List<Assignment> findAssignmentByUserID(long id );
}
