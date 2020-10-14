package com.bessaleks.internetprovider.servises.impl;

import javax.transaction.Transactional;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.OperationHistoryDto;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.dto.UserDto;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.AddressRepository;
import com.bessaleks.internetprovider.repository.OperationsHistoryRepository;
import com.bessaleks.internetprovider.repository.PassportRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PassportRepository passportRepository;
    private final AddressRepository addressRepository;
    private final OperationsHistoryRepository operationsHistoryRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PassportRepository passportRepository, AddressRepository addressRepository, OperationsHistoryRepository operationsHistoryRepository, CustomConversionService customConversionService) {
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        this.addressRepository = addressRepository;
        this.operationsHistoryRepository = operationsHistoryRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = customConversionService.convert(userDto,User.class);
        user.setBalanse(0.0);
        Passport passport = customConversionService.convert(userDto.getPassportDto(), Passport.class);
        passport.setUser(user);
        customConversionService.convert(passportRepository.save(passport), PassportDto.class);
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
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User is not found"));
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
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
}

