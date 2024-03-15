package com.sinyak.ordercake.service;

import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;


    public void addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
