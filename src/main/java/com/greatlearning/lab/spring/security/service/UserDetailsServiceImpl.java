package com.greatlearning.lab.spring.security.service;

import com.greatlearning.lab.spring.security.entities.User;
import com.greatlearning.lab.spring.security.repository.UserRepository;
import com.greatlearning.lab.spring.security.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        return new MyUserDetails(user);
    }
}
