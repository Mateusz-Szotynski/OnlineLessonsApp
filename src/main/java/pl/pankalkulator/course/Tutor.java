package pl.pankalkulator.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Tutor extends Account {
    private String description;
    private final List<Course> courseList;

    public Tutor(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
        this.courseList = new ArrayList<>();
    }

    List<Course> getCourseList() {
        return Collections.unmodifiableList(courseList);
    }

    void addCourseToTheList(Course course) {
        courseList.add(course);
    }

    void removeCourseFromTheList(Course course) {
        courseList.remove(course);
    }
}
