package pl.pankalkulator.course;

import java.util.ArrayList;
import java.util.List;

public final class Student extends Account{
    private final List<Course> assignedCourses;

    Student(String firstName, String lastName, Integer age) {
        super(firstName, lastName, age);
        assignedCourses = new ArrayList<>();
    }

    void attendToCourse(Course course) {
        assignedCourses.add(course);
    }

    static Student copyOf(Student student) {
        return new Student(student.getFirstName(), student.getLastName(), student.getAge());
    }

}
