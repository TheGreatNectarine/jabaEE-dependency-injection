package com.nikandr.spring.jdbcJPA.data.dao;

import com.nikandr.spring.jdbcJPA.data.entities.Teacher;

import java.util.List;

public interface TeacherDAO {

    public Teacher addTeacher(Teacher t);

    public Teacher getTeacher(int id);

    public void saveTeacher(Teacher lecture);

    public List<Teacher> getTeachersByName(String name);

    public List<Teacher> getTeachers();

}
