package com.orion.service;

import com.orion.domain.Teacher;
import com.orion.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LLC on 2018/4/6.
 */
@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Transactional
    public  void saveTeacher(Teacher teacher){
        teacherMapper.insertSelective(teacher);
    }

    public List<Teacher> findAll(){
        return teacherMapper.findAll();
    }
}
