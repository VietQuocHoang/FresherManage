package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
public class Fresher_Test_Course_Subject implements Serializable{
    private int id;
    private Fresher fresher;
    private Test test;
    private Date tookDate;
    private Date markDate;
    private User markedBy;
    private float mark;

    public Fresher_Test_Course_Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Fresher getFresher() {
        return fresher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Test getTest() {
        return test;
    }

    @Column(name = "took_date")
    public Date getTookDate() {
        return tookDate;
    }

    @Column(name = "mark_date")
    public Date getMarkDate() {
        return markDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public User getMarkedBy() {
        return markedBy;
    }

    @Column(name = "mark")
    public float getMark() {
        return mark;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFresher(Fresher fresher) {
        this.fresher = fresher;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setTookDate(Date tookDate) {
        this.tookDate = tookDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    public void setMarkedBy(User markedBy) {
        this.markedBy = markedBy;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
