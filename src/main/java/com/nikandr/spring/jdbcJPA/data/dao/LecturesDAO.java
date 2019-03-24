package com.nikandr.spring.jdbcJPA.data.dao;


import com.nikandr.spring.jdbcJPA.data.entities.Lecture;

public interface LecturesDAO {

    public Lecture addLecture(Lecture lecture);

    public Lecture getLecture(int id);

    public void saveLecture(Lecture lecture);

}
