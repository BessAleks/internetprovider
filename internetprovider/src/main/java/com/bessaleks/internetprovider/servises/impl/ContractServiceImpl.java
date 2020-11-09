package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.entity.Address;
import com.bessaleks.internetprovider.entity.Contract;
import com.bessaleks.internetprovider.entity.Rate;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.AddressRepository;
import com.bessaleks.internetprovider.repository.ContractRepository;
import com.bessaleks.internetprovider.repository.RateRepository;
import com.bessaleks.internetprovider.servises.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final AddressRepository addressRepository;
    private final RateRepository rateRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, AddressRepository addressRepository, RateRepository rateRepository, CustomConversionService customConversionService) {
        this.contractRepository = contractRepository;
        this.addressRepository = addressRepository;
        this.rateRepository = rateRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public ContractDto createContract(Long address_id,Long rate_id,ContractDto contractDto) {
        Contract contract = customConversionService.convert(contractDto,Contract.class);
        Address address = addressRepository.findById(address_id).orElseThrow(() -> new NotFoundException("Address is not found"));
        Rate rate = rateRepository.findById(rate_id).orElseThrow(() -> new NotFoundException("Rate is not found"));
        contract.setRate(rate);
        contract.setAddress(address);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contract.getStartDate().getYear());
        stringBuilder.append(contract.getStartDate().getMonthValue());
        stringBuilder.append(contract.getStartDate().getDayOfMonth());
        stringBuilder.append("-" + address_id);
        contract.setNumber(stringBuilder.toString());
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
