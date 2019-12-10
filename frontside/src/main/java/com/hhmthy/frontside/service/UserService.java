package com.hhmthy.frontside.service;

import com.hhmthy.frontside.entity.UserEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    void addUser(UserEntity userEntity);

    List<UserEntity> findByUsername(@Param("username") String username);

    List<UserEntity> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
