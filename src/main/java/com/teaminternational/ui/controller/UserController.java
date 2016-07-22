package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Assignment;
import com.teaminternational.domain.Role;
import com.teaminternational.domain.User;
import com.teaminternational.domain.Progress;
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


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private AssigmentRepository assigmentRepository;

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
                "INSERT INTO Role " +
                        "VALUES (3, 'ROLE_MODERATOR')");

        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (1, 'Paul', 'Ageyev', 'roter', 'root', 1)");

        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (2, 'Steven', 'McLaren', 'steven', 'steven', 2)");
        jdbcTemplate.update(
                "INSERT INTO User " +
                        "VALUES (3, 'Steven', 'McLaren', 'moderator', 'root', 3)");

        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (1, 1, 'Practicing letter A', 'text')");

        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (2, 100, 'Practicing letter B','text2')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (3, 200, 'Practicing letter C', 'text3')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (4, 300, 'Practicing letter D', 'text4')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (5, 400, 'Practicing letter E', 'text5')");

        //PROGRESS ID, ERROR, PROGRESS %,TIME, ASSIGMENT ID, USER_ID

        jdbcTemplate.update(
                "INSERT INTO Progress " +
                        "VALUES (1, 0, 0, 0, 1, 2)");

        jdbcTemplate.update(
                "INSERT INTO Moderator " +
                        "VALUES (1, 'BUG 1',1)");
        jdbcTemplate.update(
                "INSERT INTO Moderator " +
                        "VALUES (2, 'BUG 2',1)");

        List l = jdbcTemplate.queryForList("select * from user");
        Iterator it = l.iterator();
        while(it.hasNext())
        {
            Object o = it.next();
            System.out.println(o.toString());
        }

    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationPost(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("");
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPassword(request.getParameter("password"));
        user.setLogin(request.getParameter("username"));
        user.setIdRole(roleU);

        User findUser = userRepository.findByLogin(user.getLogin());
        if (findUser == null) {
            userRepository.save(user);
            User registeredUser = userRepository.findByLogin(user.getLogin());
            List<Assignment> assignment = assigmentRepository.getFirstLesson();
            assignment.get(0);
            mav.setViewName("redirect:/");
        }
        else {
            mav.setViewName("registration");
            mav.addObject("text","This login already exists");
        }
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationGet(@RequestParam(value="text", required=false, defaultValue="") String name, Model model) {

        model.addAttribute("text", name);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("registration");
        return "registration";
    }
}