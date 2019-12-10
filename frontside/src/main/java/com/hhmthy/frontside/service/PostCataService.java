package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.PostCataModel;

import java.util.List;

public interface PostCataService {
    public List<PostCataModel> getAllPostCata();

    public List<PostCataModel> getAllPostCataByUserId(Long userid);
}
