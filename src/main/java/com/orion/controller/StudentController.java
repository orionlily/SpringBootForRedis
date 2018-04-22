package com.orion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orion.domain.Student;
import com.orion.domain.Teacher;
import com.orion.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by LLC on 2018/4/6.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/saveBoth")
    public void savesaveBoth(){
        Student student = new Student();
        student.setTime(new Date());
        student.setSex("女");
        student.setName("张雄嗯嗯发");

        Teacher teacher = new Teacher();
        teacher.setAge(24);
        teacher.setName("林老师");

        studentService.saveStudentAndTeacher(student,teacher);
    };

    @RequestMapping("getPageStudent")
    public PageInfo getPageStudent(@RequestParam(value = "page") int page,@RequestParam(value = "rows") int rows){
        PageHelper.startPage(page,rows);
        PageHelper.orderBy("name desc");
        //设置分页后接着查询才能分页
        List<Student> students = studentService.findAll();
        PageInfo<Student> pi = new PageInfo<>(students);
        return pi;
    }


}
