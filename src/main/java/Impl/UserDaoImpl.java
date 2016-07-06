package Impl;
import DAO.UserDAO;
import Domain.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by pavel on 05.07.16.
 */
public class UserDaoImpl implements UserDAO {

    public ArrayList<User> findAll() {
        return null;
    }

    public ArrayList<User> findByLogin() {
        return null;
    }

    public ArrayList<User> findByName() {
        return null;
    }

    public ArrayList<User> findByPassword() {
        return null;
    }

    public ArrayList<User> findByLastName() {
        return null;
    }


    public void insertUser(User user) {

        final String DB_URL="jdbc:hsqldb:mem:FD";

        final String USER = "SA";
        final String PASS = "";

        try {

            String sql;
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            sql = "INSERT INTO tbl_users " +
                    "(Login, id_role, Password, FirstName, LastName) " +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setObject(1, user.getLogin());
            stmt.setObject(2, user.getId_role());
            stmt.setObject(3, user.getPassword());
            stmt.setObject(4, user.getFirstName());
            stmt.setObject(5, user.getLastName());

            stmt.executeUpdate();

            //TEST

            sql = "SELECT Login, id_role, Password, FirstName, LastName FROM tbl_users";

            Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);

            while (resultSet.next()) {

                System.out.println(resultSet.getString("Login"));
                System.out.println(resultSet.getString("id_role"));
                System.out.println(resultSet.getString("Password"));
                System.out.println(resultSet.getString("FirstName"));
                System.out.println(resultSet.getString("LastName"));
            }

            }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean updateUser(User user) {
        return false;
    }

    public boolean deleteUser(User user) {
        return false;
    }
}