package com.teaminternational.ui.controller;

import com.teaminternational.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * Created by pavel on 07.07.16.
 */
@RestController
class UserContoller{


    @Autowired
    public UserContoller(JdbcTemplate jdbcTemplate) {

        jdbcTemplate.update(
                "INSERT INTO Role " +
                        "VALUES (1, 'ROLE_USER')");


        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (1, 'Paul', 'Ageyev', 'roter', 'root', true, 1)");


        List l = jdbcTemplate.queryForList("select login, password FROM user where user_id=1");
        Iterator it = l.iterator();
        while(it.hasNext())
        {
            Object o = it.next();
            System.out.println(o.toString());
        }

    }

    @RequestMapping(value = "/login")
    public ModelAndView simple2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


}