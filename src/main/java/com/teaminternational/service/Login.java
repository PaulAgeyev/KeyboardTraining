package com.teaminternational.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by pavel on 06.07.16.
 */
public class Login {

    public Login(String login, String pass, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        final String DB_URL="jdbc:hsqldb:mem:FD";

        final String USER = "SA";
        final String PASS = "";


        Connection c = null;

        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = c.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM tbl_users");

            while (rs.next()) {

                if (rs.getString("login").equals(login) &&
                        rs.getString("password").equals(pass)) {
                    if (rs.getInt("id_role") == 1) {

                        //For test
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/trainer.jsp");
                        dispatcher.forward(request, response);

                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
