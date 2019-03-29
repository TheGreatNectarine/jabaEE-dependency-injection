package com.nikandr.spring.jdbcJPA.data.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
@NamedQueries({
        @NamedQuery(name = Teacher.FIND_ALL, query = "SELECT t FROM Teacher t"),
        @NamedQuery(name = Teacher.FIND_BY_NAME, query = "SELECT NEW Teacher(t.name) FROM Teacher t WHERE t.name = :name")
})
public class Teacher {

    public static final String FIND_ALL = "Teacher.findAll";
    public static final String FIND_BY_NAME = "Teacher.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "name")
    public String name;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = {
            CascadeType.PERSIST, CascadeType.REMOVE
    })
    @JoinColumn(name = "lecture_fk")
    private Lecture lecture;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lecture=" + lecture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getId() == teacher.getId() &&
                Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getLecture(), teacher.getLecture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLecture());
    }

}
