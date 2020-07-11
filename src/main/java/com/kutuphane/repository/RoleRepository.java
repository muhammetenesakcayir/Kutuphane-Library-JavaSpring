package com.kutuphane.repository;

import com.kutuphane.model.type.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}