package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.expression.spel.ast.Assign;

/**
 * Created by pavel on 07.07.16.
 */
public interface AssigmentRepository extends JpaRepository <Assignment, Long> {
    /*@Modifying
    @Query("UPDATE Assignment c SET c.lesson = :lesson,  c.text = :text WHERE c.id = :id")
    Integer UpdateAffignmentById(@Param("lesson") String lesson, @Param("text") String text, @Param("id");*/
}
