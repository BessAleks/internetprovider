package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.User;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.Service;
import com.bessaleks.internetprovider.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String addUser(@RequestBody @Valid User user) {
        if(!userRepository.existsByLogin(user.getLogin())) {
            user.setPassword(UserService.md5Apache(user.getPassword()));
            userRepository.save(user);
            return "User added successful!";
        }
        else {
            return "User with this userLogin added to DB!";
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        Iterable <User> source = userRepository.findAll();
        return Service.iterableToArray(source);
    }
}
