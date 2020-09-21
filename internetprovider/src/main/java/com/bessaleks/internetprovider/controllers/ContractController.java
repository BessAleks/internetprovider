package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.Contract;
import com.bessaleks.internetprovider.repository.ContractRepository;
import com.bessaleks.internetprovider.servises.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    @PostMapping
    public String addContract(@RequestBody @Valid Contract contract) {
        contractRepository.save(contract);
        return "Contract added to DB!";
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        Iterable <Contract> source = contractRepository.findAll();
        return Service.iterableToArray(source);
    }
}
