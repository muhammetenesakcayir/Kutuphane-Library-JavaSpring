package com.kutuphane.service;

import com.kutuphane.model.Users;
import com.kutuphane.model.type.Role;
import com.kutuphane.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password){
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    public void SignupUser(Users user) {
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public void SignupAdmin(Users user) {
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
