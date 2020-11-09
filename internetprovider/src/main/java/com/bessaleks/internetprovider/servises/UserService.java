package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.Address;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto,String password);
    UserDto getUser(Long id);
    List<UserDto> getAll();
    UserDto updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);
    List<OperationHistoryDto> getOperations(Long id);
    List<AddressDto> getAddresses(Long id);
    UserDto signUp(String username, String password, String phone);
}
