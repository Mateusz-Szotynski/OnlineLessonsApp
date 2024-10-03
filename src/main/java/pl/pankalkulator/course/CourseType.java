package pl.pankalkulator.course;

public enum CourseType {
    MATHEMATICS, BIOLOGY, PHYSICS;


    @Override
    public String toString() {
        return this.name();
    }
}
