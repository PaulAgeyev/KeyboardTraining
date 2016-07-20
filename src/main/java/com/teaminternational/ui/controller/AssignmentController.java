package com.teaminternational.ui.controller;

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
 * Created by Nikitos on 13.07.2016.
 */
@Controller
public class AssignmentController {

    private int changeAssignmentId;

    @Autowired
    private AssigmentRepository assigmentRepository;

    @RequestMapping(value = "panel", method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("panel");
        mav.addObject("message", assigmentRepository.findAllbyLesson());
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {
        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(Long.parseLong(request.getParameter("assignment_id")));
        assignment.setText(request.getParameter("text_db"));
        assigmentRepository.save(assignment);
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteAssignment (HttpServletRequest request) {
        assigmentRepository.delete(Long.parseLong(request.getParameter("assignment_id")));
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView method4() {
        ModelAndView mav = new ModelAndView("create");
        return mav;
    }

    @RequestMapping(value = "createindb", method = RequestMethod.POST)
    public ModelAndView method5(HttpServletRequest request) {
        Assignment assignment = new Assignment();
        assignment.setLesson(Integer.parseInt((request.getParameter("lesson"))));
        assignment.setNameLesson(request.getParameter("newNameLesson"));
        assignment.setText(request.getParameter("text_db"));
        assigmentRepository.save(assignment);
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "rename", method = RequestMethod.POST)
    public ModelAndView RenameLesson(HttpServletRequest request) {

        long assignment_id = Long.parseLong(request.getParameter("assignment_id"));
        String nameLesson = request.getParameter("NameLesson");
        //System.out.println("rename assignment_id="+assignment_id);
        ModelAndView mav = new ModelAndView("rename");
        mav.addObject("assignment_id", assignment_id);
        mav.addObject("NameLesson", nameLesson);
        return mav;
    }

    @RequestMapping(value = "saveRenameLesson", method = RequestMethod.POST)
    public ModelAndView renameNameLesson (HttpServletRequest request) {

        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(Long.parseLong(request.getParameter("assignment_id")));
        assignment.setNameLesson(request.getParameter("newNameLesson"));
        assigmentRepository.save(assignment);
        //System.out.println("saveRenameLesson");
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

    @RequestMapping(value = "exchange", method = RequestMethod.POST)
    public ModelAndView exchangeLesson(HttpServletRequest request) {

        long assignment_id = Long.parseLong(request.getParameter("assignment_id"));
        ModelAndView mav = new ModelAndView("exchange");
        mav.addObject("assignment_id", assignment_id);
        return mav;
    }

    @RequestMapping(value = "saveExchangeLesson", method = RequestMethod.POST)
    public ModelAndView saveExchangeLesson (HttpServletRequest request) {

        long assignment_id = Long.parseLong(request.getParameter("assignment_id"));
        long exchangeLesson = Long.parseLong(request.getParameter("exchangeLesson"));
        long exchangeLessonId = assigmentRepository.getIdbyLesson(exchangeLesson);



        System.out.println("assignment_id="+assignment_id);
        System.out.println("exchangeLesson id ="+ exchangeLessonId);

        System.out.println("1");
        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(assignment_id);
        //assignment.setId(exchangeLessonId);

        Assignment temp = new Assignment();
       //temp.setNameLesson(assignment.getNameLesson());
        //temp.setProgress(assignment.getProgress());
        //temp.setText(assignment.getText());
        temp.setLesson(assignment.getLesson());


        System.out.println("2");



        Assignment exchangeAssignment = new Assignment();
        exchangeAssignment = assigmentRepository.getID(exchangeLessonId);

        assignment.setLesson(exchangeAssignment.getLesson());
       //assignment.setNameLesson(exchangeAssignment.getNameLesson());
       //assignment.setProgress(exchangeAssignment.getProgress());
       // assignment.setText(exchangeAssignment.getText());

        //exchangeAssignment.setNameLesson(temp.getNameLesson());
       // exchangeAssignment.setProgress(temp.getProgress());
       // exchangeAssignment.setText(temp.getText());
        exchangeAssignment.setLesson(temp.getLesson());

        System.out.println("3");

        assigmentRepository.save(assignment);
        System.out.println("4");
        assigmentRepository.save(exchangeAssignment);
        System.out.println("5");
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }
}
