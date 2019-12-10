package com.hhmthy.frontside.repository;

import com.hhmthy.frontside.entity.ProvinceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends CrudRepository<ProvinceEntity, Integer> {
    List<ProvinceEntity> findByNameContaining(String name);
}
