package pl.pankalkulator.UserManagment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pankalkulator.UserManagment.dto.UserLoginDto;
import pl.pankalkulator.UserManagment.dto.UserRegistrationDto;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        return new ResponseEntity<>(userService.registerUser(userRegistrationDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity<>(userService.loginUser(userLoginDto), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello!");
    }
}
