package com.sinyak.ordercake.controller;

import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
public class SecurityController {

    private UserService service;

//    @PostMapping("/new-user")
//    public String addUser(@RequestBody User user){
//        service.addUser(user);
//        return "User is saved";
//    }
}
