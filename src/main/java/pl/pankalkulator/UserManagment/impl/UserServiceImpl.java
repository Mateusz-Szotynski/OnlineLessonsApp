package pl.pankalkulator.UserManagment.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pankalkulator.Exceptions.UserManagmentException;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.UserRepository;
import pl.pankalkulator.UserManagment.UserService;
import pl.pankalkulator.UserManagment.dto.UserLoginDto;
import pl.pankalkulator.UserManagment.dto.UserMapper;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;
import pl.pankalkulator.UserManagment.enums.UserType;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserModel registerUser(UserRegistrationDto userRegistrationDto) {
        UserModel user = userMapper.toUserModel(userRegistrationDto);

        var userFromDb = userRepository.findByEmail(userRegistrationDto.getEmail());

        // Sprawdź czy użytkownik o podanym adresie email już istnieje
        if (userFromDb.isPresent()) {
            throw new UserManagmentException("Użytkownik o podanym adresie email już istnieje");
        }

        // Ustaw hasło użytkownika (haszowane)
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));

        // Zapisz użytkownika w bazie danych
        return userRepository.save(user);

    }

    @Override
    public UserModel loginUser(UserLoginDto userLoginDto) {

        // Pobierz użytkownika o podanym adresie email
        UserModel userModel = userRepository.findByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new UserManagmentException("Nie znaleziono użytkownika o podanym adresie email"));

        // Sprawdź czy hasło jest poprawne
        if (!bCryptPasswordEncoder.matches(userLoginDto.getPassword(), userModel.getPassword())) {
            throw new UserManagmentException("Niepoprawne hasło");
        }

        return userModel;

    }

    @Override
    public UserModel getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserManagmentException("Nie znaleziono użytkownika o podanym id " + id));
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserManagmentException("Nie znaleziono użytkownika o podanym adresie email " + email));
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void changeUserType(String id, UserType userType) {
        UserModel userModel = getUserById(id);
        userModel.setUserType(userType);
        userRepository.save(userModel);
    }

    @Override
    public void changeUserPassword(String id, String password) {
        UserModel userModel = getUserById(id);
        userModel.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(userModel);
    }

    @Override
    public void changeUserPhoto(String id, String photo) {
        UserModel userModel = getUserById(id);
        userModel.setPhoto(photo);
        userRepository.save(userModel);
    }

    @Override
    public void changeUserBiography(String id, String biography) {
        UserModel userModel = getUserById(id);
        userModel.setBiography(biography);
        userRepository.save(userModel);
    }

    @Override
    public void changeUserEmail(String id, String email) {
        UserModel userModel = getUserById(id);
        userModel.setEmail(email);
        userRepository.save(userModel);
    }

    @Override
    public void changeUserFirstName(String id, String firstName) {
        UserModel userModel = getUserById(id);
        userModel.setFirstName(firstName);
        userRepository.save(userModel);
    }

    @Override
    public void changeUserLastName(String id, String lastName) {
        UserModel userModel = getUserById(id);
        userModel.setLastName(lastName);
        userRepository.save(userModel);
    }

    @Override
    public void resetPassword(String email) {
        UserModel userModel = getUserByEmail(email);
        userModel.setPassword(bCryptPasswordEncoder.encode(UUID.randomUUID().toString().substring(0, 10)));
        userRepository.save(userModel);
    }

}