package org.example.hw5;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class MyStudent implements Student {

    private String name;
    private List<Course> allCourses;

}
