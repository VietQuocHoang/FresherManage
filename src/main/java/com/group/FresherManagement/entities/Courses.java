package com.group.FresherManagement.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Courses implements Serializable {
    private int id;
    private String courseName;
    private String courseDescription;
    private boolean isAvailable;
    private Date startDate;
    private Date endDate;
    private List<Courses_Subject> coursesSubjectList;
    private List<Courses_Fresher> coursesFresherList;

    public Courses() {
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

    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "course_description")
    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @Column(name = "available")
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "courses", orphanRemoval = true)
    public List<Courses_Subject> getCoursesSubjectList() {
        return coursesSubjectList;
    }

    public void setCoursesSubjectList(List<Courses_Subject> coursesSubjectList) {
        this.coursesSubjectList = coursesSubjectList;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "courses", orphanRemoval = true)
    public List<Courses_Fresher> getCoursesFresherList() {
        return coursesFresherList;
    }

    public void setCoursesFresherList(List<Courses_Fresher> coursesFresherList) {
        this.coursesFresherList = coursesFresherList;
    }
}
