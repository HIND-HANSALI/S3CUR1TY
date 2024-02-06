package com.security.s3cur1ty.repository;

import com.security.s3cur1ty.entity.Authority;
import com.security.s3cur1ty.enums.AuthorityEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Query(value = "SELECT * FROM authority WHERE name IN :authorities", nativeQuery = true)
    List<Authority> findAllByName(@Param("authorities") List<AuthorityEnum> authorities);

    Optional<Authority> findByName(AuthorityEnum authorityEnum);
}
