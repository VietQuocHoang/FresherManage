package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courses_subject")
public class CoursesSubject implements Serializable {
    private int id;
    private Courses courses;
    private Subject subject;

    public CoursesSubject() {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
