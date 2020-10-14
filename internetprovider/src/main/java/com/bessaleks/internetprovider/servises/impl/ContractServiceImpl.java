package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.entity.Contract;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.ContractRepository;
import com.bessaleks.internetprovider.servises.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, CustomConversionService customConversionService) {
        this.contractRepository = contractRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public ContractDto createContract(ContractDto contractDto) {
        Contract contract = customConversionService.convert(contractDto,Contract.class);
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        return customConversionService.convert(contractRepository.save(contract), ContractDto.class);
    }

    @Override
    public ContractDto updateContract(ContractDto contractDto) {
        Contract contract = contractRepository.findById(contractDto.getId()).orElseThrow(() -> new NotFoundException("Contract is not found"));
        contract.setNumber(contractDto.getNumber());
        contract.setStartDate(contractDto.getStartDate());
        return customConversionService.convert(contractRepository.save(contract), ContractDto.class);
    }

    @Override
    public ContractDto getContract(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new NotFoundException("Contract is not found"));
        return customConversionService.convert(contract, ContractDto.class);
    }

    @Override
    public List<ContractDto> getAll() {
        List<Contract> contracts = (List<Contract>) contractRepository.findAll();
        return contracts.stream().map(contract -> customConversionService.convert(contract,ContractDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteContract(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new NotFoundException("Contract is not found"));
        contractRepository.delete(contract);
    }
}
