package com.hhmthy.authentication.Service;

import com.hhmthy.authentication.Entity.UserEntity;
import com.hhmthy.authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public Optional<UserEntity> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(UserEntity contact) {
        userRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
