package com.bessaleks.internetprovider.servises;

import com.bessaleks.internetprovider.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    AddressDto updateAddress(AddressDto addressDto);
    AddressDto getAddress(Long id);
    List<AddressDto> getAll();
    void deleteAddress(Long id);
}
