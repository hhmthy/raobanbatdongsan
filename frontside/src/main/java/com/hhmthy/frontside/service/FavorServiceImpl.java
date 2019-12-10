package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.FavoriteModel;
import com.hhmthy.frontside.model.FavoriteSubmitModel;
import com.hhmthy.frontside.model.PostCataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavorServiceImpl implements FavoriteService {
    @Value("${resource.tasks}/userfavorite/{id}")
    private String linkRestUserFavorByUserId;

    @Value("${resource.tasks}/userfavorite/")
    private String linkRestSubmitUserFavor;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public boolean isUserFavorThisPost(String userId, Long postId) {
        List<PostCataModel> listFavorByUserId = getListFavorByUserId(userId);
        for (PostCataModel item :
                listFavorByUserId) {
            if (postId == item.getPost_id()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFavorPostOfUser(FavoriteSubmitModel favor) {
        restTemplate.postForObject(linkRestSubmitUserFavor, favor, FavoriteSubmitModel.class);
    }

    @Override
    public List<PostCataModel> getListFavorByUserId(String userId) {
        return Arrays.stream(restTemplate.getForObject(linkRestUserFavorByUserId, PostCataModel[].class, userId)).collect(Collectors.toList());
    }
}
