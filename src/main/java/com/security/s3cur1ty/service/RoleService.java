package com.security.s3cur1ty.service;

import com.security.s3cur1ty.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface RoleService {
    Role save(Role role, boolean isSeed);

    Optional<Role> findDefaultRole();

    Optional<Role> getById(Long id);

    void delete(Long id);

    Optional<Role> getByName(String name);
    List<Role> getAll();




    //    Role update(Role role, Long id);
//    Role grantAuthorities(Long authorityId, Long roleId);
//
//    Role revokeAuthorities(Long authorityId, Long roleId);
}
