package pl.pankalkulator.course;

import lombok.extern.log4j.Log4j2;

@Log4j2
public final class MathSignedInCourse implements SignedInCourse {
    private final MathCourse mathCourse;
    private final Student student;

    private MathSignedInCourse(MathCourse mathCourse, Student student) {
        this.mathCourse = mathCourse;
        this.student = student;
    }

    static MathSignedInCourse signIn(MathCourse mathCourse, Student student) {
        try {
            if (mathCourse.getIsSigned()) {
                throw new IllegalAccessException("The course is already taken");
            }
        } catch (IllegalAccessException ex) {
            log.error(String.valueOf(ex.getCause()));
        }

        mathCourse.signInToCourse();
        return new MathSignedInCourse(mathCourse, student);
    }

    Student getAssignee() {
        return Student.copyOf(student);
    }

    MathCourse getCourse() {
        return MathCourse.copyOf(mathCourse);
    }

    @Override
    public SignedInCourse attendToCourse(Course course) {
        return MathSignedInCourse.signIn(mathCourse, student);
    }
}
