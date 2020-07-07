package com.kutuphane.repository;

import com.kutuphane.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findByRole(String role);
}
