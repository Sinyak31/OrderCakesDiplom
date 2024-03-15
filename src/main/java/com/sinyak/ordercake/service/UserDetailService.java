package com.sinyak.ordercake.service;


import com.sinyak.ordercake.configSecurity.MyUserDetails;
import com.sinyak.ordercake.model.User;
import com.sinyak.ordercake.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>user = userRepository.findByName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(username+" not found"));
    }

}
