package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(Long id);
    List<UserDto> getAll();
    UserDto updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);
    List<OperationHistoryDto> getOperations(Long id);
}
