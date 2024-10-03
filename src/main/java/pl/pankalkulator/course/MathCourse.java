package pl.pankalkulator.course;

import lombok.Getter;

import java.time.LocalDateTime;

public final class MathCourse implements Course {

    private final Tutor tutor;
    private final Double price;
    private final LocalDateTime dateTime;
    private final String title;
    @Getter
    private final String description;
    private final CourseType courseType;
    @Getter
    private Boolean isSigned = false;

    static class MathCourseBuilder {
        private final Tutor tutor;
        private final Double price;
        private final LocalDateTime dateTime;
        private String title;
        private String description;
        private final CourseType courseType;

        MathCourseBuilder(Tutor tutor, Double price, LocalDateTime dateTime) {
            this.tutor = tutor;
            this.price = price;
            this.dateTime = dateTime;
            courseType = CourseType.MATHEMATICS;
        }

        MathCourseBuilder title(String title) {
            this.title = title;
            return this;
        }

        MathCourseBuilder description(String description) {
            this.description = description;
            return this;
        }

        MathCourse build() {
            return new MathCourse(this);
        }
    }

    MathCourse(MathCourseBuilder courseBuilder) {
        tutor = courseBuilder.tutor;
        price = courseBuilder.price;
        dateTime = courseBuilder.dateTime;
        courseType = courseBuilder.courseType;
        title = courseBuilder.title;
        description = courseBuilder.description;
    }

    void signInToCourse() {
        this.isSigned = true;
    }

    @Override
    public Tutor tutor() {
        return tutor;
    }

    @Override
    public Double price() {
        return price;
    }

    @Override
    public String courseType() {
        return courseType.toString();
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public LocalDateTime dateTime() {
        return LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(),
                dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
    }

    static MathCourse copyOf(MathCourse mathCourse) {
        return new MathCourseBuilder(mathCourse.tutor, mathCourse.price, mathCourse.dateTime)
                .description(mathCourse.getDescription())
                .title(mathCourse.title())
                .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MathCourse mathCourse) {
            return mathCourse.tutor.equals(tutor) &&
                    mathCourse.dateTime.equals(dateTime);
        }
        return false;
    }

}
