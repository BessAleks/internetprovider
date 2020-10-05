package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class UserController {

    private final UserService userService;

    @GetMapping("test")
    public String getTest(@PathParam("id") Long num, String text) {
        return "TEST!TEST!TEST! " + num*100 + " " + text;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("id")
    public UserDto getUser(@PathParam("id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

}
