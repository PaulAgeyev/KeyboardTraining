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

    @Query(value = "SELECT * FROM Progress where Progress.user_id=?1", nativeQuery = true)
    Progress findByUserID(long id);


}
