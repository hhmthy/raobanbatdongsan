package com.hhmthy.frontside.model;

import lombok.Data;
import org.springframework.hateoas.Link;

import java.util.List;

@Data
public class PostCataModel {
    private Long post_id;
    private String user_id;
    private String title;
    private int price;
    private String thumbnail;
    private String catalog;
    private String city;
    private String district;
    private String create_at;
    private List<Link> links;
}
