package com.example.Security.service;

import com.example.Security.model.Users;
import com.example.Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Users register(Users user){
        return repo.save(user);

    }
}
