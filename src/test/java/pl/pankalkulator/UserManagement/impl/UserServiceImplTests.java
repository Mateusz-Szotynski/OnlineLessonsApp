package pl.pankalkulator.UserManagement.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pankalkulator.Exceptions.UserManagmentException;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.UserRepository;
import pl.pankalkulator.UserManagment.dto.UserMapper;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;
import pl.pankalkulator.UserManagment.impl.UserServiceImpl;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

    /*
    * Constants to make testing easier
    */

    private static final String testFirstName = "testFirstName";
    private static final String testLastName = "testLastName";
    private static final String testUsername = "testUsername";
    private static final String testEmail = "testEmail";
    private static final String testPassword = "testPassword";

    private static UserRegistrationDto testUserRegistrationDto;

    @BeforeEach
    void setUp() {
        testUserRegistrationDto = new UserRegistrationDto(testFirstName, testLastName, testUsername, testEmail, testPassword);
    }

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Properly register user")
    void registerUser() {


        when(userMapper.toUserModel(testUserRegistrationDto)).thenReturn(new UserModel(
                testFirstName, testLastName, testUsername, testEmail, testPassword
        ));
        var userModel = userMapper.toUserModel(testUserRegistrationDto);
        when(userRepository.findByEmail(testUserRegistrationDto.getEmail())).thenReturn(Optional.empty());
        when(bCryptPasswordEncoder.encode(testUserRegistrationDto.getPassword())).thenReturn(testPassword);
        when(userRepository.save(userModel)).thenReturn(userModel);

        //Act
        UserModel savedUser = userService.registerUser(testUserRegistrationDto);

        //Assert
        assertAll(() -> {
            assertNotNull(savedUser);
            assertEquals(testUserRegistrationDto.getFirstName(), savedUser.getFirstName());
            assertEquals(testUserRegistrationDto.getLastName(), savedUser.getLastName());
        });
    }

    @Test
    @DisplayName("Throws exception - user with provided email is already registered")
    void userWithEmailAlreadyExist() {

        when(userRepository.findByEmail(testUserRegistrationDto.getEmail())).thenReturn(Optional.of(new UserModel(
                testFirstName, testLastName, testUsername, testEmail, testPassword
        )));

        assertThrows(UserManagmentException.class, () -> userService.registerUser(testUserRegistrationDto));
    }

    @Test
    @DisplayName("Gets user by id")
    void returnsUserModelById() {
        String randomId = UUID.randomUUID().toString();
        var userFromDb = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);
        when(userRepository.findById(randomId)).thenReturn(Optional.of(userFromDb));

        var userFromService = userService.getUserById(randomId);

        assertAll(() -> {
            assertEquals(userFromDb.getId(), userFromService.getId());
            assertEquals(userFromDb.getFirstName(), userFromService.getFirstName());
            assertEquals(userFromDb.getLastName(), userFromService.getLastName());
            assertEquals(userFromDb.getEmail(), userFromService.getEmail());
            assertEquals(userFromDb.getPassword(), userFromService.getPassword());
            assertEquals(userFromDb.getUserType(), userFromService.getUserType());
            assertEquals(userFromDb.getBiography(), userFromService.getBiography());
            assertEquals(userFromDb.getPhoto(), userFromService.getPhoto());
        });
    }

    @Test
    @DisplayName("Throws UserManagmentException - user with provided ID couldnt been found")
    void couldntFindUserWithId() {
        String randomId = UUID.randomUUID().toString();

        when(userRepository.findById(randomId)).thenReturn(Optional.empty());

        assertThrows(UserManagmentException.class,() -> userService.getUserById(randomId));
    }

    @Test
    @DisplayName("Gets user by email")
    void returnsUserModelByEmail() {
        var userFromDb = new UserModel(testFirstName, testLastName, testUsername, testEmail, testPassword);
        when(userRepository.findByEmail(testEmail)).thenReturn(Optional.of(userFromDb));

        var userFromService = userService.getUserByEmail(testEmail);

        assertAll(() -> {
            assertEquals(userFromDb.getId(), userFromService.getId());
            assertEquals(userFromDb.getFirstName(), userFromService.getFirstName());
            assertEquals(userFromDb.getLastName(), userFromService.getLastName());
            assertEquals(userFromDb.getEmail(), userFromService.getEmail());
            assertEquals(userFromDb.getPassword(), userFromService.getPassword());
            assertEquals(userFromDb.getUserType(), userFromService.getUserType());
            assertEquals(userFromDb.getBiography(), userFromService.getBiography());
            assertEquals(userFromDb.getPhoto(), userFromService.getPhoto());
        });
    }

    @Test
    @DisplayName("Throws UserManagmentException - user with provided email couldnt been found")
    void couldntFindUserWithEmail() {

        when(userRepository.findByEmail(testEmail)).thenReturn(Optional.empty());

        assertThrows(UserManagmentException.class,() -> userService.getUserByEmail(testEmail));
    }
}
