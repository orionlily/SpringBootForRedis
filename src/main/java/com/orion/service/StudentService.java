package com.orion.service;

import com.orion.domain.Student;
import com.orion.domain.Teacher;
import com.orion.mapper.StudentMapper;
import com.orion.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LLC on 2018/4/6.
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public Student findStudentByID(Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void saveStudentAndTeacher(Student student, Teacher teacher){
        studentMapper.insertSelective(student);
        teacherMapper.insertSelective(teacher);
    }

    public List<Student> findAll(){
       return studentMapper.findAll();
    }

}
