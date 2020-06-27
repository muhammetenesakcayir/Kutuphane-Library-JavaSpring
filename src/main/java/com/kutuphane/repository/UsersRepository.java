package com.kutuphane.repository;

import com.kutuphane.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
   boolean existsByUsernameAndPassword(String username, String password);
}
