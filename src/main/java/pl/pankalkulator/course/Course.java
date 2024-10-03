package pl.pankalkulator.course;

import java.time.LocalDateTime;

public interface Course {
    Tutor tutor();
    Double price();
    LocalDateTime dateTime();
    String courseType();
    String title();
}
