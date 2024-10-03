package pl.pankalkulator.UserManagment.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserType implements GrantedAuthority {
    STUDENT,
    TUTOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
