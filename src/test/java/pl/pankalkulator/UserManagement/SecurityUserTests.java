package pl.pankalkulator.UserManagement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pankalkulator.UserManagment.SecurityUser;
import pl.pankalkulator.UserManagment.UserModel;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityUserTests {

    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";
    private static final String testUsername = "testUsername";

    @Test
    @DisplayName("Creates SecurityUser")
    void createsSecurityUser() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        var securityUser = new SecurityUser(userModel);

        assertAll(() -> {
            assertNotNull(securityUser);
            assertEquals(userModel.getEmail(), securityUser.getUsername());
            assertEquals(userModel.getPassword(), securityUser.getPassword());
            assertTrue(securityUser.getAuthorities().stream()
                    .anyMatch((e) -> e.getAuthority().equalsIgnoreCase(userModel.getUserType().toString())));
        });
    }

    @Test
    @DisplayName("Throws IllegalArgumentException - UserModel is null")
    void securityUserUserModelIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new SecurityUser(null));
    }
}
