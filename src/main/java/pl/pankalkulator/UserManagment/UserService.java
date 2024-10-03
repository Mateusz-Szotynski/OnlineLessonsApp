package pl.pankalkulator.UserManagment;

import org.springframework.stereotype.Service;
import pl.pankalkulator.UserManagment.dto.UserLoginDto;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;
import pl.pankalkulator.UserManagment.enums.UserType;

@Service
public interface UserService {

    UserModel registerUser(UserRegistrationDto userRegistrationDto);

    UserModel loginUser(UserLoginDto userLoginDto);

    UserModel getUserById(String id);

    UserModel getUserByEmail(String email);

    UserModel updateUser(UserModel userModel);

    void deleteUser(String id);

    void changeUserType(String id, UserType userType);

    void changeUserPassword(String id, String password);

    void changeUserPhoto(String id, String photo);

    void changeUserBiography(String id, String biography);

    void changeUserEmail(String id, String email);

    void changeUserFirstName(String id, String firstName);

    void changeUserLastName(String id, String lastName);

    void resetPassword(String email);

}
