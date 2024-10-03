package pl.pankalkulator.UserManagement;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import pl.pankalkulator.TestcontainersConfiguration;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.UserRepository;
import pl.pankalkulator.UserManagment.enums.UserType;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@DataMongoTest
public class UserRepositoryITTests {

    /*
    * Constants to make testing easier
    */
    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";
    private static final UserType testUserType = UserType.ADMIN;
    private static final String testPhoto = "agh/sajkfhjkdshf/fhdskjfhajsd/hfjsf";
    private static final String testBiography = "testBiography";
    private static final String testUsername = "testUsername";

    @Autowired
    private UserRepository userRepository;

    /*
    * Tests repository layer
    */
    @Test
    @DisplayName("Finds UserModel by email")
    void userModelFoundByEmail() {
        UserModel userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);
        userRepository.save(userModel);

        Optional<UserModel> userFromDb = userRepository.findByEmail(testEmail);

        assertAll(() -> {
            assertTrue(userFromDb.isPresent());
            assertNotNull(userFromDb.get().getId());
        });
    }
}
