package org.example.hw5;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings("PMD.UseConcurrentHashMap")
public class AppStudents {

    public static Predicate<Course> distinctByKey(final Function<Course, Object> keyExtractor) {
        Map<Object, Boolean> seen = new HashMap<>();
        return cource -> seen.putIfAbsent(keyExtractor.apply(cource), Boolean.TRUE) == null;
    }

    public static List<Course> getCourses(final List<MyStudent> students) {
        return students.stream()
            .map(MyStudent::getAllCourses)
            .flatMap(Collection::stream)
            .filter(distinctByKey(Course::getCourse))
            .toList();
    }

    public static List<MyStudent> get3BestStudent(final List<MyStudent> students) {
        return students.stream()
            .sorted(Comparator.comparingInt((MyStudent s) -> s.getAllCourses().size())
                .reversed())
            .limit(3)
            .toList();
    }

    public static List<MyStudent> getStudentCourse(final List<MyStudent> students, final Course mycourse) {
        return students.stream()
            .filter(s -> s.getAllCourses().contains(mycourse))
            .toList();
    }
}
