package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
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
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView y(Model model, HttpServletRequest request) {

        model.addAttribute("user", request.getRemoteUser());
        System.out.println("get AVTOR!!\n");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            System.out.println("3AVTOR!!\n");

            UserDetails userDetails = (UserDetails) principal;

            //System.out.println(userRepository.findByLogin(userDetails.getUsername()));
            User user = userRepository.findByLogin(userDetails.getUsername());
            System.out.println(user.getId()+"name="+user.getFirstName());

            Progress progress = progressRepository.findByUserID(user.getId());
            System.out.println("error="+progress.getError()+" time="+progress.getTime()+" progress="+progress.getProgress());

            Assignment assignment = assignmentRepository.findByAssignmentID(progress.getAssigmentId());
            System.out.println("assignmenttext="+assignment.getText()+" lesson="+assignment.getLesson());

            //model.addAttribute("lesson", "Lesson: " + progress.getAssigmentId().getLesson());
           // model.addAttribute("text", progress.getAssigmentId().getText());
            ModelAndView mav = new ModelAndView("privateCabinet");
            mav.addObject("user", user);
            mav.addObject("progress", progress);
            mav.addObject("assignment", assignment);
            return mav;
        }
        ModelAndView mav = new ModelAndView("/privateCabinet");
        return mav;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {
        progressRepository.delete(Long.parseLong(request.getParameter("progress_id")));
        ModelAndView mav = new ModelAndView("redirect:/privateCabinet");
        return mav;
    }
}
