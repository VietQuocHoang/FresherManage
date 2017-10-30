package com.group.FresherManagement.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Subject implements Serializable {
    private int id;
    private String name;
    private String acronym;
    private String description;
    private boolean available;
    private List<Courses_Subject> coursesSubjectList;

    public Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    @Column(name = "acronym", unique = true)
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(orphanRemoval = true, mappedBy = "subject")
    public List<Courses_Subject> getCoursesSubjectList() {
        return coursesSubjectList;
    }

    public void setCoursesSubjectList(List<Courses_Subject> coursesSubjectList) {
        this.coursesSubjectList = coursesSubjectList;
    }
}
