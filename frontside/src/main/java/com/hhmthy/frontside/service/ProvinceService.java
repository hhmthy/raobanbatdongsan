package com.hhmthy.frontside.service;

import com.hhmthy.frontside.entity.ProvinceEntity;

import java.util.List;
import java.util.Optional;

public interface ProvinceService {
    Iterable<ProvinceEntity> findAll();

    List<ProvinceEntity> search(String term);

    Optional<ProvinceEntity> findOne(Integer id);

    void save(ProvinceEntity provinceEntity);

    void delete(Integer id);
}
