package com.kutuphane.service;

import com.kutuphane.model.Users;
import com.kutuphane.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void save(Users users) {usersRepository.save(users);}

    public boolean login(String username, String password){
        return usersRepository.existsByUsernameAndPassword(username, password);
    }

}
