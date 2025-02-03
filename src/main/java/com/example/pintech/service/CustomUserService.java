package com.example.pintech.service;

import com.example.pintech.dto.CustomUserDetails;
import com.example.pintech.entity.UserEntity;
import com.example.pintech.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userdata = userRepository.findByName(username);
        if (userdata != null) {
            return new CustomUserDetails(userdata);
        }

        return null;
    }
}
