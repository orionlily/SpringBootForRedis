package com.orion.controller;

import com.orion.domain.Teacher;
import com.orion.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by LLC on 2018/4/6.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @RequestMapping("/showTeachers")
    public String showTeachers(HttpServletRequest request){
        List<Teacher> teachers = teacherService.findAll();
        request.setAttribute("teachers",teachers);
        request.setAttribute("welcome","you are welcome!");
        request.setAttribute("now",new Date());
        return "teacher_list";
    }
}
