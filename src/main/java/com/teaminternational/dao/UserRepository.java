package com.teaminternational.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import com.teaminternational.domain.User;
import org.springframework.data.repository.query.Param;


/**
 * Created by pavel on 07.07.16.
 */
public interface UserRepository extends Repository<User, Long> {

    /*@Query("SELECT t.title FROM Todo t where t.id = :id")
    String ById(@Param("id") Long id);*/
}
