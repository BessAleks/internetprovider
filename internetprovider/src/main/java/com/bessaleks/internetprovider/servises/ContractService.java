package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.ContractDto;

import java.util.List;

public interface ContractService {
    ContractDto createContract(Long address_id,Long rate_id,ContractDto contractDto);
    ContractDto updateContract(ContractDto contractDto);
    ContractDto getContract(Long id);
    List<ContractDto> getAll();
    void deleteContract(Long id);
}
