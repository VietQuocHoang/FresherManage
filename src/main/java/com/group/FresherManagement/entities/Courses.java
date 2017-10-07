package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
public class Courses implements Serializable{
    private int id;
    private String courseName;
    private String courseDescription;
    private boolean isAvailable;


    public Courses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    @Column(name = "course_description")
    public String getCourseDescription() {
        return courseDescription;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
