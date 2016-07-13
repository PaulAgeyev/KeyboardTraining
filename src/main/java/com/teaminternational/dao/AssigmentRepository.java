package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.expression.spel.ast.Assign;

/**
 * Created by pavel on 07.07.16.
 */
public interface AssigmentRepository extends JpaRepository<Assignment, Long> {

//    //@Query("SELECT text, lesson FROM Assignment")
//    default Assignment getAll() {
//        return null;
//    }

}
