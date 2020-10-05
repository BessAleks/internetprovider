package com.bessaleks.internetprovider.servises.impl;

import com.bessaleks.internetprovider.converter.CustomConversionService;
import com.bessaleks.internetprovider.dto.PassportDto;
import com.bessaleks.internetprovider.entity.Passport;
import com.bessaleks.internetprovider.repository.PassportRepository;
import com.bessaleks.internetprovider.servises.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final CustomConversionService customConversionService;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository, CustomConversionService customConversionService) {
        this.passportRepository = passportRepository;
        this.customConversionService = customConversionService;
    }

    @Override
    public PassportDto createPassport(PassportDto passportDto) {
        Passport passport = customConversionService.convert(passportDto,Passport.class);
        return customConversionService.convert(passportRepository.save(passport), PassportDto.class);
    }

    @Override
    public PassportDto updatePassport(PassportDto passportDto) {
        return null;
    }

    @Override
    public PassportDto getPassport(Long id) {
        return null;
    }

    @Override
    public List<PassportDto> getAll() {
        return null;
    }

    @Override
    public void deletePassport(Long id) {

    }
}
