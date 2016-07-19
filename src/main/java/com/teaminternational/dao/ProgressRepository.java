package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by pavel on 07.07.16.
 */
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    @Query(value = "SELECT * FROM Progress p  WHERE p.user_id=?1 "
            ,  nativeQuery = true)
    List<Progress> findByUserID(long id );

    @Query (value = "SELECT * FROM Progress p where p.assignment_id=?1 AND p.user_id=?2", nativeQuery = true)
    List<Progress> findByAssignmentID (long id, long id_user);

    @Query (value = "SELECT * FROM Progress p where p.assignment_id=?1 AND p.user_id=?2", nativeQuery = true)
    Progress findID (long id, long id_user);

}
