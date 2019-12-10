package com.hhmthy.frontside.service;

import com.hhmthy.frontside.model.PostCataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostCataServiceImpl implements PostCataService {
    @Value("${resource.tasks}/post/")
    private String linkRestPostCata;

    @Value("${resource.tasks}/personal/post/{id}")
    private String linkRestPostCataByUserId;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<PostCataModel> getAllPostCata() {
        return Arrays.stream(restTemplate.getForObject(linkRestPostCata, PostCataModel[].class)).collect(Collectors.toList());
    }

    @Override
    public List<PostCataModel> getAllPostCataByUserId(Long userid) {
        String userIdToString = String.valueOf(userid);

        return Arrays.stream(restTemplate.getForObject(linkRestPostCataByUserId, PostCataModel[].class, userIdToString)).collect(Collectors.toList());
    }

}
