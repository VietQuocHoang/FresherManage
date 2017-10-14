package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "test_fresher")
public class Test_Fresher implements Serializable {
    private int id;
    private Fresher fresher;
    private float mark;
    private float maximum;
    private User markedBy;
    private Test test;
    private Date tookDate;
    private Date markDate;


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
    public Fresher getFresher() {
        return fresher;
    }

    public void setFresher(Fresher fresher) {
        this.fresher = fresher;
    }

    @Column
    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Column
    public float getMaximum() {
        return maximum;
    }

    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public User getMarkedBy() {
        return markedBy;
    }

    public void setMarkedBy(User markedBy) {
        this.markedBy = markedBy;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Column
    public Date getTookDate() {
        return tookDate;
    }

    public void setTookDate(Date tookDate) {
        this.tookDate = tookDate;
    }

    @Column
    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }
}
