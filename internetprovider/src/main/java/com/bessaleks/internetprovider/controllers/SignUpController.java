package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signUp")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SignUpController {
    private final UserService userService;

    @PostMapping
    public void signUp(String username,String password,String phone) {
        userService.signUp(username,password,phone);
    }
}
