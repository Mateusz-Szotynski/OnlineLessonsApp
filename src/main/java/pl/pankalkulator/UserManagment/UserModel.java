package pl.pankalkulator.UserManagment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;
import pl.pankalkulator.UserManagment.enums.UserType;

@Getter
@Document("users")
public class UserModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @Indexed
    private UserType userType; // STUDENT, USER, ADMIN
    @Setter
    private String photo;
    @Setter
    private String biography;
    // private List<Review> reviews;

    public UserModel(String firstName, String lastName, String username, String email, String password, UserType userType, String photo,
                     String biography) {
        Assert.notNull(firstName, "First name cannot be null");
        Assert.isTrue(!firstName.isEmpty() && !firstName.isBlank(), "First name cannot be either empty or blank");
        Assert.notNull(lastName, "Last name cannot be null");
        Assert.isTrue(!lastName.isEmpty() && !lastName.isBlank(), "Last name cannot be either empty or blank");
        Assert.notNull(email, "Email cannot be null");
        Assert.notNull(lastName, "Username cannot be null");
        Assert.isTrue(!username.isEmpty() && !username.isBlank(), "Username cannot be either empty or blank");
        Assert.notNull(email, "Email cannot be null");
        Assert.isTrue(!email.isEmpty() && !email.isBlank(), "Email cannot be empty either blank");
        Assert.notNull(password, "Password cannot be null");
        Assert.isTrue(!password.isEmpty() && !password.isBlank(), "Password name cannot be either empty or blank");
        Assert.notNull(userType, "User type cannot be null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.photo = photo;
        this.biography = biography;
    }

    private UserModel(){};

    public UserModel(String firstName, String lastName, String username, String email, String password, UserType userType) {
        this(firstName, lastName, username, email, password, userType, null, null);
    }

    public UserModel(String firstName, String lastName, String username, String email, String password) {
        this(firstName, lastName, username, email, password, UserType.STUDENT, null, null);
    }

    public void setFirstName(String firstName) {
        Assert.notNull(firstName, "First name cannot be null");
        Assert.isTrue(!firstName.isEmpty() && !firstName.isBlank(), "First name cannot be either empty or blank");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        Assert.notNull(lastName, "Last name cannot be null");
        Assert.isTrue(!lastName.isEmpty() && !lastName.isBlank(), "Last name cannot be either empty or blank");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        Assert.notNull(email, "Email cannot be null");
        Assert.isTrue(!email.isEmpty() && !email.isBlank(), "Email cannot be either empty or blank");
        this.email = email;
    }

    public void setPassword(String password) {
        Assert.notNull(password, "Password cannot be null");
        Assert.isTrue(!password.isEmpty() && !password.isBlank(), "Password name cannot be either empty or blank");
        this.password = password;
    }

    public void setUserType(UserType userType) {
        Assert.notNull(userType, "User type cannot be null");
        this.userType = userType;
    }

    public void setUsername(String username) {
        Assert.notNull(username, "Username cannot be null");
        Assert.isTrue(!username.isEmpty() && !username.isBlank(), "Username cannot be either empty or blank");
    }

}
