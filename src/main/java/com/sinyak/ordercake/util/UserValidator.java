package com.sinyak.ordercake.util;

import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class UserValidator implements Validator {

    private final UserService userService;
    @Autowired
    public UserValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
User user = (User) target;
if(userService.findUserToName(user.getName()).isPresent()){
    errors.rejectValue("name","","Пользователь с таким логином уже есть");
}
    }
}
