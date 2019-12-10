package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.FullPostModel;
import com.hhmthy.frontside.model.PostHouseModel;
import com.hhmthy.frontside.model.PostHouseNewAPIModel;
import com.hhmthy.frontside.model.PostLandNewAPIModel;

import java.util.Map;

public interface FullPostService {
    public FullPostModel getAFullPost(Long id);

    public PostHouseNewAPIModel getAFullPostHouse(Long id);

    public PostLandNewAPIModel getAFullPostLand(Long id);

    public void addAFullPostSaleHouse(PostHouseModel postHouseModel);
}
