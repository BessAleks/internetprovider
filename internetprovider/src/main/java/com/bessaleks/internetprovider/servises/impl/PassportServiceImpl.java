package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.entity.User;
import com.bessaleks.internetprovider.exeptions.NotFoundException;
import com.bessaleks.internetprovider.repository.PassportRepository;
import com.bessaleks.internetprovider.repository.UserRepository;
import com.bessaleks.internetprovider.servises.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final UserRepository userRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository, UserRepository userRepository, CustomConversionService customConversionService) {
        this.passportRepository = passportRepository;
        this.userRepository = userRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public PassportDto createPassport(PassportDto passportDto) {
        User user = userRepository.findById(passportDto.getUserDto().getId()).orElseThrow(() -> new NotFoundException("User is not found"));
        Passport passport = customConversionService.convert(passportDto,Passport.class);
        passport.setUser(user);
        return customConversionService.convert(passportRepository.save(passport), PassportDto.class);
    }

    @Override
    public PassportDto updatePassport(PassportDto passportDto) {
        Passport passport = passportRepository.findById(passportDto.getId()).orElseThrow(() -> new NotFoundException("Passport is not found"));
        passport.setName(passportDto.getName());
        passport.setSurname(passport.getSurname());
        passport.setLastName(passportDto.getLastName());
        passport.setPassportNumber(passportDto.getPassportNumber());
        passport.setPassportIssuedBy(passportDto.getPassportIssuedBy());
        passport.setPassportIssued(passportDto.getPassportIssued());
        passport.setBirthday(passportDto.getBirthday());
        passport.setSex(passportDto.getSex());
        return customConversionService.convert(passportRepository.save(passport), PassportDto.class);
    }

    @Override
    public PassportDto getPassport(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new NotFoundException("Passport is not found"));
        return customConversionService.convert(passport, PassportDto.class);
    }

    @Override
    public List<PassportDto> getAll() {
        List<Passport> passports = (List<Passport>) passportRepository.findAll();
        return passports.stream().map(passport -> customConversionService.convert(passport,PassportDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deletePassport(Long id) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new NotFoundException("Passport is not found"));
        passportRepository.delete(passport);
    }
}
