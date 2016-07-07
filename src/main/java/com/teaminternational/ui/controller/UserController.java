package com.teaminternational.ui.controller;

/**
 * Created by pavel on 07.07.16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
class UserContoller{

    @Autowired
    public UserContoller(JdbcTemplate jdbcTemplate) {

    }
}