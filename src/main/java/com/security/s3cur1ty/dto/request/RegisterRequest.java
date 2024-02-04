package com.security.s3cur1ty.dto.request;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;

    private String email;

    private String password;
}
