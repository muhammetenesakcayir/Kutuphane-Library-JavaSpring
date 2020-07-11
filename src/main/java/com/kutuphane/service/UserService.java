package com.kutuphane.service;

import com.kutuphane.model.Users;
import com.kutuphane.model.type.Role;
import com.kutuphane.repository.RoleRepository;
import com.kutuphane.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Users getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public void SignupUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        role.setRole("USER");
        roleRepository.save(role);
        userRepository.save(user);
    }

    public void SignupAdmin(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        role.setRole("ADMIN");
        roleRepository.save(role);
        userRepository.save(user);
    }
}
