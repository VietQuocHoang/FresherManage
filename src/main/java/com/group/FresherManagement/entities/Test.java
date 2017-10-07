package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Test implements Serializable {
    private int id;
    private String name;
    private String questions;
    private Course_Subject courseSubject;

    public Test() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "question")
    public String getQuestions() {
        return questions;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Course_Subject getCourseSubject() {
        return courseSubject;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setCourseSubject(Course_Subject courseSubject) {
        this.courseSubject = courseSubject;
    }
}
