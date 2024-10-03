package pl.pankalkulator.UserManagment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    private String username;

    @Email
    private String email;

    @Size(min = 8, max = 20)
    private String password;

    public UserRegistrationDto(String firstName, String lastName, String username, String email, String password) {
        Assert.notNull(firstName, "First name cannot be null");
        Assert.isTrue(!firstName.isEmpty() && !firstName.isBlank(), "First name cannot be either empty or blank");
        Assert.notNull(lastName, "Last name cannot be null");
        Assert.isTrue(!lastName.isEmpty() && !lastName.isBlank(), "Last name cannot be either empty or blank");
        Assert.notNull(username, "Username cannot be null");
        Assert.isTrue(!username.isEmpty() && !username.isBlank(), "Username cannot be either empty or blank");
        Assert.notNull(email, "Email name cannot be null");
        Assert.isTrue(!email.isEmpty() && !email.isBlank(), "Email cannot be either empty or blank");
        Assert.notNull(password, "Password cannot be null");
        Assert.isTrue(!password.isEmpty() && !password.isBlank(), "Password cannot be either empty or blank");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
