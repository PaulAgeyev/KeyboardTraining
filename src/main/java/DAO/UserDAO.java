package DAO;

import Domain.User;

import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
interface UserDAO {

    ArrayList<User> findAll();
    ArrayList<User> findByLogin();
    ArrayList<User> findByName();
    ArrayList<User> findByLastName();

    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);

}
