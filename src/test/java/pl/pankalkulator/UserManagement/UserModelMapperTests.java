package pl.pankalkulator.UserManagement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.dto.UserLoginDto;
import pl.pankalkulator.UserManagment.dto.UserMapper;
import pl.pankalkulator.UserManagment.dto.UserMapperImpl;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;
import pl.pankalkulator.UserManagment.enums.UserType;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelMapperTests {

    /*
     * Constants to make testing easier
     */
    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";
    private static final String testUsername = "testUsername";

    UserMapper userMapper = new UserMapperImpl();

    /*
    * Happy mapping tests
    */

    @Test
    @DisplayName("Maps UserModel to UserLoginDto")
    void mapUserModelToUserLoginDto() {
        var userModel = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);

        UserLoginDto mappedUserLoginDto = userMapper.toUserLoginDto(userModel);

        assertAll(() -> {
            assertEquals(userModel.getEmail(), mappedUserLoginDto.getEmail());
            assertEquals(userModel.getPassword(), mappedUserLoginDto.getPassword());
        });
    }

    @Test
    @DisplayName("Maps UserRegistrationDto to UserModel")
    void mapUserRegistrationDtoToUserModel() {
        var userRegister = new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, testPassword);

        UserModel mappedUserModel = userMapper.toUserModel(userRegister);

        assertAll(() -> {
            assertNotNull(mappedUserModel);
            assertEquals(testFirstName, mappedUserModel.getFirstName());
            assertEquals(testLastName, mappedUserModel.getLastName());
            assertEquals(testEmail, mappedUserModel.getEmail());
            assertEquals(testPassword, mappedUserModel.getPassword());
            assertEquals(UserType.STUDENT, mappedUserModel.getUserType());
            assertNull(mappedUserModel.getPhoto());
            assertNull(mappedUserModel.getBiography());
        });
    }
}
