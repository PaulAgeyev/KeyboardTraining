package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
import com.teaminternational.domain.Assignment;
import org.codehaus.groovy.runtime.NullObject;
import org.json.JSONObject;
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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView view() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            User user = userRepository.findByLogin(userDetails.getUsername());
            List<Assignment> assignments = assignmentRepository.findAssignmentByUserID(user.getId());

            for (int i = 0; i < assignments.toArray().length; i++)
                assignments.get(i).setProgress(progressRepository.findByAssignmentID(assignments.get(i).getId(), user.getId()));

            ModelAndView mav = new ModelAndView("profile");
            if (assignments.toArray().length == 0)
                mav.addObject("isEmptyAssignmaent", "You don't have passed lessons!");
            mav.addObject("user", user);
            mav.addObject("assignments", assignments);
            return mav;
        }
        ModelAndView mav = new ModelAndView("/");
        return mav;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {
        progressRepository.delete(Long.parseLong(request.getParameter("progress_id")));
        ModelAndView mav = new ModelAndView("redirect:/profile");
        return mav;
    }

    @RequestMapping(value = "/tryagain", method = RequestMethod.GET)
    public ModelAndView method2(HttpServletRequest request) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        User user = userRepository.findByLogin(userDetails.getUsername());

        int lesson = Integer.parseInt(request.getParameter("loaded"));

        ModelAndView mav = new ModelAndView("tryagain");
        mav.addObject("user", request.getRemoteUser());
        mav.addObject("lesson", lesson);

        String text = assignmentRepository.getTextbyLesson(lesson);

        JSONObject resultJson = new JSONObject();
        resultJson.put("text", text);
        mav.addObject("text", resultJson.toString());

        return mav;
    }

}
