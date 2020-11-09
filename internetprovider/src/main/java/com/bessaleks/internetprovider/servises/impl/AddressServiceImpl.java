package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.entity.Address;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.AddressRepository;
import com.bessaleks.internetprovider.repository.ContractRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ContractRepository contractRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository, ContractRepository contractRepository, CustomConversionService customConversionService) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.contractRepository = contractRepository;
        this.customConversionService = customConversionService;
    }
    
    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        User user = userRepository.findById(addressDto.getId()).orElseThrow(() -> new NotFoundException("User is not found"));
        Address address = customConversionService.convert(addressDto,Address.class);
        address.setUser(user);
        return customConversionService.convert(addressRepository.save(address), AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = addressRepository.findById(addressDto.getId()).orElseThrow(() -> new NotFoundException("Address is not found"));
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHouse(addressDto.getHouse());
        address.setFlat(addressDto.getFlat());
        address.setPostCode(addressDto.getPostCode());
        return customConversionService.convert(addressRepository.save(address), AddressDto.class);
    }

    @Override
    public AddressDto getAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address is not found"));
        return customConversionService.convert(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> getAll() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses.stream().map(address -> customConversionService.convert(address,AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Address is not found"));
        addressRepository.delete(address);
    }
}
