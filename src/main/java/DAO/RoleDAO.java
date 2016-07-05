package DAO;

import Domain.Role;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
interface RoleDAO {

    ArrayList<Role> findByID();
    ArrayList<Role> findByName();

    boolean insertRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(Role role);
}
