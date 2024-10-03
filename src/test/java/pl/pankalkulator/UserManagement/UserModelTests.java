package pl.pankalkulator.UserManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.enums.UserType;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTests {

    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testUsername = "testUsername";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";
    private static final String testPhoto = "agh/sajkfhjkdshf/fhdskjfhajsd/hfjsf";
    private static final String testBiography = "testBiography";

    private static UserModel testUserModel;

    @BeforeEach
    void setUp() {
        testUserModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);
    }

    /*
    * Happy constructor tests
    */

    @ParameterizedTest
    @DisplayName("Creates UserModel object with all possible arguments")
    @EnumSource(UserType.class)
    void createsUserModelWithAllParams(UserType type) {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword, type, testPhoto, testBiography);
        assertAll(() -> {
            assertNotNull(userModel);
            assertEquals(testFirstName, userModel.getFirstName());
            assertEquals(testLastName, userModel.getLastName());
            assertEquals(testEmail, userModel.getEmail());
            assertEquals(testPassword, userModel.getPassword());
            assertEquals(type, userModel.getUserType());
            assertEquals(testBiography, userModel.getBiography());
            assertEquals(testPhoto, userModel.getPhoto());
        });
    }

    @ParameterizedTest
    @DisplayName("Creates UserModel object without photo and biography")
    @EnumSource(UserType.class)
    void createsUserModelWithoutPhotoAndBiography(UserType type) {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword, type);

        assertAll(() -> {
            assertNotNull(userModel);
            assertEquals(testFirstName, userModel.getFirstName());
            assertEquals(testLastName, userModel.getLastName());
            assertEquals(testEmail, userModel.getEmail());
            assertEquals(testPassword, userModel.getPassword());
            assertEquals(type, userModel.getUserType());
            assertNull(userModel.getBiography());
            assertNull(userModel.getPhoto());
        });
    }

    @Test
    @DisplayName("Creates UserModel object with default type of student")
    void createsUserModelWithDefaultType() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        assertAll(() -> {
            assertNotNull(userModel);
            assertEquals(testFirstName, userModel.getFirstName());
            assertEquals(testLastName, userModel.getLastName());
            assertEquals(testEmail, userModel.getEmail());
            assertEquals(testPassword, userModel.getPassword());
            assertEquals(UserType.STUDENT, userModel.getUserType());
            assertNull(userModel.getBiography());
            assertNull(userModel.getPhoto());
        });
    }

    /*
    * Checking exceptions thrown in constructors
    */

    //FirstName exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is null")
    void firstNameNullUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                null, testLastName, testUsername, testEmail, testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is empty")
    void firstNameEmptyUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                "", testLastName, testUsername, testEmail, testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - firstName is blank")
    void firstNameBlankUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                "    ", testLastName, testUsername, testEmail, testPassword)
        );
    }

    //LastName exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is null")
    void lastNameNullUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, null, testUsername, testEmail, testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is empty")
    void lastNameEmptyUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, "", testUsername, testEmail, testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - lastName is blank")
    void lastNameBlankUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, " ", testUsername, testEmail, testPassword)
        );
    }

    //Email exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is null")
    void emailNullUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, null, testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is empty")
    void emailEmptyUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, "", testPassword)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - email is blank")
    void emailBlankUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, " ", testPassword)
        );
    }

    //Password exceptions
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is null")
    void passwordNullUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, testEmail, null)
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is empty")
    void passwordEmptyUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, testEmail, "")
        );
    }

    @Test
    @DisplayName("Constructor throws IllegalArgumentException - password is blank")
    void passwordBlankUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, testEmail, " ")
        );
    }

    //UserType exception
    @Test
    @DisplayName("Constructor throws IllegalArgumentException - user type is null")
    void userTypeNullUserModelConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new UserModel(
                testFirstName, testLastName, testUsername, testEmail, null)
        );
    }

    /*
    * Happy setters tests
    */

    @Test
    @DisplayName("Sets first name")
    void setsFirstName() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        final String differentFirstName = "differentFirstName";
        testUserModel.setFirstName(differentFirstName);

        assertAll(() -> {
            assertNotNull(testUserModel);
            assertEquals(differentFirstName, testUserModel.getFirstName());
        });
    }

    @Test
    @DisplayName("Sets last name")
    void setsLastName() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        final String differentLastName = "differentLastName";
        userModel.setLastName(differentLastName);

        assertAll(() -> {
            assertNotNull(userModel);
            assertEquals(differentLastName, userModel.getLastName());
        });
    }

    @Test
    @DisplayName("Sets email")
    void setsEmail() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        final String differentEmail = "differentEmail";
        userModel.setEmail(differentEmail);

        assertAll(() -> {
            assertNotNull(userModel);
            assertEquals(differentEmail, userModel.getEmail());
        });
    }

    @Test
    @DisplayName("Sets password")
    void setsPassword() {

        final String differentPassword = "differentPassword";
        testUserModel.setPassword(differentPassword);

        assertAll(() -> {
            assertNotNull(testUserModel);
            assertEquals(differentPassword, testUserModel.getPassword());
        });
    }

    @Test
    @DisplayName("Sets user type")
    void setsUserType() {

        final UserType differentUserType = UserType.ADMIN;
        testUserModel.setUserType(differentUserType);

        assertAll(() -> {
            assertNotNull(testUserModel);
            assertEquals(differentUserType, testUserModel.getUserType());
        });
    }

    /*
     * Checking exceptions thrown in setters
     */

    //FirstName exception exceptions
    @Test
    @DisplayName("Setter throws IllegalArgumentException - first name is null")
    void firstNameNullUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setFirstName(null));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - first name is empty")
    void firstNameEmptyUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setFirstName(""));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - first name is blank")
    void firstNameBlankUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setFirstName(" "));
    }

    //LastName exceptions
    @Test
    @DisplayName("Setter throws IllegalArgumentException - last name is null")
    void lastNameNullUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setLastName(null));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - last name is empty")
    void lastNameEmptyUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setLastName(""));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - last name is blank")
    void lastNameBlankUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setLastName(" "));
    }

    //Email exceptions
    @Test
    @DisplayName("Setter throws IllegalArgumentException - email is null")
    void emailNullUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setEmail(null));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - email is empty")
    void emailEmptyUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setEmail(""));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - email is blank")
    void emailBlankUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setEmail(" "));
    }

    //Password exceptions
    @Test
    @DisplayName("Setter throws IllegalArgumentException - password is null")
    void passwordNullUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setPassword(null));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - password is empty")
    void passwordEmptyUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setPassword(""));
    }

    @Test
    @DisplayName("Setter throws IllegalArgumentException - password is blank")
    void passwordBlankUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setPassword(" "));
    }

    //UserType exception
    @Test
    @DisplayName("Setter throws IllegalArgumentException - user type is null")
    void userTypeNullUserModelSetter() {
        assertThrows(IllegalArgumentException.class, () -> testUserModel.setUserType(null));
    }


}
