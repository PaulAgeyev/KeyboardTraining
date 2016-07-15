package com.teaminternational.ui.controller;

import com.teaminternational.dao.AssigmentRepository;
//import com.teaminternational.domain.Role;
//import com.teaminternational.domain.User;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * Created by Nikitos on 13.07.2016.
 */
@Controller
public class AssignmentController {

    @Autowired
    private AssigmentRepository repository;


    @RequestMapping(value = "panel", method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("panel");
        mav.addObject("message", repository.findAll());
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {

        Assignment assignment = new Assignment();
        assignment.setId(Integer.parseInt(request.getParameter("assignment_id")));
        assignment.setLesson(Integer.parseInt((request.getParameter("lesson_change"))));
        assignment.setText(request.getParameter("text_db"));
//        System.out.println("id="+assignment.getId()+" lesson="+assignment.getLesson()+" text="+assignment.getText());
        repository.save(assignment);

        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView method2(HttpServletRequest request) {
        repository.delete(Long.parseLong(request.getParameter("assignment_id")));
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView method4() {
        System.out.println("create post\n");
        ModelAndView mav = new ModelAndView("create");
        return mav;
    }

    @RequestMapping(value = "createindb", method = RequestMethod.POST)
    public ModelAndView method5(HttpServletRequest request) {

        Assignment assignment = new Assignment();
       // assignment.setId(Integer.parseInt(request.getParameter("assignment_id")));
        assignment.setLesson(Integer.parseInt((request.getParameter("lesson"))));
        assignment.setText(request.getParameter("text_db"));
        System.out.println("lesson="+assignment.getLesson()+" text="+assignment.getText());


        repository.save(assignment);
        System.out.println("conntroller repository post\n");
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }
}
