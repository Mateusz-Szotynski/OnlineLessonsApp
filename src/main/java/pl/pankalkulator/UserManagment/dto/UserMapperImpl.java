package pl.pankalkulator.UserManagment.dto;

import org.springframework.stereotype.Component;
import pl.pankalkulator.UserManagment.UserModel;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toUserModel(UserRegistrationDto userRegistrationDto) {
        return new UserModel(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
               userRegistrationDto.getUsername() ,userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
    }

    @Override
    public UserLoginDto toUserLoginDto(UserModel userModel) {
        return new UserLoginDto(userModel.getUsername(), userModel.getEmail(), userModel.getPassword());
    }
}
