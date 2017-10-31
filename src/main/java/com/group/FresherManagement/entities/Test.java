package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Test implements Serializable {
    private int id;
    private String name;
    private String questions;
    private CoursesSubject coursesSubject;

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
    public CoursesSubject getCoursesSubject() {
        return coursesSubject;
    }

    public void setCoursesSubject(CoursesSubject coursesSubject) {
        this.coursesSubject = coursesSubject;
    }
}
