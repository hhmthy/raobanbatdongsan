package com.hhmthy.frontside.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCreatePostModel {
    private int typeOfPost;
    private int typeOfRe;
}
