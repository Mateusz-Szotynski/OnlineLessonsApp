package pl.pankalkulator.UserManagement.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationDtoTests {

    /*
    * Constants to make testing easier
    */
    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testUsername = "testUsername";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";

    @Test
    @DisplayName("Creates UserRegistrationDto object")
    void createUserRegistrationDto() {
        var userRegistrationDto = new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, testPassword);

        assertAll(() -> {
            assertNotNull(userRegistrationDto);
            assertEquals(testFirstName, userRegistrationDto.getFirstName());
            assertEquals(testLastName, userRegistrationDto.getLastName());
            assertEquals(testUsername, userRegistrationDto.getUsername());
            assertEquals(testEmail, userRegistrationDto.getEmail());
            assertEquals(testPassword, userRegistrationDto.getPassword());
        });
    }

    //First name exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is null")
    void nullFirstNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(null, testLastName, testUsername, testEmail, testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is empty")
    void emptyFirstNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto("", testLastName, testUsername, testEmail, testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is blank")
    void blankFirstNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(" ", testLastName, testUsername, testEmail, testPassword));
    }

    //Last name exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is null")
    void nullLastNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, null, testUsername, testEmail, testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is empty")
    void emptyLastNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, "", testUsername, testEmail, testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is blank")
    void blankLastNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, " ", testUsername, testEmail, testPassword));
    }

    //Email exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is null")
    void nullEmailUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, null, testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is empty")
    void emptyEmailNameUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, "", testPassword));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is blank")
    void blankEmailUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, " ", testPassword));
    }

    //Password exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is null")
    void nullPasswordUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, null));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is empty")
    void emptyPasswordUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, ""));
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is blank")
    void blankPasswordUserRegistrationDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, " "));
    }
}
