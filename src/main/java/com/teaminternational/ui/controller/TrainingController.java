package com.teaminternational.ui.controller;

import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.cache.NullUserCache;
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

    @Autowired
    ProgressRepository progressRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String g(Model model, HttpServletRequest request) {

        model.addAttribute("user", request.getRemoteUser());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Integer key = 0;

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            System.out.println(userRepository.findByLogin(userDetails.getUsername()));
            User user = userRepository.findByLogin(userDetails.getUsername());
            System.out.println(user.getId());

            Progress progress = progressRepository.findByUserID(user.getId());
            System.out.println(progress.getAssigmentId().getLesson());

            model.addAttribute("lesson", "Lesson: " + progress.getAssigmentId().getLesson());
            model.addAttribute("text", progress.getAssigmentId().getText());
            key = 1;
        }

        ModelAndView mav = new ModelAndView();

        mav.addObject("userDetails", key);
        mav.setViewName("home");

        return "home";
    }

}
