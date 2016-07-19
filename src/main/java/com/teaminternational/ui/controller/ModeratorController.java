package com.teaminternational.ui.controller;

import com.teaminternational.dao.ModeratorRepository;
import com.teaminternational.domain.Moderator;
import org.springframework.stereotype.Controller;
import com.teaminternational.dao.AssigmentRepository;
//import com.teaminternational.domain.Role;
//import com.teaminternational.domain.User;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Assignment;
import com.teaminternational.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Nikitos on 18.07.2016.
 */

@Controller
public class ModeratorController {
    @Autowired
    private ModeratorRepository moderatorRepository;

    @RequestMapping(value = "moderator", method = RequestMethod.GET)
    public ModelAndView ShowBug() {
        ModelAndView mav = new ModelAndView("/moderator");

        mav.addObject("checkedBox", moderatorRepository.findAll());

        System.out.println("ShowBug");
        return mav;
    }

    @RequestMapping(value = "moderator", method = RequestMethod.POST)
    public ModelAndView SelectBug() {
        ModelAndView mav = new ModelAndView("moderator");
        Moderator moderator = new Moderator();
        //moderator.setStatus();
        System.out.println("SelectBug");
        return mav;
    }

}
