package com.security.s3cur1ty.service;

import com.security.s3cur1ty.dto.request.AuthenticationRequest;
import com.security.s3cur1ty.dto.request.RegisterRequest;
import com.security.s3cur1ty.dto.response.AuthenticationResponse;
import com.security.s3cur1ty.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest user);
    List<AuthenticationResponse> getAllUsers();
    AuthenticationResponse authenticate(AuthenticationRequest user);
}
