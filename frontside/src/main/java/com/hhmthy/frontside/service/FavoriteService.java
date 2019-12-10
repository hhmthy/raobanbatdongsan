package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.FavoriteModel;
import com.hhmthy.frontside.model.FavoriteSubmitModel;
import com.hhmthy.frontside.model.PostCataModel;

import java.util.List;

public interface FavoriteService {
    public boolean isUserFavorThisPost(String userId, Long postId);

    public void addFavorPostOfUser(FavoriteSubmitModel favor);

    public List<PostCataModel> getListFavorByUserId(String userId);
}
