package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.entity.Contract;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContractDtoToContractConverter implements Converter<ContractDto, Contract> {
    @Override
    public Contract convert(ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setNumber(contractDto.getNumber());
        contract.setStartDate(contractDto.getStartDate());
        return contract;
    }
}
