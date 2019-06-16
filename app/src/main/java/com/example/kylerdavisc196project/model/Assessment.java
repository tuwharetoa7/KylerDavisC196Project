package com.example.kylerdavisc196project.model;

import java.sql.Date;

public class Assessment {
    int id;
    String name;
    Date dueDate;
    Course course;

    public Assessment (String name, Date dueDate, Course course) {
        this.name = name;
        this.dueDate = dueDate;
        this.course = course;
    }

    public Assessment (int id, String name, Date dueDate, Course course) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.course = course;
    }

    //setters
    public void setId (int id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDueDate (Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setCourse () {
        this.course = course;
    }

    //getters
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Course getCourse() {
        return this.course;
    }
}