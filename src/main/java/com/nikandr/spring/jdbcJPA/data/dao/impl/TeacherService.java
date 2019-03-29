package com.nikandr.spring.jdbcJPA.data.dao.impl;

import com.nikandr.spring.jdbcJPA.data.dao.TeacherDAO;
import com.nikandr.spring.jdbcJPA.data.entities.Teacher;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class TeacherService implements TeacherDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Teacher addTeacher(Teacher t) {
        em.persist(t);
        return t;
    }

    @Override
    @Cacheable("teachersCache")
    public Teacher getTeacher(int id) {
        System.out.println("Called teachers getTeacher(int id)");
        return em.find(Teacher.class, id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }

    @Override
    @Cacheable("teachersCache")
    public List<Teacher> getTeachersByName(String name) {
        System.out.println("Called teachers getTeachersByName(String name)");
        Query q = em.createNamedQuery("Teacher.findByName");
        q.setParameter("name", name);
        return q.getResultList();
    }

    @Override
    @Cacheable("teachersCache")
    public List<Teacher> getTeachers() {
        System.out.println("Called teachers getTeachers()");
        Query q = em.createNamedQuery("Teacher.findAll");
        return q.getResultList();
    }
}
