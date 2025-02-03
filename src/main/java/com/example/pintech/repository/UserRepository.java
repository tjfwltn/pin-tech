package com.example.pintech.repository;

import com.example.pintech.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByName(String name);

    UserEntity findByName(String name);
}
