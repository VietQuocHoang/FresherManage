package com.group.FresherManagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "courses_frehser")
public class Courses_Fresher {
    private int id;
    private Fresher fresher;
    private Courses courses;

    public Courses_Fresher() {
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
    public Fresher getFresher() {
        return fresher;
    }

    public void setFresher(Fresher fresher) {
        this.fresher = fresher;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
