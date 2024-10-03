package pl.pankalkulator.course;

import lombok.Getter;

@Getter
abstract class Account {
    private final String firstName;
    private final String lastName;
    private final Integer age;

    Account(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
