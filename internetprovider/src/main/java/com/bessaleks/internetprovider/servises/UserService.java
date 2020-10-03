package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getUser(Long id);
    List<UserDto> getAll();
    void deleteUser(Long id);
}
