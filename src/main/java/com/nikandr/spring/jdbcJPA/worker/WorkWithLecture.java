package com.nikandr.spring.jdbcJPA.worker;

import com.nikandr.spring.jdbcJPA.data.dao.LecturesDAO;
import com.nikandr.spring.jdbcJPA.data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class WorkWithLecture {

    @Autowired
    LecturesDAO lecturesDAO;

    public Lecture addLecture(Lecture lecture) {
        lecture = lecturesDAO.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }

}
