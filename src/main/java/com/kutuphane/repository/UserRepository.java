package com.kutuphane.repository;

import com.kutuphane.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    public Users findByUsername(String username);
}
