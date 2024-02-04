package com.security.s3cur1ty.dto.response;

import com.security.s3cur1ty.entity.Authority;
import com.security.s3cur1ty.entity.Role;
import com.security.s3cur1ty.enums.AuthorityEnum;


import java.util.List;

public record RoleResponseDTO(
        String name,
        List<AuthorityEnum> authorities,
        boolean isDefault
) {
    public static RoleResponseDTO fromRole(Role role){
        return new RoleResponseDTO(
                role.getName(),
                role.getAuthorities().stream().map(Authority::getName).toList(),
                role.isDefault()
        );
    }
}
