package org.example.hw5;

import java.util.*;
import java.util.List;

public class AppStudents {
    public static List<Course> getCourses(final List<MyStudent> students) {
        return
        students.stream().map(MyStudent::getAllCourses).flatMap(Collection::stream).distinct()
                .toList();
    }

    public static List<MyStudent> get3BestStudent(final List<MyStudent> students) {
        return
                students.stream().sorted((s1, s2) -> (int) Math.signum(s2.getAllCourses().size() - s1.getAllCourses().size())).limit(3).toList();
    }

    public static List<MyStudent> getStudentCourse(final List<MyStudent> students, final Course mycourse) {
        return
                students.stream().filter(s -> s.getAllCourses().contains(mycourse)).toList();
    }

    /*public static void main(final String[] args) {
        List<MyStudent> students;

        MyStudent student1 = new MyStudent("Paul", new ArrayList<>(List.of(MyCourse.builder().course("maths").build(),
                MyCourse.builder().course("physics").build())));

        MyStudent student2 = new MyStudent("Maria", new ArrayList<>(List.of(MyCourse.builder().course("biology").build(),
                MyCourse.builder().course("physics").build(), MyCourse.builder().course("literature").build())));

        MyStudent student3 = new MyStudent("Inna", new ArrayList<>(List.of(MyCourse.builder().course("programming").build()
        )));

        students = new ArrayList<>(List.of(student1, student2, student3));
        List<Course> courses = getCourses(students);
        List<MyStudent> bestStudents = get3BestStudent(students);
        List<MyStudent> physicsStudents = getStudentCourse(students, MyCourse.builder().course("programming").build());

    }*/

}
