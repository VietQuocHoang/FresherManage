package com.group.FresherManagement.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Subject implements Serializable {
    private int id;
    private String name;
    private String acronym;
    private String description;

    public Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "acronym")
    public String getAcronym() {
        return acronym;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
