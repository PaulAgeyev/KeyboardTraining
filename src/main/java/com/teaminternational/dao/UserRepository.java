package com.teaminternational.dao;


import com.teaminternational.domain.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import com.teaminternational.domain.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;


/**
 * Created by pavel on 07.07.16.
 */

public interface UserRepository extends Repository<User, Long> {
    /*@Query("select login from User where firsName = :firstName or lastName = :lastName")
    User findByLastnameOrFirstname(@Param("firsName") String lastName,
                                   @Param("firsNname") String firstName);*/



    /*@Query(value = "SELECT c FROM User c WHERE c.user_id=1", nativeQuery = true)
    User findo();*/

    @Query(value = "SELECT * FROM User where user.login=?1", nativeQuery = true)
    User findByLogin(String login);

    User save(User entity);

}
