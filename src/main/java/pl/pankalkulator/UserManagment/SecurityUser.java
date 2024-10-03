package pl.pankalkulator.UserManagment;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

    private final UserModel user;

    public SecurityUser(UserModel user) {
        Assert.notNull(user, "User cannot be null");
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> user.getUserType().getAuthority());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        if(user.getEmail() == null || user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            return user.getUsername();
        }
        return user.getEmail();
    }
}
