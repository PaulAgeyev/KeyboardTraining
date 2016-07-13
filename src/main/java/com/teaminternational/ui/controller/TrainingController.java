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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String g(@RequestParam(value="lesson", required=false, defaultValue="Lesson: ") String name, Model model) {


        ProgressRepository progressRepository;

        model.addAttribute("lesson", name);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        System.out.println("GET L");

        return "home";
    }

}
