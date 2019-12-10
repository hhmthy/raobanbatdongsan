package com.hhmthy.frontside.model;

import lombok.Data;

@Data
public class SigninResponse {
    private boolean isSuccess;
    private String token;
}
