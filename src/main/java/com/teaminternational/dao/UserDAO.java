package com.teaminternational.dao;

import java.util.ArrayList;

import com.teaminternational.domain.User;

/**
 * Created by pavel on 05.07.16.
 */
public interface UserDAO {

    ArrayList<User> findAll();
    ArrayList<User> findByLogin();
    ArrayList<User> findByPassword();
    ArrayList<User> findByName();
    ArrayList<User> findByLastName();


    void insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);

}
