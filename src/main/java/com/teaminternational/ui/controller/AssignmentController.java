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
import java.util.ArrayList;
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
    public ModelAndView messages(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("panel");
        mav.addObject("message", assigmentRepository.findAllbyLesson());
        mav.addObject("EmptyText", request.getParameter("EmptyText"));
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView method1(HttpServletRequest request) {
        String newTextDb = request.getParameter("text_db");
        if (newTextDb.trim().length() == 0) {
            ModelAndView mav = new ModelAndView("redirect:/panel");
            mav.addObject("EmptyText", "Fill out the field Text");
            return mav;
        }

        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(Long.parseLong(request.getParameter("assignment_id")));
        assignment.setText(newTextDb.trim());
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

        String newLessonStr = request.getParameter("lesson");
        String newNameLesson = request.getParameter("newNameLesson");
        String newTextDb = request.getParameter("text_db");
        int newLesson;

        if ( newLessonStr.equals("") || newNameLesson.equals("") || newTextDb.equals("") ){
            ModelAndView mav = new ModelAndView("redirect:/panel");
            mav.addObject("EmptyLesson", "Please, fill in all fields!");
            return mav;
        }
        else {
            newLesson = Integer.parseInt(newLessonStr);
            if (newLesson <1) {
                ModelAndView mav = new ModelAndView("redirect:/panel");
                mav.addObject("EmptyLesson", "Lesson should be above zero!");
                return mav;
            }
            else {
                Assignment newAssignment = new Assignment();
                newAssignment.setLesson(newLesson);
                newAssignment.setNameLesson(newNameLesson);
                newAssignment.setText(newTextDb);

                Assignment assignment = new Assignment();
                List<Assignment> newAssignmentList = new ArrayList<Assignment>();

                int isLesson = 0;
                List<Assignment> assignmentList = assigmentRepository.findAllbyLesson();
                for (Assignment a : assignmentList) {
                    if (a.getLesson() == newAssignment.getLesson() ) {
                        isLesson = 1;
                        break;
                    }
                }

                if (isLesson == 1) {
                    int numberOfLesson = 0;
                    for (int i = 0; i < assignmentList.size(); i++) {
                        assignment = assignmentList.get(i);
                        if (assignment.getLesson() < newAssignment.getLesson())
                        assigmentRepository.save(assignment);

                        else if (assignment.getLesson() == newAssignment.getLesson()) {
                            assigmentRepository.save(newAssignment);

                            numberOfLesson = newAssignment.getLesson() + 1;
                            assignment.setLesson(numberOfLesson);
                            assigmentRepository.save(assignment);
                        } else {
                            ++numberOfLesson;
                            assignment.setLesson(numberOfLesson);
                            assigmentRepository.save(assignment);
                        }
                    }
                }
                else {
                    assigmentRepository.save(newAssignment);
                }

            }
        }

        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }




    @RequestMapping(value = "rename", method = RequestMethod.POST)
    public ModelAndView RenameLesson(HttpServletRequest request) {

        long assignment_id = Long.parseLong(request.getParameter("assignment_id"));
        String nameLesson = request.getParameter("NameLesson");

        ModelAndView mav = new ModelAndView("rename");
        mav.addObject("assignment_id", assignment_id);
        mav.addObject("NameLesson", nameLesson);
        return mav;
    }

    @RequestMapping(value = "rename", method = RequestMethod.GET)
    public ModelAndView RenameLessonGet(HttpServletRequest request) {

        long assignment_id = Long.parseLong(request.getParameter("assignment_id"));
        String nameLesson = request.getParameter("NameLesson");

        ModelAndView mav = new ModelAndView("rename");
        mav.addObject("EmptyLesson", request.getParameter("EmptyLesson"));
        mav.addObject("assignment_id", assignment_id);
        mav.addObject("NameLesson", nameLesson);
        return mav;
    }

    @RequestMapping(value = "saveRenameLesson", method = RequestMethod.POST)
    public ModelAndView renameNameLesson (HttpServletRequest request) {

        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(Long.parseLong(request.getParameter("assignment_id")));
        String newNameLesson = request.getParameter("newNameLesson");

        if (newNameLesson.trim().length() == 0){
            ModelAndView mav = new ModelAndView("redirect:/rename");
            mav.addObject("assignment_id", request.getParameter("assignment_id"));
            mav.addObject("EmptyLesson", "Fill out the field Rename");
            return mav;
        }
        assignment.setNameLesson(newNameLesson.trim());
        assigmentRepository.save(assignment);
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

        Assignment assignment = new Assignment();
        assignment = assigmentRepository.getID(assignment_id);

        Assignment temp = new Assignment();
        temp.setLesson(assignment.getLesson());

        Assignment exchangeAssignment = new Assignment();
        exchangeAssignment = assigmentRepository.getID(exchangeLessonId);

        assignment.setLesson(exchangeAssignment.getLesson());
        exchangeAssignment.setLesson(temp.getLesson());

        assigmentRepository.save(assignment);
        assigmentRepository.save(exchangeAssignment);
        ModelAndView mav = new ModelAndView("redirect:/panel");
        return mav;
    }

}
