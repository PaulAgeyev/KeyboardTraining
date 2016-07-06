package Service;

import Domain.User;
import Impl.UserDaoImpl;

import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Created by pavel on 05.07.16.
 */

public class Register extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String n = request.getParameter("login");
        String p = request.getParameter("password");
        String f = request.getParameter("firstName");
        String l = request.getParameter("lastName");

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser(new User(n,1,p,f,l));

        final String DB_URL="jdbc:hsqldb:mem:FD";

        final String USER = "SA";
        final String PASS = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = conn.createStatement();

            String sql;

            sql = "INSERT INTO tbl_users " +
                    "(Login, id_role, Password, FirstName, LastName) " +
                    "VALUES ('paulageyev',1,'roter','Paul','Ageyev')";

            stm.executeQuery(sql);

            /*sql = "SELECT Login, id_role, Password, FirstName, LastName FROM tbl_users";

            ResultSet resultSet = stm.executeQuery(sql);

            while (resultSet.next()) {

                System.out.println(resultSet.getString("Login"));

            }*/

        }
        catch (SQLException ex) {
        ex.printStackTrace();
         }



        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

}