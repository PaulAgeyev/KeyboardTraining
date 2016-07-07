package com.teaminternational.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teaminternational.dao.impl.RoleDaoImpl;
import com.teaminternational.dao.impl.UserDaoImpl;

import java.io.IOException;
import java.sql.*;

/**
 * Created by pavel on 05.07.16.
 */

public class UserService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // response.setContentType("text/html");

        String l = request.getParameter("login");
        String p = request.getParameter("password");

        login(l,p,request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void login(String login, String pass, HttpServletRequest request, HttpServletResponse response) {

        try {
            Login l = new Login(login,pass,request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}