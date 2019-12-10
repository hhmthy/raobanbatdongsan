package com.hhmthy.authentication.Controller;

import com.hhmthy.authentication.Entity.UserEntity;
import com.hhmthy.authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class authenticationController {
    @Autowired
    UserService userService;

    @PostMapping("/login/request")
    public String requestLogin(@ModelAttribute("User") UserEntity userEntity, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "";
        }
        return "";
    }
}
