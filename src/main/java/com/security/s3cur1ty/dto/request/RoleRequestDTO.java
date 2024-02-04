package com.security.s3cur1ty.dto.request;

import com.security.s3cur1ty.entity.Authority;
import com.security.s3cur1ty.entity.Role;

import java.util.List;

public record RoleRequestDTO(
    String name,
    List<Authority> authorities,
    boolean isDefault
){
        public Role toRole(){
            return Role.builder()
                    .name(name)
                    .isDefault(isDefault)
                    .authorities(authorities)
                    .build();
        }
    }