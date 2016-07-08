package com.teaminternational.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pavel on 07.07.16.
 */
@RestController
class UserContoller{

    @Autowired
    public UserContoller(JdbcTemplate jdbcTemplate) {

    }

    @RequestMapping(value = "/login")
    public ModelAndView simple2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


}