package com.teaminternational.ui.controller;

import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Role;
import com.teaminternational.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * Created by pavel on 07.07.16.
 */
@Controller
class UserContoller{

    Role roleU = new Role(2,"ROLE_USER");

    @Autowired
    public UserContoller(JdbcTemplate jdbcTemplate) {

        jdbcTemplate.update(
                "INSERT INTO Role " +
                        "VALUES (1, 'ROLE_ADMIN')");

        jdbcTemplate.update(
                "INSERT INTO Role " +
                        "VALUES (2, 'ROLE_USER')");

        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (1, 'Paul', 'Ageyev', 'roter', 'root', 1)");

        List l = jdbcTemplate.queryForList("select u.login, r.name FROM User u INNER JOIN Role r ON u.user_id = r.role_id");
        Iterator it = l.iterator();
        while(it.hasNext())
        {
            Object o = it.next();
            System.out.println(o.toString());
        }
    }

    @RequestMapping(value = "/login")
    public ModelAndView simple() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView simple3(HttpServletRequest request) {

        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPassword(request.getParameter("username"));
        user.setLogin(request.getParameter("password"));
        user.setIdRole(roleU);

        repository.save(user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        System.out.println("POST");
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
        public ModelAndView simple2() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("registration");

        System.out.println("GET");

        return mav;
    }


    @Autowired
    private UserRepository repository;

}