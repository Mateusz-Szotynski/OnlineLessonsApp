package pl.pankalkulator.UserManagement.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pankalkulator.UserManagment.dto.UserLoginDto;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginDtoTests {

    /*
    * Constants to make testing easier
    */

    private static final String testUsername = "testUsername";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";

    @Test
    @DisplayName("Creates UserLoginDto object")
    void createsUserLoginDto() {
        var userLoginDto = new UserLoginDto(null, testEmail, testPassword);

        assertAll(() -> {
            assertNotNull(userLoginDto);
            assertEquals(testEmail, userLoginDto.getEmail());
            assertEquals(testPassword, userLoginDto.getPassword());
        });
    }

    /*
    * Checking Exceptions thrown
    */

    //Email exceptions
    @Test
    @DisplayName("Throws IllegalArgumentException - email is null")
    void nullEmailUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, null, testPassword));
    }

    @Test
    @DisplayName("Throws IllegalArgumentException - email is empty")
    void emptyEmailUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, "", testPassword));
    }

    @Test
    @DisplayName("Throws IllegalArgumentException - email is blank")
    void blankEmailUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, " ", testPassword));
    }

    //Password Exceptions
    @Test
    @DisplayName("Throws IllegalArgumentException - password is null")
    void nullPasswordUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, testEmail, null));
    }

    @Test
    @DisplayName("Throws IllegalArgumentException - password is empty")
    void emptyPasswordUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, testEmail, ""));
    }

    @Test
    @DisplayName("Throws IllegalArgumentException - password is blank")
    void blankPasswordUserLoginDto() {
        assertThrows(IllegalArgumentException.class, () ->
                new UserLoginDto(null, testEmail, " "));
    }

}
