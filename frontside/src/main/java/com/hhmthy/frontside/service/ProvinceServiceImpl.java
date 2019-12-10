package com.hhmthy.frontside.service;

import com.hhmthy.frontside.entity.ProvinceEntity;
import com.hhmthy.frontside.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<ProvinceEntity> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public List<ProvinceEntity> search(String term) {
        return provinceRepository.findByNameContaining(term);
    }

    @Override
    public Optional<ProvinceEntity> findOne(Integer id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(ProvinceEntity provinceEntity) {
        provinceRepository.save(provinceEntity);
    }

    @Override
    public void delete(Integer id) {
        provinceRepository.deleteById(id);
    }
}
