package com.security.s3cur1ty.dto.response;
import com.security.s3cur1ty.entity.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String userName;
    private String token;
    private String email;
    private Role role;
}
