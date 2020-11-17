package com.bessaleks.internetprovider.servises.impl;

import javax.transaction.Transactional;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.AddressDto;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.*;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.*;
import com.bessaleks.internetprovider.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PassportRepository passportRepository;
    private final AddressRepository addressRepository;
    private final OperationsHistoryRepository operationsHistoryRepository;
    private final CustomConversionService customConversionService;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PassportRepository passportRepository, AddressRepository addressRepository, OperationsHistoryRepository operationsHistoryRepository, CustomConversionService customConversionService, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        this.addressRepository = addressRepository;
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.customConversionService = customConversionService;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = customConversionService.convert(userDto,User.class);
        String password = "admin";
        user.setBalanse(new BigDecimal(0));
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(user.getEmail());
        customUserDetails.setPassword(passwordEncoder.encode(password));
        customUserDetails.setAuthorities(Collections.singletonList(authorityRepository.findByAuthority("ROLE_ADMIN")));
        customUserDetails.setUser(user);
        user.setCustomUserDetails(customUserDetails);
        return customConversionService.convert(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        return customConversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(user -> customConversionService.convert(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new NotFoundException("User is not found"));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return customConversionService.convert(userRepository.save(user),UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
    userRepository.delete(user);
    }

    @Override
    public List<OperationHistoryDto> getOperations(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        List<OperationsHistory> operationsHistories = operationsHistoryRepository.findByUser(user);
        return operationsHistories.stream().map(operationsHistory -> customConversionService.convert(operationsHistory,OperationHistoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AddressDto> getAddresses(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        List<Address> addresses = addressRepository.findByUser(user);
        return addresses.stream().map(address -> customConversionService.convert(address,AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto signUp(String email, String password, String phone) {
        User user = new User();
        user.setEmail(email);
        user.setPhone(phone);
        user.setBalanse(new BigDecimal(0));
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(email);
        customUserDetails.setPassword(passwordEncoder.encode(password));
        customUserDetails.setAuthorities(Collections.singletonList(authorityRepository.findByAuthority("ROLE_ADMIN")));
        customUserDetails.setUser(user);
        user.setCustomUserDetails(customUserDetails);
        return customConversionService.convert(userRepository.save(user), UserDto.class);
    }
}

