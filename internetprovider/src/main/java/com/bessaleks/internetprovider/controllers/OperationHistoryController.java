package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.models.OperationsHistory;
import com.bessaleks.internetprovider.repository.OperationsHistoryRepository;
import com.bessaleks.internetprovider.servises.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("operation_history")
public class OperationHistoryController {

    @Autowired
    private OperationsHistoryRepository operationsHistoryRepository;

    @PostMapping
    public String addContract(@RequestBody @Valid OperationsHistory operationsHistory) {
        operationsHistoryRepository.save(operationsHistory);
        return "Operation added to DB!";
    }

    @GetMapping
    public List<OperationsHistory> getAllContracts() {
        Iterable <OperationsHistory> source = operationsHistoryRepository.findAll();
        return Service.iterableToArray(source);
    }
}
