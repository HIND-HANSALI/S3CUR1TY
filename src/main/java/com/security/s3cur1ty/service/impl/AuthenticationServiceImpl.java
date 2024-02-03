package com.security.s3cur1ty.service.impl;

import com.security.s3cur1ty.configuration.JwtService;
import com.security.s3cur1ty.dto.request.AuthenticationRequest;
import com.security.s3cur1ty.dto.request.RegisterRequest;
import com.security.s3cur1ty.dto.response.AuthenticationResponse;
import com.security.s3cur1ty.entity.User;
import com.security.s3cur1ty.enums.Role;
import com.security.s3cur1ty.repository.UserRepository;
import com.security.s3cur1ty.service.AuthenticationService;
import com.security.s3cur1ty.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    @Override
    public List<AuthenticationResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<String> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        if (authorities.contains("VIEW_USERS"))
            return users.stream()
                    .map(this::mapUserToAuthenticationResponse)
                    .collect(Collectors.toList());
        else return null;


    }
    private AuthenticationResponse mapUserToAuthenticationResponse(User user) {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setUserName(user.getUsername());

        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleService.findDefaultRole().orElse(null))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken)
                .userName(user.getUsername())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
