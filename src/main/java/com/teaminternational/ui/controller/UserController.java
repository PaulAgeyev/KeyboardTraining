package com.teaminternational.ui.controller;

import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Role;
import com.teaminternational.domain.User;
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
 * Created by pavel on 07.07.16.
 */
@Controller
class UserController{

    Role roleU = new Role(2,"ROLE_USER");

    @Autowired
    public UserController(JdbcTemplate jdbcTemplate) {

        jdbcTemplate.update(
                "INSERT INTO Role " +
                        "VALUES (1, 'ROLE_ADMIN')");

        jdbcTemplate.update(
                "INSERT INTO Role " +
                        "VALUES (2, 'ROLE_USER')");

        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (1, 'Paul', 'Ageyev', 'roter', 'root', 1)");

        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (2, 'Steven', 'McLaren', 'steven', 'steven', 2)");

        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (1, 1, 'VAAASYA')");


        //PROGRESS ID, ERROR, PROGRESS %,TIME, ASSIGMENT ID, USER_ID


        jdbcTemplate.update(
                "INSERT INTO Progress " +
                        "VALUES (1, 0, 0, 0, 1, 2)");


        List l = jdbcTemplate.queryForList("select * from user");
        Iterator it = l.iterator();
        while(it.hasNext())
        {
            Object o = it.next();
            System.out.println(o.toString());
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView method1() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView method2() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView method3(HttpServletRequest request) {

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
    public String method4(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("registration");

        System.out.println("GET");

        return "registration";
    }


    @Autowired
    private UserRepository repository;

}