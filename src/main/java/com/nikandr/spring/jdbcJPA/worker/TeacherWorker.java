package com.nikandr.spring.jdbcJPA.worker;

import com.nikandr.spring.jdbcJPA.data.dao.TeacherDAO;
import com.nikandr.spring.jdbcJPA.data.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TeacherWorker {

    @Autowired
    private TeacherDAO teacherService;

    public void addTeahcers(List<Teacher> teachers) {
        teachers.forEach(teacherService::addTeacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherService.getTeachers();
    }

    public List<Teacher> getTeacherByName(String name) {
        return teacherService.getTeachersByName(name);
    }
}
