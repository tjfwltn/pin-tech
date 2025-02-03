package com.example.pintech.service;

import com.example.pintech.dto.JoinDTO;
import com.example.pintech.entity.UserEntity;
import com.example.pintech.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final UserRepository userRepository;

    public SignupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity signup(JoinDTO joinDTO) {

        String name = joinDTO.getName();
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();

        Boolean isExist = userRepository.existsByName(name);

        if (isExist) {
            return null;
        }

        UserEntity data = new UserEntity();
        data.setName(name);
        data.setUsername(username);
        data.setPassword(password);

        userRepository.save(data);
        return data;
    }

}
