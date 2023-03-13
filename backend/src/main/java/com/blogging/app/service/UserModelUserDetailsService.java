package com.blogging.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blogging.app.config.UserModelUserDetails;
import com.blogging.app.models.UserModel;
import com.blogging.app.repository.UserModelRepository;

@Component
public class UserModelUserDetailsService implements UserDetailsService {

    @Autowired
    private UserModelRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserModel> user = repository.findByName(userEmail);
        return user.map(UserModelUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User Not Found " + userEmail)); }
    
}

