package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Cake;
import com.sinyak.ordercake.entity.Categories;
import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;


    public void addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> findUserToName(String name){
        return userRepository.findByName(name);
    }

    @Transactional
    public Optional<User> findUserByID(int id){
        return userRepository.findById((long) id);
    }

    @Transactional
    public void updateUser(int id, User userUpdate) {
        User user = userRepository.findById((long) id).orElse(null);
        assert user != null;
        user.setRoles(userUpdate.getRoles());
        userRepository.save(user);
    }
}
