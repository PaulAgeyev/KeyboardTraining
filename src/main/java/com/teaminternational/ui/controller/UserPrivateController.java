package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
import com.teaminternational.domain.Assignment;
import org.codehaus.groovy.runtime.NullObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Nikitos on 15.07.2016.
 */
@Controller
public class UserPrivateController {
    @Autowired
    private AssigmentRepository assignmentRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private UserRepository userRepository;
/*
    @RequestMapping(value = "/privateCabinet", method = RequestMethod.POST)
    public ModelAndView u(Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/privateCabinet");
        System.out.println("post AVTOR!!\n");
        return mav;
    }*/

    @RequestMapping(value = "/privateCabinet", method = RequestMethod.GET)
    public ModelAndView y() {

        //model.addAttribute("user", request.getRemoteUser());


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            User user = userRepository.findByLogin(userDetails.getUsername());
            System.out.println("id="+user.getId()+" lname="+user.getLastName()+" fname="+user.getFirstName());
            List<Assignment> assignments = assignmentRepository.findAssignmentByUserID(user.getId());
        //if (assignments.toArray().length == 0) user.setFirstName("Nikita!!!");


            for (int i = 0; i < assignments.toArray().length; i++)
                assignments.get(i).setProgress(progressRepository.findByAssignmentID(assignments.get(i).getId()));

            for (Assignment a : assignments) {
                System.out.println("lesson="+a.getLesson()+" text="+a.getText());
                for (Progress p :a.getProgress())
                    System.out.println("error="+p.getError()+" time="+p.getTime()+" progress="+p.getProgress()+" id="+p.getProgressId());

            }
            ModelAndView mav = new ModelAndView("privateCabinet");
            mav.addObject("user", user);
            mav.addObject("assignments", assignments);
            return mav;
        }
        ModelAndView mav = new ModelAndView("/privateCabinet");
        return mav;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {
        System.out.println("gfhgm="+Long.parseLong(request.getParameter("progress_id")));

        progressRepository.delete(Long.parseLong(request.getParameter("progress_id")));
       // ModelAndView mav = new ModelAndView("redirect:/privateCabinet");

        ModelAndView mav = new ModelAndView("redirect:/privateCabinet");
        return mav;
    }
}
