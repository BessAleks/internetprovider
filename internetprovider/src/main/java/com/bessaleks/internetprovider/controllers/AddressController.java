package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.Address;
import com.bessaleks.internetprovider.repository.AddressRepository;
import com.bessaleks.internetprovider.servises.Service;
import com.bessaleks.internetprovider.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public String addAddress(@RequestBody @Valid Address address) {
            addressRepository.save(address);
            return "Address added to DB!";
    }

    @GetMapping
    public List<Address> getAllAddress() {
        Iterable <Address> source = addressRepository.findAll();
        return Service.iterableToArray(source);
    }

}
