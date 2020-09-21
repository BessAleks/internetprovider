package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.Rate;
import com.bessaleks.internetprovider.repository.RateRepository;
import com.bessaleks.internetprovider.servises.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rate")
public class RateController {

    @Autowired
    private RateRepository rateRepository;

    @PostMapping
    public String addContract(@RequestBody @Valid Rate rate) {
        rateRepository.save(rate);
        return "Rate added to DB!";
    }

    @GetMapping
    public List<Rate> getAllContracts() {
        Iterable <Rate> source = rateRepository.findAll();
        return Service.iterableToArray(source);
    }
}
