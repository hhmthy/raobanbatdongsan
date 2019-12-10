package com.hhmthy.authentication.Service;

import com.hhmthy.authentication.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<UserEntity> findAll();

    //    List<UserEntity> search(String term);


    UserEntity findByEmail(String email);

    Optional<UserEntity> findOne(Long id);

    void save(UserEntity contact);

    void delete(Long id);
}
