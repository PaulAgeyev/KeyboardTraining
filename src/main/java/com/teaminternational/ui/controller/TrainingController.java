package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Assignment;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
import org.json.JSONObject;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pavel on 13.07.16.
 */
@Controller
public class TrainingController {

    //for anonymous user
    public static int positionLesson = 1;

    @Autowired
    public TrainingController(JdbcTemplate jdbcTemplate) {

    }

    @Autowired
    AssigmentRepository assigmentRepository;

    @Autowired
    ProgressRepository progressRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Model model, HttpServletRequest request) {

        JSONObject resultJson = new JSONObject();

        ModelAndView mav = new ModelAndView("home");

        model.addAttribute("user", request.getRemoteUser());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            if (userDetails.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
                return new ModelAndView("redirect:" + "panel");
            }


            User user = userRepository.findByLogin(userDetails.getUsername());

            List<Progress> progress = progressRepository.findByUserID(user.getId());

            ArrayList<Integer> values = new ArrayList<>();

            int max = 0;

            Progress progressHandler = new Progress();

            for (int i = 0; i < progress.size(); i ++) {
                if (progress.get(i).getAssigmentId().getLesson() > max) {
                    progressHandler = progress.get(i);
                    max = progress.get(i).getAssigmentId().getLesson();
                }
            }

            resultJson.put("text",progressHandler.getAssigmentId().getText());

            mav.addObject("lesson", "Lesson: " + progressHandler.getAssigmentId().getNameLesson());
            mav.addObject("text", resultJson.toString());

            return mav;

        }
        else
        {
            Assignment assignment = assigmentRepository.getID(positionLesson);

            try {
                resultJson.put("text", assignment.getText());
            }
            catch (NullPointerException e) {

            }
            mav.addObject("lesson", "Lesson: " + assignment.getNameLesson());
            mav.addObject("text", resultJson.toString());

            return mav;
        }
    }

}