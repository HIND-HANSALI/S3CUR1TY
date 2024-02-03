package com.security.s3cur1ty.service;

import com.security.s3cur1ty.entity.Authority;
import com.security.s3cur1ty.enums.AuthorityEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface AuthorityService {
    Optional<Authority> getByName(AuthorityEnum authorityEnum);
    List<Authority> getAllByName(List<AuthorityEnum> authorities);
    Optional<Authority> getById(Long id);
}
