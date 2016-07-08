package com.teaminternational.dao;


import org.springframework.data.repository.*;
import com.teaminternational.domain.User;

/**
 * Created by pavel on 07.07.16.
 */

public interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
