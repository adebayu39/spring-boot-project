package com.miniproject.api.repository;

import com.miniproject.api.entity.ERole;
import com.miniproject.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
