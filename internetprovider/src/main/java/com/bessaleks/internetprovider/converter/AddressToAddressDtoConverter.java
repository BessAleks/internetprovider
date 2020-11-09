package com.bessaleks.internetprovider.converter;

import com.bessaleks.internetprovider.dto.*;
import com.bessaleks.internetprovider.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressDtoConverter implements Converter<Address, AddressDto> {
    private final CustomConversionService customConversionService;

    @Autowired
    public AddressToAddressDtoConverter(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }

    @Override
    public AddressDto convert(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHouse(address.getHouse());
        addressDto.setFlat(address.getFlat());
        addressDto.setPostCode(address.getPostCode());
        return addressDto;
    }
}
