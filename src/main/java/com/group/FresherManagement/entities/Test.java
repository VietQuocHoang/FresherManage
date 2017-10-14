package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Test implements Serializable {
    private int id;
    private String name;
    private String questions;
    private Courses_Subject coursesSubject;

    public Test() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "question")
    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Courses_Subject getCoursesSubject() {
        return coursesSubject;
    }

    public void setCoursesSubject(Courses_Subject coursesSubject) {
        this.coursesSubject = coursesSubject;
    }
}
