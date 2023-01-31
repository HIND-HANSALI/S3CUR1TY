package com.security.s3cur1ty.service;

import com.security.s3cur1ty.dto.request.AuthenticationRequest;
import com.security.s3cur1ty.dto.request.RegisterRequest;
import com.security.s3cur1ty.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest user);

    AuthenticationResponse authenticate(AuthenticationRequest user);
}
