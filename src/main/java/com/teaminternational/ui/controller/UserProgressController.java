package com.teaminternational.ui.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.teaminternational.dao.AssigmentRepository;
import com.teaminternational.dao.ProgressRepository;
import com.teaminternational.dao.UserRepository;
import com.teaminternational.domain.Assignment;
import com.teaminternational.domain.Progress;
import com.teaminternational.domain.User;
import org.json.JSONObject;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 14.07.2016.
 */
@Controller
public class UserProgressController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssigmentRepository assigmentRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody boolean getJson(@RequestParam int progress, @RequestParam int errors, @RequestParam String time) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            User user = userRepository.findByLogin(userDetails.getUsername());

            List<Progress> progress1 = progressRepository.findByUserID(user.getId());

            ArrayList<Integer> values = new ArrayList<>();

            Progress progressHandler = new Progress();
            int max = 0;

            for (int i = 0; i < progress1.size(); i++) {
                values.add(progress1.get(i).getAssigmentId().getLesson());
                //System.out.println(progress1.get(i).getAssigmentId().getLesson());
                if (progress1.get(i).getAssigmentId().getLesson() > max) {
                    max = progress1.get(i).getAssigmentId().getLesson();
                    progressHandler = progress1.get(i);
                }
            }

            int lesson = progressHandler.getAssigmentId().getLesson();
            long lessonId = assigmentRepository.getIdbyLesson(lesson);
            Assignment assignment = assigmentRepository.getID(lessonId);

            progressHandler.setUserId(user);
            progressHandler.setAssigmentId(assignment);
            progressHandler.setProgress(progress);
            progressHandler.setError(errors);
            progressHandler.setTime(time);

            progressRepository.save(progressHandler);

            Progress progress3 = new Progress();


            lessonId = 0;
            int j = 1;

            while (lessonId == 0 ) {
                try {
                    lessonId = assigmentRepository.getIdbyLesson(lesson + j++);
                } catch (AopInvocationException e) {

                }
            }
            //lessonId = assigmentRepository.getIdbyLesson(lesson + 1);
            assignment = assigmentRepository.getID(lessonId);

            progress3.setUserId(user);
            progress3.setAssigmentId(assignment);
            progress3.setProgress(0);
            progress3.setError(0);
            progress3.setTime("");

            progressRepository.save(progress3);

        }
        else {
            TrainingController.positionLesson +=1;
        }
            return true;
        }

    @RequestMapping(value = "/tryagain", method = RequestMethod.POST)
    public @ResponseBody boolean getJsonTry(@RequestParam int progress, @RequestParam int errors,
                                            @RequestParam String time, @RequestParam int lesson) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            User user = userRepository.findByLogin(userDetails.getUsername());

            long assId = assigmentRepository.getIdbyLesson(lesson);

            Progress progress1 = progressRepository.findID(assId, user.getId());

            progress1.setProgress(progress);
            progress1.setError(errors);
            progress1.setTime(time);

            progressRepository.save(progress1);
        }
        return true;
    }

}
