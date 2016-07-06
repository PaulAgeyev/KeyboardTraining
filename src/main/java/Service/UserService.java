package Service;

import Impl.RoleDaoImpl;
import Impl.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by pavel on 05.07.16.
 */

public class UserService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String l = request.getParameter("login");
        String p = request.getParameter("password");

        final String DB_URL="jdbc:hsqldb:mem:FD";

        final String USER = "SA";
        final String PASS = "";

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}