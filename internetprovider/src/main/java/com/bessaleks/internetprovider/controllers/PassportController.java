package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.Passport;
import com.bessaleks.internetprovider.repository.PassportRepository;
import com.bessaleks.internetprovider.servises.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private PassportRepository passportRepository;

    @PostMapping
    public String addContract(@RequestBody @Valid Passport passport) {
        passportRepository.save(passport);
        return "Passport added to DB!";
    }

    @GetMapping
    public List<Passport> getAllContracts() {
        Iterable <Passport> source = passportRepository.findAll();
        return Service.iterableToArray(source);
    }
}
