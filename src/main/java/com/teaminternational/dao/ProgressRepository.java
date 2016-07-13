package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by pavel on 07.07.16.
 */
public interface ProgressRepository extends Repository<Progress, Long> {

    /*@Query(value = "SELECT c FROM Progress c WHERE c.progress_id=1", nativeQuery = true)
    Progress findos();*/

}
