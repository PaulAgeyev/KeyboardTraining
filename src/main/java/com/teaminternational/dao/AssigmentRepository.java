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

    @Query(value = "SELECT * FROM Progress p INNER JOIN Assignment a ON p.assignment_id = a.assignment_id WHERE p.user_id=?1 " +
            "ORDER BY a.lesson"
            ,  nativeQuery = true)
    List<Assignment> findAssignmentByUserID(long id);

    @Query(value = "SELECT * FROM Assignment a ORDER BY a.lesson"
            ,  nativeQuery = true)
    List<Assignment> getFirstLesson();

    @Query(value = "SELECT * FROM Assignment a where a.assignment_id = ?1"
            ,  nativeQuery = true)
    Assignment getID(long id);

    @Query(value = "SELECT a.assignment_id FROM Assignment a where a.lesson = ?1"
            ,  nativeQuery = true)
    long getIdbyLesson(long id);

    @Query(value = "SELECT a.text FROM Assignment a where a.lesson = ?1"
            ,  nativeQuery = true)
    String getTextbyLesson(long id);

    @Query(value = "SELECT * FROM Assignment a ORDER BY a.lesson"
            ,  nativeQuery = true)
    List<Assignment> findAllbyLesson();

    @Query(value = "SELECT a.lesson FROM Assignment a where a.assignment_id = ?1"
            ,  nativeQuery = true)
    long getLessonbyID(long id);


    @Query(value = "SELECT * FROM Assignment a WHERE a.assignment_id Not In " +
            "(SELECT aa.assignment_id FROM Assignment aa INNER JOIN Progress pp ON aa.assignment_id = pp.assignment_id WHERE pp.user_id = ?1)" +
            "ORDER BY a.lesson"
            ,  nativeQuery = true)
    List<Assignment> getAssignmentsListPass(long user_id);

}
