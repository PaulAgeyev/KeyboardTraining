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
                        "VALUES (1, 1, 'Steve Jobs', 'Steven Paul Jobs was born on February 24, 1955 in San Francisco, California. " +
                        "His unwed biological parents, Joanne Schieble and Abdulfattah Jandali, put him up for adoption. " +
                        "Steve was adopted by Paul and Clara Jobs, a lower-middle-class couple, who moved to the " +
                        "suburban city of Mountain View a couple of years later.')");

        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (2, 100, 'Apple Inc.','Apple Inc. is an American multinational " +
                        "technology company headquartered in Cupertino, California, that designs, develops, and sells consumer electronics, " +
                        "computer software, and online services. Its hardware products include the iPhone smartphone, the iPad tablet computer, the Mac personal computer, the iPod portable media player, " +
                        "the Apple Watch smartwatch, and the Apple TV digital media player.')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (3, 200, 'Microsoft Corporation', 'Microsoft Corporation is an American multinational " +
                        "technology company headquartered in Redmond, " +
                        "Washington, that develops, manufactures, licenses, supports and sells computer software, " +
                        "consumer electronics and personal computers and services. Its best known software products are the " +
                        "Microsoft Windows line of operating systems, Microsoft Office office suite, " +
                        "and Internet Explorer and Edge web browsers.')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (4, 300, 'Hewlett-Packard', 'The Hewlett-Packard Company (commonly referred to as HP) was an" +
                        " American multinational information technology company headquartered in Palo Alto, California. " +
                        "It developed and provided a wide variety of hardware components as well as software " +
                        "and related services to consumers, small- and medium-sized businesses (SMBs) and large enterprises, " +
                        "including customers in the government, health and education sectors.')");
        jdbcTemplate.update(
                "INSERT INTO Assignment " +
                        "VALUES (5, 400, 'Kharkiv', 'Kharkiv is the second-largest city in Ukraine. Located in the north-east of " +
                        "the country, it is the largest city of the Slobozhanshchyna historical region. The city has a population of " +
                        "about 1.5 million people. Kharkiv is the administrative centre of Kharkiv Oblast and of " +
                        "the surrounding Kharkiv district. The city was founded in 1654 and after a humble beginning as a " +
                        "small fortress grew to be a major centre of Ukrainian industry, trade and culture within the Russian Empire. " +
                        "Kharkiv was the first capital of the Ukrainian Soviet Socialist Republic December 1917 - January 1935, " +
                        "after which the capital relocated to Kiev.')");

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