package com.blogging.app.config;

import com.blogging.app.models.UserModel;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserModelUserDetails
 */
public class UserModelUserDetails implements UserDetails {

    private String userEmail;
    private String userPassword;
    private List<GrantedAuthority> authorities;

    public UserModelUserDetails(UserModel userModel) {
        userEmail = userModel.getName();
        userPassword = userModel.getUserPassword();
        authorities = Arrays.stream(userModel.getRoles().split(","))
                          .map(SimpleGrantedAuthority::new)
                          .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
