package com.example.blogging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */

@RestController
public class HelloController {

    @Autowired JwtDecoder decoder;

    @Autowired AuthenticationManager authManager;

    @GetMapping("/hello")
    public String hello() {
        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User) {
                username = ((User)principal).getUsername();
            } else {
                username = ((Jwt) principal).getSubject();
            }
        }

        // use the username for further processing
        return "Hello, " + username;
    }
}
