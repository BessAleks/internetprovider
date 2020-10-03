package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.servises.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class AddressController {

    private AddressService addressService;

    @PostMapping
    public AddressDto createAddress(@RequestBody AddressDto addressDto) {
        return addressService.createAddress(addressDto);
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @GetMapping("id")
    public AddressDto getAddress(@PathParam("id") Long id) {
        return addressService.getAddress(id);
    }

    @PutMapping
    public AddressDto updateAddress(@RequestBody AddressDto addressDto) {
        return addressService.updateAddress(addressDto);
    }

    @DeleteMapping
    public void deleteAddress(@PathParam("id") Long id) {
        addressService.deleteAddress(id);
    }

}
