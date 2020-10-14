package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.dto.ContractDto;
import com.bessaleks.internetprovider.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContractToContractDtoConverter implements Converter<Contract, ContractDto> {
    private final CustomConversionService customConversionService;

    @Autowired
    public ContractToContractDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public ContractDto convert(Contract contract) {
        ContractDto contractDto = new ContractDto();
        contractDto.setNumber(contract.getNumber());
        contractDto.setStartDate(contract.getStartDate());
        contractDto.setAddressDto(customConversionService.convert(contract.getAddress(), AddressDto.class));
        return contractDto;
    }
}
