package com.sinyak.ordercake.controller;

import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.service.UserService;
import com.sinyak.ordercake.util.UserValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@AllArgsConstructor
public class RegAuthController {

    private UserService userService;
    private UserValidator userValidator;

@RequestMapping("/auth")
    public String authorizationUser(){
        return "authorization";
    }

    @RequestMapping("/reg")
    public String registrationUser(@ModelAttribute("user") User user){
    return "registration";
    }

    @PostMapping("/new-user")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result){
    userValidator.validate(user,result);
    if(result.hasErrors()){
        return "registration";
    }
        userService.addUser(user);
        return "redirect:/index";
    }
}

