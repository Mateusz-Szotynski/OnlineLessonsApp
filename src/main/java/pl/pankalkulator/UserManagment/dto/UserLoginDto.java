package pl.pankalkulator.UserManagment.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class UserLoginDto {

    private String username;

    @Email
    private String email;

    private String password;

    public UserLoginDto(String username, String email, String password) {
        if (username == null || username.isBlank() || username.isEmpty()) {
            Assert.notNull(email, "Email cannot be null");
            Assert.isTrue(!email.isEmpty() && !email.isBlank(), "Email cannot be either empty or blank");
            this.email = email;
        } else {
            Assert.notNull(username, "Username cannot be null");
            Assert.isTrue(!username.isEmpty() && !username.isBlank(), "Username cannot be either empty or blank");
            this.username = username;
        }
        Assert.notNull(password, "Password cannot be null");
        Assert.isTrue(!password.isEmpty() && !password.isBlank(), "Password cannot be empty either blank");
        this.password = password;
    }

}
