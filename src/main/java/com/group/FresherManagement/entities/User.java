package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullname;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
