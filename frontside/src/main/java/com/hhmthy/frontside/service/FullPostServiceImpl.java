package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.FullPostModel;
import com.hhmthy.frontside.model.PostHouseModel;
import com.hhmthy.frontside.model.PostHouseNewAPIModel;
import com.hhmthy.frontside.model.PostLandNewAPIModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class FullPostServiceImpl implements FullPostService {
    @Value("${resource.tasks}/post/{id}")
    private String linkRestPostCata;

    @Value("${resource.tasks}/post/house/")
    private String linkRestSubmitSaleHouse;

    @Value("${resource.tasks}/post/land/")
    private String linkRestSubmitSaleLand;

    @Value("${resource.tasks}/post/house/{id}")
    private String linkRestGetSaleHouse;

    @Value("${resource.tasks}/post/land/{id}")
    private String linkRestGetSaleLand;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FullPostModel getAFullPost(Long id) {
        return restTemplate.getForObject(linkRestPostCata, FullPostModel.class, id);
    }

    @Override
    public PostHouseNewAPIModel getAFullPostHouse(Long id) {
        return restTemplate.getForObject(linkRestGetSaleHouse, PostHouseNewAPIModel.class, id);
    }

    @Override
    public PostLandNewAPIModel getAFullPostLand(Long id) {
        return restTemplate.getForObject(linkRestGetSaleLand, PostLandNewAPIModel.class, id);
    }

    @Override
    public void addAFullPostSaleHouse(PostHouseModel postHouseModel) {
        restTemplate.postForObject(linkRestSubmitSaleHouse, postHouseModel, PostHouseModel.class);
    }
}
