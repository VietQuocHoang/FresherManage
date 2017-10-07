package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
public class Course_Subject implements Serializable{
    private int id;
    private Courses courses;
    private Subject subject;
    private Date startDate;
    private Date endDate;

    public Course_Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Courses getCourses() {
        return courses;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Subject getSubject() {
        return subject;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
