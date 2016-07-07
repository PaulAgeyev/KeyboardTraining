package com.teaminternational.dao;

import java.util.ArrayList;

import com.teaminternational.domain.Role;

/**
 * Created by pavel on 05.07.16.
 */
public interface RoleDAO {

    ArrayList<Role> findByID();
    ArrayList<Role> findByName();

    void insertRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(Role role);
}
