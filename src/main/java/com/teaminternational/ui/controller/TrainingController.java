package com.teaminternational.ui.controller;

import com.teaminternational.dao.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pavel on 13.07.16.
 */
@Controller
public class TrainingController {


    @Autowired
    public TrainingController(JdbcTemplate jdbcTemplate) {

    }

    /*@Autowired
    ProgressRepository progressRepository;*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String g(Model model, HttpServletRequest request) {

        model.addAttribute("user",request.getRemoteUser());

        //progressRepository.curve();
        model.addAttribute("lesson", "");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        System.out.println("GET L");

        return "home";
    }

}
