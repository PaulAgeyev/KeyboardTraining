package com.teaminternational.dao;


import com.teaminternational.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import com.teaminternational.domain.User;
import org.springframework.data.repository.query.Param;


/**
 * Created by pavel on 07.07.16.
 */

public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM User where user.login=?1", nativeQuery = true)
    User findByLogin(String login);

    User save(User entity);

    @Query(value = "SELECT * FROM User where user.user_id=?1", nativeQuery = true)
    User findByID(long id);

}
