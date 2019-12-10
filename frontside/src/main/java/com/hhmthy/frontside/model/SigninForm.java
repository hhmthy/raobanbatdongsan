package com.hhmthy.frontside.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninForm {
    @Size(min = 6, max = 20, message = "Tên tài khoản chứa từ 6 đến 20 ký tự")
    private String username;
    @Size(min = 8, max = 32, message = "Mật khẩu chứa từ 8 đến 32 ký tự")
    private String password;
}
