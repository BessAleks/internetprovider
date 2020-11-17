package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable (value = "id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("{id}/operations")
    public List<OperationHistoryDto> getOperations(@PathVariable (value = "id") Long id){
        return userService.getOperations(id);
    }

    @GetMapping("{id}/addresses")
    public List<AddressDto> getAddresses(@PathVariable (value = "id") Long id){
        return userService.getAddresses(id);
    }
}
