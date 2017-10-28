package com.group.FresherManagement.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Fresher implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date dob;
    private String imgUrl;
    private boolean sex;
    private List<Courses_Fresher> coursesFresherList;
    private List<Test_Fresher> testFresherList;
    public Fresher() {
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

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "sex")
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "fresher", orphanRemoval = true)
    public List<Courses_Fresher> getCoursesFresherList() {
        return coursesFresherList;
    }

    public void setCoursesFresherList(List<Courses_Fresher> coursesFresherList) {
        this.coursesFresherList = coursesFresherList;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "fresher", orphanRemoval = true)
    public List<Test_Fresher> getTestFresherList() {
        return testFresherList;
    }

    public void setTestFresherList(List<Test_Fresher> testFresherList) {
        this.testFresherList = testFresherList;
    }
}
