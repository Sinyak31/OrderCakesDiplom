package com.sinyak.ordercake.controller;

import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.service.CakeService;
import com.sinyak.ordercake.service.OrderService;
import com.sinyak.ordercake.service.ReviewService;
import com.sinyak.ordercake.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegAuthController {

    private OrderService orderService;
    private CakeService cakeService;
    private ReviewService revService;
    private UserService service;

@RequestMapping("/auth")
    public String authorizationUser(){
        return "authorization";
    }

    @RequestMapping("/reg")
    public String registrationUser(){
        return "registration";
    }

    @PostMapping("/new-user")
    public String addUser(@ModelAttribute("user") User user){
        service.addUser(user);
        return "redirect:/index";
    }
}

