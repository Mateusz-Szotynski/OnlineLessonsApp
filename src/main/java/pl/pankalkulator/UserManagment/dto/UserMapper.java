package pl.pankalkulator.UserManagment.dto;

import pl.pankalkulator.UserManagment.UserModel;

public interface UserMapper {

    UserModel toUserModel(UserRegistrationDto userRegistrationDto);
    UserLoginDto toUserLoginDto(UserModel userModel);

}
