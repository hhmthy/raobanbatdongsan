package com.hhmthy.frontside.service;

import com.hhmthy.frontside.entity.DistrictEntity;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    Iterable<DistrictEntity> findAll();

    List<DistrictEntity> search(String term);

    Optional<DistrictEntity> findOne(Integer id);

    void save(DistrictEntity districtEntity);

    void delete(Integer id);

    List<DistrictEntity> findByProvinceId(Integer id);
}
