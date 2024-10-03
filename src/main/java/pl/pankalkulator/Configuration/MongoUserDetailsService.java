package pl.pankalkulator.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.pankalkulator.UserManagment.SecurityUser;
import pl.pankalkulator.UserManagment.UserModel;
import pl.pankalkulator.UserManagment.UserService;

public class MongoUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MongoUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userFromDb = userService.getUserByEmail(username);
        return new SecurityUser(userFromDb);
    }
}
