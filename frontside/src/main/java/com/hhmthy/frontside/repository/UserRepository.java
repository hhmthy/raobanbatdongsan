package com.hhmthy.frontside.repository;

import com.hhmthy.frontside.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, String> {


    List<UserEntity> findByUsername(@Param("username") String username);

    List<UserEntity> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
