package com.hhmthy.frontside.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostHouseModel {
    private String user_id;
    private String catalog;
    private String title;
    private String content;
    private int price;
    private int area;
    private String thumbnail;
    private String image_url;
    private String city;
    private String district;
    private String address;
    private String location;
    private String certification;
    private String direction;
    private int rating;
    private String house_level;
    private int floor;
    private int restroom;
    private int bedroom;
}
