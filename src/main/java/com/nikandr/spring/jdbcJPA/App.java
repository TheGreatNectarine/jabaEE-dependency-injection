package com.nikandr.spring.jdbcJPA;

import static java.lang.System.out;

import com.nikandr.spring.jdbcJPA.data.entities.Lecture;
import com.nikandr.spring.jdbcJPA.data.entities.Teacher;
import com.nikandr.spring.jdbcJPA.worker.LectureWorker;
import com.nikandr.spring.jdbcJPA.worker.TeacherWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("db/jpa/SpringBeansJPA.xml");
        Lecture lecture = new Lecture();
        lecture.setName("Introduction to Spring");
        lecture.setCredits(2.5);
        LectureWorker worker = (LectureWorker) context.getBean("worker");
//        worker.addLecture(lecture);

//        CustomerWorker customerWorker = context.getBean(CustomerWorker.class);
//        customerWorker.addCustomers(App.generateCustomers());

//        System.out.println(customerWorker.getAllCustomers());
//        System.out.println("Get customer by last name\n");
//        System.out.println(customerWorker.getCustomersByName("Kundik"));
//        System.out.println(customerWorker.getCustomersByName("Mariel"));

        TeacherWorker teacherWorker = context.getBean(TeacherWorker.class);
//        teacherWorker.addTeahcers(fill());
        teacherWorker.getAllTeachers().forEach(out::println);
        out.println("Calling again getAllTeachers()");
        teacherWorker.getAllTeachers().forEach(out::println);

        out.println("Calling getTeachersByName(Nikonder)");
        teacherWorker.getTeacherByName("Nikonder").forEach(out::println);
        out.println("Calling getTeachersByName(Nikonder) again");
        teacherWorker.getTeacherByName("Nikonder").forEach(out::println);
        out.println("Calling getTeachersByName(Nikonder) again and again");
        teacherWorker.getTeacherByName("Nikonder").forEach(out::println);

        out.println("Calling again getAllTeachers() and again");
        teacherWorker.getAllTeachers().forEach(out::println);
    }

    private static List<Teacher> fill() {
        List<Teacher> teachers = new LinkedList<>();
        teachers.add(new Teacher("Dmytro", new Lecture("JavaEE", 4)));
        teachers.add(new Teacher("Oleksii", new Lecture("ПЫХА", 4)));
        teachers.add(new Teacher("Nikonder", new Lecture("Swift", 4)));
        return teachers;
    }
}
