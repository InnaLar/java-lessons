package org.example.hw5;

import java.util.List;

public class MyStudent implements Student {
    private String name;
    private List<Course> courses;

    public MyStudent(final String name, final List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCourses(final List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public String getName() {
        return name;
    }
}
