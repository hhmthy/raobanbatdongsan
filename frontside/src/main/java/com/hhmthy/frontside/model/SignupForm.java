package com.hhmthy.frontside.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupForm {

    private String firstName;

    private String lastName;

    @Size(min = 6, max = 20, message = "Tên tài khoản phải từ 6 đến 20 ký tự")
    private String username;

    @Size(min = 8, max = 32, message = "Mật khẩu phải từ 8 đến 32 ký tự")
    private String password;

    @Size(min = 8, max = 32, message = "Mật khẩu phải từ 8 đến 32 ký tự")
    private String rePassword;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Sinh nhật phải trước ngày hiện tại")
    private Date birthday;

    private String address;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Email không đúng định dạng")
    private String email;

    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Số điện thoại chưa đúng định dạng")
    private String phoneNumber;
}
