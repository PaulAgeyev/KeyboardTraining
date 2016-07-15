package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
//import com.teaminternational.domain.Role;
//import com.teaminternational.domain.User;
import com.teaminternational.domain.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nikitos on 14.07.2016.
 */
public class UserProgressController {

    @Autowired
    private AssigmentRepository repository;
}
