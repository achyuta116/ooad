package com.blogging.app.controllers;

import com.blogging.app.dto.AuthRequest;
import com.blogging.app.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @Autowired private JwtService jwtService;

    @Autowired private AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String notHello() {
        return "Not Hello World";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.userEmail,
                                                    authRequest.password));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(authRequest.userEmail);
        else
            throw new UsernameNotFoundException("Invalid User request");
    }
}
