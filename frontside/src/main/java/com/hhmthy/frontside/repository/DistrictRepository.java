package com.hhmthy.frontside.repository;

import com.hhmthy.frontside.entity.DistrictEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends CrudRepository<DistrictEntity, Integer> {
    List<DistrictEntity> findByNameContaining(String name);

    List<DistrictEntity> findByProvinceId(Integer provinceId);
}
