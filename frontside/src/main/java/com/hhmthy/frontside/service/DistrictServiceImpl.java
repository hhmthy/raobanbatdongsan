package com.hhmthy.frontside.service;

import com.hhmthy.frontside.entity.DistrictEntity;
import com.hhmthy.frontside.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Iterable<DistrictEntity> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<DistrictEntity> search(String term) {
        return districtRepository.findByNameContaining(term);
    }

    @Override
    public Optional<DistrictEntity> findOne(Integer id) {
        return districtRepository.findById(id);
    }

    @Override
    public void save(DistrictEntity districtEntity) {
        districtRepository.save(districtEntity);
    }

    @Override
    public void delete(Integer id) {
        districtRepository.deleteById(id);
    }

    @Override
    public List<DistrictEntity> findByProvinceId(@Param("province_id") Integer provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }
}
