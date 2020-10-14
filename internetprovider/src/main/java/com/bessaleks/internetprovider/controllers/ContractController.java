package com.bessaleks.internetprovider.controllers;

import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.servises.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("contract")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    public ContractDto createContract(@RequestBody ContractDto contractDto) {
        return contractService.createContract(contractDto);
    }

    @GetMapping
    public List<ContractDto> getAll() {
        return contractService.getAll();
    }

    @GetMapping("id")
    public ContractDto getContract(@PathParam("id") Long id) {
        return contractService.getContract(id);
    }

    @PutMapping
    public ContractDto updateContract(@RequestBody ContractDto contractDto) {
        return contractService.updateContract(contractDto);
    }

    @DeleteMapping
    public void deleteContract(@PathParam("id") Long id) {
        contractService.deleteContract(id);
    }
}
