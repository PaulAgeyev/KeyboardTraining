package com.teaminternational.service;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.teaminternational.dao.impl.UserDaoImpl;
import com.teaminternational.domain.User;

/**
 * Created by pavel on 05.07.16.
 */

public class Register extends HttpServlet {

    /*public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String n = request.getParameter("login");
        String p = request.getParameter("password");
        String f = request.getParameter("firstName");
        String l = request.getParameter("lastName");

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser(new User(n,1,p,f,l));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }*/

}