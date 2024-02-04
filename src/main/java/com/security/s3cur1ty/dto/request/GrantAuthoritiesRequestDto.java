package com.security.s3cur1ty.dto.request;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrantAuthoritiesRequestDto {
    Long authorityId;
    Long roleId;
}
