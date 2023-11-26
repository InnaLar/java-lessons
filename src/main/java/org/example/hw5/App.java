package org.example.hw5;

import java.util.List;

@SuppressWarnings({"PMD.SystemPrintln", "PMD.UseConcurrentHashMap"})
public class App {

    public static void main(final String[] args) {
        MyStudent myStudent1 = MyStudent.builder()
            .name("1")
            .allCourses(List.of(
                MyCourse.builder()
                    .course("Физика")
                    .build(),
                MyCourse.builder()
                    .course("Математика")
                    .build()))
            .build();
        MyStudent myStudent2 = MyStudent.builder()
            .name("2")
            .allCourses(List.of(
                MyCourse.builder()
                    .course("Геометрия")
                    .build(),
                MyCourse.builder()
                    .course("Математика")
                    .build()))
            .build();

        List<Course> uniqueCourses = AppStudents.getCourses(List.of(myStudent1, myStudent2));
        System.out.println(uniqueCourses);
    }
}
